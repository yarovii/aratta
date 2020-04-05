package eu.cz.aratta.repository;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadFromXLSX {
    private Workbook workbook;
    private Sheet sheet;
    private List<Integer> list;
    private Row row;
    private static ReadFromXLSX single_instance = null;

    private ReadFromXLSX() {
        this.list = new ArrayList<>();
    }

    public static ReadFromXLSX getInstance() {
        if (single_instance == null)
            single_instance = new ReadFromXLSX();

        return single_instance;
    }

    private void findSheetIndex(String name){
        for(Sheet sheet: workbook) {
            if(sheet.getSheetName().equals(name)){
                this.sheet = sheet;
                break;
            }
        }
    }

    public List<Integer> getRows(String name) throws IOException {
      workbook = WorkbookFactory.create(new File("db/smooth_round.xlsx"));
      findSheetIndex(name);

      list = new ArrayList<>();
      String s;
      Iterator<Row> rowIt = sheet.iterator();

      while(rowIt.hasNext()) {
          row = rowIt.next();
          s = row.getCell(row.getFirstCellNum()).toString();
          if(s.isEmpty()) break;

          list.add((int)Double.parseDouble(s));
//          System.out.println("row  " + s);
      }
      workbook.close();

      return list;
  }

    public List<Integer> getColumns(String name) throws IOException {
        workbook = WorkbookFactory.create(new File("db/smooth_round.xlsx"));
        findSheetIndex(name);
        list = new ArrayList<>();
        String s;

        row = sheet.getRow(sheet.getFirstRowNum());

        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            s = cell.toString();
            if(s.isEmpty()) break;

            list.add((int)Double.parseDouble(s));
//            System.out.println("col  " + s);
        }

        workbook.close();
        return list;
    }

    public String getAllowance(int r, int c, String s) throws IOException {
        workbook = WorkbookFactory.create(new File("db/smooth_round.xlsx"));
        findSheetIndex(s);

        row = sheet.getRow(r);
        s = row.getCell(c).toString();

        workbook.close();
        return s;
    }
}
