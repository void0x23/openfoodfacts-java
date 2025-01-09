package org.openfoodfacts.model.knowledgepanel;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class TitleElement {

    private String name;
    private String title;
    private String subtitle;
    private String grade;
    private String type;

    @JsonProperty("icon_url")
    private String iconUrl;

    @JsonProperty("icon_color_from_evaluation")
    private boolean iconColorFromEvaluation;

    @JsonProperty("icon_size")
    private String iconSize;

    private double value;

    Map<String, Object> other = new LinkedHashMap<>();

    @JsonAnySetter
    void setDetail(String key, Object value) {
        other.put(key, value);
    }
}
