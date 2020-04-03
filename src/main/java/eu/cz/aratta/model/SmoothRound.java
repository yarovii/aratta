package eu.cz.aratta.model;

import java.util.Map;

public class SmoothRound extends Detail {
    private int length;
    private int diameter;

    public SmoothRound(Map<Integer, Integer> columns, Map<Integer, Integer> rows, int length, int diameter) {
        super(columns, rows);
        this.length = length;
        this.diameter = diameter;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
}
