package org.openfoodfacts.model.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.openfoodfacts.model.knowledgepanel.KnowledgePanels;

public class KnowledgePanelProduct {

    @JsonProperty("knowledge_panels")
    private KnowledgePanels knowledgePanels;

}
