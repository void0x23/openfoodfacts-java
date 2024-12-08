package org.openfoodfacts.model.image;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class SelectedImageItem {

    private String en;

    private String fr;

    private String pl;

    public String getUrl() {
        return ObjectUtils.firstNonNull(en, fr, pl);
    }

    Map<String, Object> other = new LinkedHashMap<>();

    @JsonAnySetter
    void setDetail(String key, Object value) {
        other.put(key, value);
    }
}
