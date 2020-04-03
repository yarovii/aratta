package eu.cz.aratta.model;

import java.util.Map;

public abstract class Detail {
    private Map<Integer, Integer> columns;
    private Map<Integer, Integer> rows;

    public Detail(Map<Integer, Integer> columns, Map<Integer, Integer> rows) {
        this.columns = columns;
        this.rows = rows;
    }

    public Map<Integer, Integer> getColumns() {
        return columns;
    }

    public void setColumns(Map<Integer, Integer> columns) {
        this.columns = columns;
    }

    public Map<Integer, Integer> getRows() {
        return rows;
    }

    public void setRows(Map<Integer, Integer> rows) {
        this.rows = rows;
    }
}
