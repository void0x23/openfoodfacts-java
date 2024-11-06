package org.openfoodfacts.model.knowledgepanel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TableValue {
    private String text;
    private String percent;

    @JsonProperty("icon_url")
    private String iconUrl;
}
