package org.openfoodfacts.model.knowledgepanel;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class TableValue {

    private String evaluation;
    private String text;
    private String percent;

    @JsonProperty("icon_url")
    private String iconUrl;

    Map<String, Object> other = new LinkedHashMap<>();

    @JsonAnySetter
    void setDetail(String key, Object value) {
        other.put(key, value);
    }
}
