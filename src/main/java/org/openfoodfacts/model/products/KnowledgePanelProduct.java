package org.openfoodfacts.model.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.openfoodfacts.model.knowledgepanel.KnowledgePanels;

@Data
public class KnowledgePanelProduct {

    @JsonProperty("knowledge_panels")
    private KnowledgePanels knowledgePanels;

}
