package eu.cz.aratta.controller;

import eu.cz.aratta.logic.FillDetail;
import eu.cz.aratta.model.SmoothRound;
import eu.cz.aratta.repository.ReadFromXLSX;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SmoothRoundController implements Initializable {

    @FXML
    private TextField getL;

    @FXML
    private TextField getD;

    @FXML
    private Label setL;

    @FXML
    private Label setD;

    private SmoothRound smoothRound;
    private ReadFromXLSX readFromXLSX;

    @FXML
    private void onCalculate() throws IOException {
        if(smoothRound.validation(Double.parseDouble(getL.getText()), Double.parseDouble(getD.getText())))
            setL.setText("Not valid D or L");
        else {
            FillDetail.fillAllData(smoothRound, Integer.parseInt(getL.getText()), Integer.parseInt(getD.getText()));
            smoothRound.calculateNewValues();
            setL.setText(smoothRound.getAllowanceRow());
            setD.setText(smoothRound.getAllowanceColumn());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        readFromXLSX = ReadFromXLSX.getInstance();
        try {
            smoothRound = new SmoothRound(readFromXLSX.getColumns("smooth_round"), readFromXLSX.getRows("smooth_round"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
