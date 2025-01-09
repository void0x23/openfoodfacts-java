package org.openfoodfacts.model.knowledgepanel;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class Panel {

    private String level;

    private String size;

    private String type;

    private String evaluation;

    private boolean expanded;

    @JsonProperty("title_element")
    private TitleElement titleElement;

    private List<Element> elements;

    private List<String> topics;

    Map<String, Object> other = new LinkedHashMap<>();

    @JsonAnySetter
    void setDetail(String key, Object value) {
        other.put(key, value);
    }
}