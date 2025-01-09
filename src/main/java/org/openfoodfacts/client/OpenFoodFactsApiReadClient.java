package org.openfoodfacts.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.openfoodfacts.config.ConfigurationManager;
import org.openfoodfacts.exception.OpenFoodsFactsException;
import org.openfoodfacts.model.KnowledgePanelsResponse;
import org.openfoodfacts.model.ProductResponse;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.time.Duration;

import static org.openfoodfacts.utils.ApiReadClientUtil.*;

@Slf4j
public class OpenFoodFactsApiReadClient {

  private final HttpClient httpClient;
  private final ConfigurationManager configurationManager;

  public OpenFoodFactsApiReadClient(HttpClient httpClient) throws IOException {
    this.httpClient = httpClient;
    this.configurationManager = new ConfigurationManager();
  }

  public ProductResponse fetchProductByBarcode(String code) throws IOException, InterruptedException {

    String barcode = checkBarcode(code);

    String url = String.format("%s/%s/%s.json", configurationManager.getBaseSearchUrl(), configurationManager.getProductContextpath(), barcode);

    HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .timeout(Duration.ofSeconds(configurationManager.getReadTimeout()))
                .GET()
                .build();

    HttpResponse<String> response;
    try {
      response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    } catch (HttpTimeoutException | SocketTimeoutException e) {
      throw new OpenFoodsFactsException("Request timed out while fetching the product by barcode: " + barcode);
    }

    checkHttpStatus(response);

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
            .timeout(Duration.ofSeconds(configurationManager.getReadTimeout()))
            .GET()
            .build();

    HttpResponse<String> response;

    try {
      response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    } catch (HttpTimeoutException | SocketTimeoutException e) {
      throw new OpenFoodsFactsException("Request timed out while fetching the product by barcode: " + barcode);
    }

    checkHttpStatus(response);

    ObjectMapper objectMapper = new ObjectMapper();
    KnowledgePanelsResponse knowledgePanelsResponse = objectMapper.readValue(response.body(), KnowledgePanelsResponse.class);

    checkResponseStatus(knowledgePanelsResponse);

    return knowledgePanelsResponse;
  }


}
