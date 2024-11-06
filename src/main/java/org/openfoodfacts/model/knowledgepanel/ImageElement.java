package org.openfoodfacts.model.knowledgepanel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ImageElement {
    private String url;
    private int width;
    private int height;

    @JsonProperty("alt_text")
    private String altText;
}