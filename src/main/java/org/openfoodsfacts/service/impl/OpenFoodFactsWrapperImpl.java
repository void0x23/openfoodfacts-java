package org.openfoodsfacts.service.impl;

import io.micronaut.http.client.HttpClient;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.openfoodsfacts.client.OpenFoodFactsApiReadClient;
import org.openfoodsfacts.model.ProductResponse;
import org.openfoodsfacts.service.OpenFoodFactsWrapper;

@Slf4j
@Singleton
public final class OpenFoodFactsWrapperImpl implements OpenFoodFactsWrapper {

  private final OpenFoodFactsApiReadClient client;

  public OpenFoodFactsWrapperImpl(HttpClient httpClient) {
    this.client = new OpenFoodFactsApiReadClient(httpClient);
  }

  @Override
  public ProductResponse fetchProductByCode(String code) {
    return client.fetchProductByCode(code);
  }
}
