package org.openfoodfacts.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.micronaut.http.client.HttpClient;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.openfoodfacts.client.OpenFoodFactsApiReadClient;
import org.openfoodfacts.model.Product;
import org.openfoodfacts.service.OpenFoodFactsWrapper;

@Slf4j
@Singleton
public final class OpenFoodFactsWrapperImpl implements OpenFoodFactsWrapper {

  private final OpenFoodFactsApiReadClient client;

  public OpenFoodFactsWrapperImpl() {
    this.client = new OpenFoodFactsApiReadClient(HttpClient.create(null));
  }

  @Override
  public Product fetchProductByCode(String code) throws JsonProcessingException {
    return client.fetchProductByCode(code);
  }

}
