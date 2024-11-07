package org.openfoodfacts.model.knowledgepanel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class Element {

    @JsonProperty("element_type")
    private String elementType;

    @JsonProperty("text_element")
    private TextElement textElement;

    @JsonProperty("image_element")
    private ImageElement imageElement;

    @JsonProperty("table_element")
    private TableElement tableElement;

    @JsonProperty("panel_element")
    private PanelElement panelElement;

    @JsonProperty("panel_group_element")
    private PanelGroupElement panelGroupElement;

    @JsonProperty("action_element")
    private ActionElement actionElement;

    @JsonProperty("evaluation")
    private String evaluation;

    @JsonProperty("expand_for")
    private String expandFor;

    @JsonProperty("level")
    private String level;

    @JsonProperty("title_element")
    private TitleElement titleElement;

    @JsonProperty("topics")
    private List<String> topics;
}
