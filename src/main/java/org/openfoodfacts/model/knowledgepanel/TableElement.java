package org.openfoodfacts.model.knowledgepanel;

import lombok.Data;

import java.util.List;

@Data
public class TableElement {
    private String id;
    private String title;
    private String tableType;
    private List<TableColumn> columns;
    private List<TableRow> rows;
}
