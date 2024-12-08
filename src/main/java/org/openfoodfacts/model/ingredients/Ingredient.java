package org.openfoodfacts.model.ingredients;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class Ingredient {

    @JsonProperty("from_palm_oil")
    private String fromPalmOil;

    @JsonProperty("ciqual_proxy_food_code")
    private String ciqualProxyFoodCode;

    private String id;

    private String origin;

    private String percent;

    private int rank;

    private String text;

    private String vegan;

    private String vegetarian;

    Map<String, Object> other = new LinkedHashMap<>();

    @JsonAnySetter
    void setDetail(String key, Object value) {
        other.put(key, value);
    }
}
