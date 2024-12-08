package org.openfoodfacts.model.packaging;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class Source {

    private String[] fields;

    private String id;

    private String[] images;

    @JsonProperty("import_t")
    private long importT;

    private String manufacturer;

    private String name;

    private String url;

    Map<String, Object> other = new LinkedHashMap<>();

    @JsonAnySetter
    void setDetail(String key, Object value) {
        other.put(key, value);
    }
}
