package org.openfoodfacts.service.impl;

import io.micronaut.http.client.HttpClient;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.openfoodfacts.client.OpenFoodFactsApiReadClient;
import org.openfoodfacts.model.KnowledgePanelsResponse;
import org.openfoodfacts.model.ProductResponse;
import org.openfoodfacts.service.OpenFoodFactsWrapper;

@Slf4j
@Singleton
public final class OpenFoodFactsWrapperImpl implements OpenFoodFactsWrapper {

  private final OpenFoodFactsApiReadClient client;

  public OpenFoodFactsWrapperImpl() {
    this.client = new OpenFoodFactsApiReadClient(HttpClient.create(null));
  }

  @Override
  public ProductResponse fetchProductByBarcode(String code) {
    return client.fetchProductByBarcode(code);
  }

  @Override
  public KnowledgePanelsResponse getProductKnowledgePanelsByBarcode(String code) {
    return client.getProductKnowledgePanelsByBarcode(code);
  }

}
