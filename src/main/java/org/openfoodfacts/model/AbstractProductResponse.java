package org.openfoodfacts.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AbstractProductResponse<T> {

    protected String code;

    protected int status;

    @JsonProperty("status_verbose")
    protected String statusVerbose;

    protected T product;

}
