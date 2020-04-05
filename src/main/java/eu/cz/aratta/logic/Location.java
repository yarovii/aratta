package eu.cz.aratta.logic;

import eu.cz.aratta.model.Detail;

public class Location {

    public static void allowanceLocation(Detail detail) {

        for(int i = 0; i < detail.getAllColumns().size(); i++){
            if(detail.getColumn() <= detail.getAllColumns().get(i)) {
                detail.setNewColumnLocation(i);
//                System.out.println(detail.getColumn() + "CCCC===" + detail.getAllColumns().get(i) + "   " + i);
                break;
            }
        }
        for(int i = 0; i < detail.getAllRows().size(); i++){
            if(detail.getRow() <= detail.getAllRows().get(i)) {
//                System.out.println(detail.getRow() + "RRRR===" + detail.getAllRows().get(i) + "   " + i);
                detail.setNewRowLocation(i);
                break;
            }
        }
    }

}
