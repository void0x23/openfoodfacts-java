package org.openfoodfacts.model.knowledgepanel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PanelElement {
    @JsonProperty("panel_id")
    private String panelId;
}
