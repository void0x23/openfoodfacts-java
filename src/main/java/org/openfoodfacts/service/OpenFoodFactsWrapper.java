
package org.openfoodfacts.service;


import org.openfoodfacts.model.KnowledgePanelsResponse;
import org.openfoodfacts.model.ProductResponse;

public interface OpenFoodFactsWrapper {


/**
   * Returns product by code.
   *
   * @param code product code
   * @return product
   */
    ProductResponse fetchProductByBarcode(String code);

    KnowledgePanelsResponse getProductKnowledgePanelsByBarcode(String code);
}

