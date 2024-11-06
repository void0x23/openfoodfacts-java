package org.openfoodfacts.model.nutrients;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NutrientLevels {

    private String fat;

    private String salt;

    @JsonProperty("saturated-fat")
    private String saturatedFat;

    private String sugars;
}
