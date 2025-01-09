package org.openfoodfacts.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.openfoodfacts.client.OpenFoodFactsApiReadClient;
import org.openfoodfacts.model.KnowledgePanelsResponse;
import org.openfoodfacts.model.ProductResponse;
import org.openfoodfacts.service.OpenFoodFactsWrapper;

import java.io.IOException;
import java.net.http.HttpClient;

@Slf4j
public final class OpenFoodFactsWrapperImpl implements OpenFoodFactsWrapper {

  private final OpenFoodFactsApiReadClient client;

  public OpenFoodFactsWrapperImpl() throws IOException {
    this.client = new OpenFoodFactsApiReadClient(HttpClient.newHttpClient());
  }

  @Override
  public ProductResponse fetchProductByBarcode(String code) throws IOException, InterruptedException {
    return client.fetchProductByBarcode(code);
  }

  @Override
  public KnowledgePanelsResponse getProductKnowledgePanelsByBarcode(String code) throws IOException, InterruptedException {
    return client.getProductKnowledgePanelsByBarcode(code);
  }

}
