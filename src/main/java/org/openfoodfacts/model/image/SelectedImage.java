package org.openfoodfacts.model.image;

import lombok.Data;

@Data
public class SelectedImage {

    private SelectedImageItem display;

    private SelectedImageItem small;

    private SelectedImageItem thumb;
}
