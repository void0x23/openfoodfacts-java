
package org.openfoodfacts.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.openfoodfacts.model.KnowledgePanelsResponse;
import org.openfoodfacts.model.ProductResponse;

public interface OpenFoodFactsWrapper {


/**
   * Returns product by code.
   *
   * @param code product code
   * @return product
   */
    ProductResponse fetchProductByCode(String code);

    KnowledgePanelsResponse getProductKnowledgePanelsByCode(String code);
}

