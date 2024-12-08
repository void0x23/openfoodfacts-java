
package org.openfoodfacts.service;


import org.openfoodfacts.model.KnowledgePanelsResponse;
import org.openfoodfacts.model.ProductResponse;

import java.io.IOException;

public interface OpenFoodFactsWrapper {


   /**
   * Returns product by code.
   *
   * @param code product code
   * @return product
   */
    ProductResponse fetchProductByBarcode(String code) throws IOException, InterruptedException;

    /**
     * Returns knowledge panel info about the product speficied by barcode
     *
     * @param code product code
     * @return product
     */
    KnowledgePanelsResponse getProductKnowledgePanelsByBarcode(String code) throws IOException, InterruptedException;
}

