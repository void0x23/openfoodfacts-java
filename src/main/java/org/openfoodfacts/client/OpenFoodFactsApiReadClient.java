package org.openfoodfacts.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.openfoodfacts.exception.OpenFoodsFactsException;
import org.openfoodfacts.model.Product;
import org.openfoodfacts.model.ProductResponse;

import java.util.Arrays;


@Slf4j
@Singleton
public class OpenFoodFactsApiReadClient {

  @Value("${openfoodfacts.api.url.read}")
  protected String readApiUrl;

  private final HttpClient httpClient;

  private static final String URL = "https://world.openfoodfacts.org/api/v2";
  private static final String PRODUCT = "product";

  public OpenFoodFactsApiReadClient(@Client HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  public Product fetchProductByCode(String code) throws JsonProcessingException {

    if (code == null) {
      throw new OpenFoodsFactsException("Barcode cannot be null");
    }

    log.info("Request url {}", String.format("%s/%s/%s", URL, PRODUCT, code));

    HttpRequest<?> request =
        HttpRequest.GET(String.format("%s/%s/%s.json", URL, PRODUCT, code))
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);

    ProductResponse response = httpClient.toBlocking().retrieve(request, ProductResponse.class);

    Arrays.stream(response.getProduct().getPackagings()).forEach(x -> log.info("package {}", x));
    log.info("packaging {}", response.getProduct().getPackagings().length);

    return null;
  }

}
