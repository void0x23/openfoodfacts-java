package org.openfoodfacts.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.openfoodfacts.config.ConfigurationManager;
import org.openfoodfacts.model.KnowledgePanelsResponse;
import org.openfoodfacts.model.ProductResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.openfoodfacts.utils.ApiReadClientUtil.checkBarcode;
import static org.openfoodfacts.utils.ApiReadClientUtil.checkResponseStatus;

@Slf4j
public class OpenFoodFactsApiReadClient {

  private final HttpClient httpClient;
  private ConfigurationManager configurationManager;

  public OpenFoodFactsApiReadClient() throws IOException {
    this.httpClient = HttpClient.newHttpClient();
    this.configurationManager = new ConfigurationManager();
  }

  public ProductResponse fetchProductByBarcode(String code) throws IOException, InterruptedException {

    String barcode = checkBarcode(code);

    String url = String.format("%s/%s/%s.json", configurationManager.getBaseSearchUrl(), configurationManager.getProductContextpath(), barcode);

    HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .GET()
                .build();

    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    ObjectMapper objectMapper = new ObjectMapper();
    ProductResponse productResponse = objectMapper.readValue(response.body(), ProductResponse.class);

    checkResponseStatus(productResponse);

    return productResponse;
  }

  public KnowledgePanelsResponse getProductKnowledgePanelsByBarcode(String code) throws IOException, InterruptedException {

    String barcode = checkBarcode(code);

    String url = String.format("%s/%s/%s.json?fields=%s", configurationManager.getBaseSearchUrl(), configurationManager.getProductContextpath(), barcode, configurationManager.getKnowledgePanels());

    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Content-Type", "application/json")
            .GET()
            .build();

    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    ObjectMapper objectMapper = new ObjectMapper();
    KnowledgePanelsResponse knowledgePanelsResponse = objectMapper.readValue(response.body(), KnowledgePanelsResponse.class);

    checkResponseStatus(knowledgePanelsResponse);

    return knowledgePanelsResponse;
  }


}
