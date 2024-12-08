package org.openfoodfacts.model.knowledgepanel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TableElement {
    private String id;
    private String title;

    @JsonProperty("table_type")
    private String tableType;

    private List<TableColumn> columns;
    private List<TableRow> rows;
}
