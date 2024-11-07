package org.openfoodfacts.model.knowledgepanel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class ActionElement {

    @JsonProperty("actions")
    private List<String> actions;

    @JsonProperty("html")
    private String html;
}
