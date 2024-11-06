package org.openfoodfacts.model.knowledgepanel;

import lombok.Data;

import java.util.List;

@Data
public class TableRow {
    private String id;
    private List<TableValue> values;
}