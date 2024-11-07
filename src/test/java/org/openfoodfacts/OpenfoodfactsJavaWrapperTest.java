package org.openfoodfacts;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openfoodfacts.exception.OpenFoodsFactsException;
import org.openfoodfacts.model.KnowledgePanelsResponse;
import org.openfoodfacts.model.ProductResponse;
import org.openfoodfacts.service.OpenFoodFactsWrapper;
import org.openfoodfacts.client.OpenFoodFactsApiReadClient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@MicronautTest
class OpenfoodfactsJavaWrapperTest {

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    OpenFoodFactsWrapper openFoodFactsWrapper;

    @Test
    void testFetchProductByBarcodeOK() throws Exception {
        ProductResponse productResponse = openFoodFactsWrapper.fetchProductByBarcode("3017620422003");

        log.info("Response {}", productResponse);
        assertNotNull(productResponse);
    }

    @Test
    void testFetchProductByBarcodeKO() throws Exception {

        OpenFoodsFactsException exception = assertThrows(OpenFoodsFactsException.class, () -> {
            openFoodFactsWrapper.fetchProductByBarcode("nonExistingBarcode");
        });

        log.info("Exception message: {}", exception.getLocalizedMessage());
        assertEquals("no code or invalid code", exception.getLocalizedMessage());
    }

    @Test
    void testGetProductKnowledgePanelsByBarcodeOK() {
        KnowledgePanelsResponse knowledgePanelsByCode = openFoodFactsWrapper.getProductKnowledgePanelsByBarcode("3017620422003");

        assertNotNull(knowledgePanelsByCode);
        assertEquals("product found", knowledgePanelsByCode.getStatusVerbose());

    }

    @MockBean(OpenFoodFactsApiReadClient.class)
    OpenFoodFactsApiReadClient mocktestGetProductKnowledgePanelsByBarcodeOK() throws IOException {
        String responseBody = new String(Files.readAllBytes(Paths.get("src/test/resources/responses/getProductKnowledgePanelsByBarcodeOK.json")));

        OpenFoodFactsApiReadClient client = Mockito.mock(OpenFoodFactsApiReadClient.class);

        Mockito.when(client.getProductKnowledgePanelsByBarcode("3017620422003"))
                .thenReturn(new ObjectMapper().readValue(responseBody, KnowledgePanelsResponse.class));

        return client;
    }



    @MockBean(OpenFoodFactsApiReadClient.class)
    OpenFoodFactsApiReadClient mocktestFetchProductByBarcodeKO() throws IOException {
        String responseBody = new String(Files.readAllBytes(Paths.get("src/test/resources/responses/fetchProductByBarcodeKO.json")));

        OpenFoodFactsApiReadClient client = Mockito.mock(OpenFoodFactsApiReadClient.class);

        Mockito.when(client.fetchProductByBarcode("nonexistingbarcode"))
                .thenReturn(new ObjectMapper().readValue(responseBody, ProductResponse.class));

        return client;
    }

    @MockBean(OpenFoodFactsApiReadClient.class)
    OpenFoodFactsApiReadClient mocktestFetchProductByBarcodeOK() throws IOException {
        String responseBody = new String(Files.readAllBytes(Paths.get("src/test/resources/responses/fetchProductByBarcodeOK.json")));

        OpenFoodFactsApiReadClient client = Mockito.mock(OpenFoodFactsApiReadClient.class);

        Mockito.when(client.fetchProductByBarcode("3017620422003"))
                .thenReturn(new ObjectMapper().readValue(responseBody, ProductResponse.class));

        return client;
    }


}
