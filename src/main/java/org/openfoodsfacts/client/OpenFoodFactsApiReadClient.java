package org.openfoodsfacts.client;

import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Singleton;
import org.openfoodsfacts.model.ProductResponse;

@Singleton
public class OpenFoodFactsApiReadClient {

  @Value("${openfoodsfacts.api.url.read}")
  private String readApiUrl;

  private final HttpClient httpClient;

  public OpenFoodFactsApiReadClient(@Client HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  public ProductResponse fetchProductByCode(String code) {
    HttpRequest<?> request =
        HttpRequest.GET(String.format("%s/product/%s.json", readApiUrl, code))
            .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_JSON);
    ProductResponse response = httpClient.toBlocking().retrieve(request, ProductResponse.class);
    return response;
  }

}
