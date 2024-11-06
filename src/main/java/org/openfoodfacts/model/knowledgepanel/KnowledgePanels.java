package org.openfoodfacts.model.knowledgepanel;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class KnowledgePanels {

    private Map<String, Panel> panels = new HashMap<>();

    @JsonAnySetter
    public void addPanel(String key, Panel panel) {
        panels.put(key, panel);
    }

    @JsonAnyGetter
    public Map<String, Panel> getPanels() {
        return panels;
    }
}
