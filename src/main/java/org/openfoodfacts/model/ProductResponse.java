package org.openfoodfacts.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.openfoodfacts.model.products.Product;

@Data
public class ProductResponse extends AbstractProductResponse<Product> {
}
