package eu.cz.aratta.model;

import java.util.List;

public class SmoothRound extends Detail {
    public SmoothRound(List<Integer> allColumns, List<Integer> allRows) {
        super("7062-90", allColumns, allRows);
    }

    public boolean validation(double r, double c){
        return basicValidation(r, c) || (r < (1.2 * c) || r > (30*c));
    }

    public void calculateNewValues(){
        ////new Len
        int num = getRow()+(3* Integer.parseInt(getAllowance()[0]));
        setAllowanceRow(num+"±"+(3*Integer.parseInt(getAllowance()[1])));

        ///new Diameter
        num = getColumn()+Integer.parseInt(getAllowance()[0]);
        setAllowanceColumn(num+"±"+getAllowance()[1]);
    }
}
