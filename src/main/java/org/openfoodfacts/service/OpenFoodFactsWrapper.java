
package org.openfoodfacts.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.openfoodfacts.model.Product;

public interface OpenFoodFactsWrapper {


/**
   * Returns product by code.
   *
   * @param code product code
   * @return product
   */
    Product fetchProductByCode(String code) throws JsonProcessingException;

}

