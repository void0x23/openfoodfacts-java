package org.openfoodfacts.model.knowledgepanel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PanelGroupElement {

    private String title;

    @JsonProperty("panel_ids")
    private List<String> panelIds;
}
