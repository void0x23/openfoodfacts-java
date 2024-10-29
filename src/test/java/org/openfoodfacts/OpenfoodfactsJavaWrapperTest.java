package org.openfoodfacts;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openfoodfacts.model.Product;
import org.openfoodfacts.service.OpenFoodFactsWrapper;
import org.openfoodfacts.service.impl.OpenFoodFactsWrapperImpl;


@Slf4j
@MicronautTest
class OpenfoodfactsJavaWrapperTest {

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testFectchProductByBarcode() throws JsonProcessingException {


        OpenFoodFactsWrapper openFoodFactsWrapper = new OpenFoodFactsWrapperImpl();

        Product product = openFoodFactsWrapper.fetchProductByCode("3017620422003");

        /*log.info("Product {}", product);*/
    }

}
