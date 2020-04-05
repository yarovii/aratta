package eu.cz.aratta.logic;

import eu.cz.aratta.model.Detail;
import eu.cz.aratta.repository.ReadFromXLSX;

import java.io.IOException;

public class FillDetail {

    public static void fillAllData(Detail d, int row, int column) throws IOException {
        ReadFromXLSX rfxlsx = ReadFromXLSX.getInstance();

        d.setColumnAndRow(column, row);
        Location.allowanceLocation(d);
        d.setAllowance(rfxlsx.getAllowance(d.getNewRowLocation(), d.getNewColumnLocation(), d.getSheetName()));
    }
}
