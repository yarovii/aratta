package eu.cz.aratta;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ReadXLSX {
    public void Start() throws IOException {
        Workbook workbook = WorkbookFactory.create(new File("db/smooth_round.xlsx"));
//        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
        System.out.println("Retrieving Sheets using for-each loop");
        for(Sheet sheet: workbook) {
            System.out.println("=> " + sheet.getSheetName());
        }
        System.out.println("Retrieving Sheets using Java 8 forEach with lambda");
        workbook.forEach(sheet -> {
            System.out.println("=> " + sheet.getSheetName());
        });
        Sheet sheet = workbook.getSheetAt(0);
        Row row;
        for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            row = sheet.getRow(rowIndex);
            if (row != null) {
                Cell cell = row.getCell(row.getFirstCellNum());
                if (cell != null) {
                    System.out.println(cell.toString());
                    // Found column and there is value in the cell.
//                    cellValueMaybeNull = cell.getStringCellValue();
                    // Do something with the cellValueMaybeNull here ...
                }
            }
        }

//        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIt = sheet.iterator();
        System.out.println("\n");
        while(rowIt.hasNext()) {
//        while(rowIt.hasNext()) {
            row = rowIt.next();

            // iterate on cells for the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                System.out.print(cell.toString() +  "\t");
            }

            System.out.println();
        }

        workbook.close();
    }
}
