package org.openfoodfacts.model.knowledgepanel;

import lombok.Data;

@Data
public class TextElement {
    private String html;
    private String type;
    private String language;
    private String lc;
    private String editFieldId;
    private String editFieldType;
    private String editFieldValue;
    private String sourceUrl;
    private String sourceText;
    private String sourceLc;
    private String sourceLanguage;
}
