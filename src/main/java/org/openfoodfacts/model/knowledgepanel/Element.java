package org.openfoodfacts.model.knowledgepanel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

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
    private String actionElement;
}
