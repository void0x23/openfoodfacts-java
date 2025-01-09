package org.openfoodfacts.model.knowledgepanel;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

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

    Map<String, Object> other = new LinkedHashMap<>();

    @JsonAnySetter
    void setDetail(String key, Object value) {
        other.put(key, value);
    }
}
