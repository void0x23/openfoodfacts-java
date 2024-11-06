package org.openfoodfacts.model.knowledgepanel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

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
}