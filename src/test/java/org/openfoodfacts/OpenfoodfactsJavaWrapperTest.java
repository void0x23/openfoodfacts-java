package org.openfoodfacts;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openfoodfacts.model.ProductResponse;
import org.openfoodfacts.client.OpenFoodFactsApiReadClient;
import org.openfoodfacts.service.impl.OpenFoodFactsWrapperImpl;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
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

   /* @Test
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
    }*/
}
