package eu.cz.aratta.model;

import java.util.List;

public abstract class Detail {
    private final String sheetName;
    private final List<Integer> allColumns;
    private final List<Integer> allRows;
    private String[] allowance;
    private int newRowLocation;
    private int newColumnLocation;
    private String allowanceRow;
    private String allowanceColumn;
    private int row;
    private int column;

    public List<Integer> getAllColumns() {
        return allColumns;
    }

    public List<Integer> getAllRows() {
        return allRows;
    }

    public Detail(String sheetName, List<Integer> allColumns, List<Integer> allRows) {
        this.sheetName = sheetName;
        this.allColumns = allColumns;
        this.allRows = allRows;
    }

    public boolean basicValidation(double row, double column){
        return allRows.get(allRows.size()-1) < row || allColumns.get(allColumns.size()-1) < column
                || row <=0 || column <=0;
    }

    public String[] getAllowance() {
        return allowance;
    }

    public void setAllowance(String allowance) {
        this.allowance = allowance.split("±");
    }

    public String getAllowanceRow() {
        return allowanceRow;
    }

    public void setAllowanceRow(String allowanceRow) {
        this.allowanceRow = allowanceRow;
    }

    public String getAllowanceColumn() {
        return allowanceColumn;
    }

    public void setAllowanceColumn(String allowanceColumn) {
        this.allowanceColumn = allowanceColumn;
    }

    public void setColumnAndRow(int c, int r){
        this.row = r;
        this.column = c;
    }

    public String getSheetName() {
        return sheetName;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getNewRowLocation() {
        return newRowLocation;
    }

    public void setNewRowLocation(int newRowLocation) {
        this.newRowLocation = newRowLocation;
    }

    public int getNewColumnLocation() {
        return newColumnLocation;
    }

    public void setNewColumnLocation(int newColumnLocation) {
        this.newColumnLocation = newColumnLocation;
    }
}
