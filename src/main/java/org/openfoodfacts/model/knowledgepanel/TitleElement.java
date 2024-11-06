package org.openfoodfacts.model.knowledgepanel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TitleElement {
    private String title;
    private String subtitle;
    private String grade;
    private String type;

    @JsonProperty("icon_url")
    private String iconUrl;

    @JsonProperty("icon_color_from_evaluation")
    private boolean iconColorFromEvaluation;

    @JsonProperty("icon_size")
    private String iconSize;

    private double value;
}
