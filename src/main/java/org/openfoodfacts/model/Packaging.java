package org.openfoodfacts.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Packaging {

    @JsonProperty("number_of_units")
    private Integer numberOfUnits;

    @JsonProperty("shape")
    private String shape;

    @JsonProperty("ecoscore_material_score")
    private String ecoScoreMaterial;

    @JsonProperty("material")
    private String material;

    @JsonProperty("recycling")
    private String recycling;

    @JsonProperty("quantity_per_unit")
    private String quantityPerUnit;

    @JsonProperty("quantity_per_unit_value")
    private Double quantityPerUnitValue;

    @JsonProperty("quantity_per_unit_unit")
    private String quantityPerUnitUnit;

    @JsonProperty("weight_specified")
    private Double weightSpecified;

    @JsonProperty("weight_measured")
    private Double weightMeasured;

    @JsonProperty("weight_estimated")
    private Double weightEstimated;

    @JsonProperty("weight")
    private Double weight;

    @JsonProperty("weight_source_id")
    private String weightSourceId;

    @JsonProperty("packagings_complete")
    private Integer packagingsComplete;
}
