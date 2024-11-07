package org.openfoodfacts.client;

import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.openfoodfacts.exception.OpenFoodsFactsException;
import org.openfoodfacts.model.AbstractProductResponse;
import org.openfoodfacts.model.KnowledgePanelsResponse;
import org.openfoodfacts.model.ProductResponse;

import java.util.Optional;

import static org.openfoodfacts.constant.Constants.*;


@Slf4j
@Singleton
public class OpenFoodFactsApiReadClient {

/*  @Value("${openfoodfacts.url.api}")
  private String apiReadUrl;*/

  private final HttpClient httpClient;

  public OpenFoodFactsApiReadClient(@Client HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  public ProductResponse fetchProductByBarcode(String code) {

    String barcode = checkBarcode(code);

    String url = String.format("%s/%s/%s.json", BASE_SEARCH_URL, PRODUCT, barcode);
/*
    String url = String.format("%s/%s/%s.json", apiReadUrl, PRODUCT, barcode);
*/

    HttpRequest<?> request =
        HttpRequest.GET(url)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);

    ProductResponse response = httpClient.toBlocking().retrieve(request, ProductResponse.class);

    checkResponseStatus(response);

    return response;
  }

  public KnowledgePanelsResponse getProductKnowledgePanelsByBarcode(String code) {

    String barcode = checkBarcode(code);

    String url = String.format("%s/%s/%s.json?fields=%s", BASE_SEARCH_URL, PRODUCT, barcode, KNOWLEDGE_PANELS);

    HttpRequest<?> request =
            HttpRequest.GET(url)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);

    KnowledgePanelsResponse response = httpClient.toBlocking().retrieve(request, KnowledgePanelsResponse.class);

    checkResponseStatus(response);

    return response;
  }


  private <T extends AbstractProductResponse> void checkResponseStatus(T response) {
    if (response.getStatus() == 0) {
      throw new OpenFoodsFactsException(response.getStatusVerbose());
    }
  }


  private String checkBarcode(String code) {
    return Optional.ofNullable(code)
            .orElseThrow(() -> new OpenFoodsFactsException("Barcode cannot be null"));
  }
}
