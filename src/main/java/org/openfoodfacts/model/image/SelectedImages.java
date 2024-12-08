package org.openfoodfacts.model.image;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class SelectedImages {

    private SelectedImage front;

    private SelectedImage ingredients;

    private SelectedImage nutrition;

    Map<String, Object> other = new LinkedHashMap<>();

    @JsonAnySetter
    void setDetail(String key, Object value) {
        other.put(key, value);
    }
}
