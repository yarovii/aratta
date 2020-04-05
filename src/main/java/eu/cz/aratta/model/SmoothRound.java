package eu.cz.aratta.model;

import java.util.List;

public class SmoothRound extends Detail {
    public SmoothRound(List<Integer> allColumns, List<Integer> allRows) {
        super("smooth_round", allColumns, allRows);
    }

    public boolean validation(double r, double c){
        return basicValidation(r, c) || (r <= (1.2 * c) || r >= (30*c));
    }

    public void calculateNewValues(){
        int num = getRow()+Integer.parseInt(getAllowance()[0]);
        setAllowanceRow(num+"±"+getAllowance()[1]);

        num = getColumn()+Integer.parseInt(getAllowance()[0]);
        setAllowanceColumn(num+"±"+getAllowance()[1]);
    }
}
