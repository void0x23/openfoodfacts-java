package org.openfoodfacts;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openfoodfacts.exception.OpenFoodsFactsException;
import org.openfoodfacts.model.KnowledgePanelsResponse;
import org.openfoodfacts.model.ProductResponse;
import org.openfoodfacts.client.OpenFoodFactsApiReadClient;
import org.openfoodfacts.service.impl.OpenFoodFactsWrapperImpl;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Slf4j
class OpenfoodfactsJavaWrapperTest {

    @Mock
    OpenFoodFactsApiReadClient openFoodFactsApiReadClient;

    @InjectMocks
    private OpenFoodFactsWrapperImpl openFoodFactsWrapperImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFetchProductByBarcodeOK() throws Exception {
        String responseBody = new String(Files.readAllBytes(Paths.get("src/test/resources/responses/fetchProductByBarcodeOK.json")));
        ProductResponse mockResponse = new ObjectMapper().readValue(responseBody, ProductResponse.class);

        when(openFoodFactsApiReadClient.fetchProductByBarcode("3017620422003")).thenReturn(mockResponse);

        ProductResponse productResponse = openFoodFactsWrapperImpl.fetchProductByBarcode("3017620422003");

        assertNotNull(productResponse);
        assertEquals("3017620422003", productResponse.getProduct().get_id());
    }

    @Test
    void testFetchProductByBarcodeKO() throws Exception {
        String responseBody = new String(Files.readAllBytes(Paths.get("src/test/resources/responses/fetchProductByBarcodeKO.json")));
        ProductResponse mockResponse = new ObjectMapper().readValue(responseBody, ProductResponse.class);

        when(openFoodFactsApiReadClient.fetchProductByBarcode("nonexistingbarcode")).thenReturn(mockResponse);

        OpenFoodsFactsException exception = assertThrows(OpenFoodsFactsException.class, () -> {
            openFoodFactsWrapperImpl.fetchProductByBarcode("nonexistingbarcode");
        });

        assertEquals("no code or invalid code", exception.getLocalizedMessage());
    }

    @Test
    void testGetProductKnowledgePanelsByBarcodeOK() throws Exception {
        String responseBody = new String(Files.readAllBytes(Paths.get("src/test/resources/responses/getProductKnowledgePanelsByBarcodeOK.json")));
        KnowledgePanelsResponse mockResponse = new ObjectMapper().readValue(responseBody, KnowledgePanelsResponse.class);

        when(openFoodFactsApiReadClient.getProductKnowledgePanelsByBarcode("3017620422003")).thenReturn(mockResponse);

        KnowledgePanelsResponse knowledgePanelsByCode = openFoodFactsWrapperImpl.getProductKnowledgePanelsByBarcode("3017620422003");

        assertNotNull(knowledgePanelsByCode);
        assertEquals("product found", knowledgePanelsByCode.getStatusVerbose());
        assertEquals("E322 - Lecithins", knowledgePanelsByCode.getProduct().getKnowledgePanels().getPanels().get("additive_en:e322").getTitleElement().getTitle());
    }

    @Test
    void testGetProductKnowledgePanelsByBarcodeKO() throws Exception {
        String responseBody = new String(Files.readAllBytes(Paths.get("src/test/resources/responses/fetchProductByBarcodeKO.json")));
        ProductResponse mockResponse = new ObjectMapper().readValue(responseBody, ProductResponse.class);

        when(openFoodFactsApiReadClient.fetchProductByBarcode("nonexistingbarcode")).thenReturn(mockResponse);

        OpenFoodsFactsException exception = assertThrows(OpenFoodsFactsException.class, () -> {
            openFoodFactsWrapperImpl.fetchProductByBarcode("nonexistingbarcode");
        });

        assertEquals("no code or invalid code", exception.getLocalizedMessage());
    }


    @Test
    public void testFetchProductByBarcodeTimeout() throws IOException, InterruptedException {
        HttpClient httpClient = mock(HttpClient.class);
        HttpRequest request = mock(HttpRequest.class);

        openFoodFactsApiReadClient = new OpenFoodFactsApiReadClient(httpClient);

        when(httpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenThrow(new HttpTimeoutException("Timeout"));

        OpenFoodsFactsException thrown = assertThrows(OpenFoodsFactsException.class, () -> {
            openFoodFactsApiReadClient.fetchProductByBarcode("123456");
        });

        assertEquals("Request timed out while fetching the product by barcode: 123456", thrown.getMessage());
    }





}
