package com;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;

import java.net.URL;
import java.util.ResourceBundle;

public class Index implements Initializable {
    @FXML private JFXTextField fxNoError__field1;
    @FXML private JFXTextField fxNoError__field2;
    @FXML private JFXTextField fxNoError__field3;
    @FXML private JFXTextField fxNoError__field4;
    @FXML private JFXTextField fxNoError__field5;
    @FXML private JFXTextField fxNoError__field6;

    @FXML private JFXTextField fxError__field1;
    @FXML private JFXTextField fxError__field2;
    @FXML private JFXTextField fxError__field3;
    @FXML private JFXTextField fxError__field4;
    @FXML private JFXTextField fxError__field5;
    @FXML private JFXTextField fxError__field6;

    @FXML private JFXTextField fxFixed__field1;
    @FXML private JFXTextField fxFixed__field2;
    @FXML private JFXTextField fxFixed__field3;
    @FXML private JFXTextField fxFixed__field4;
    @FXML private JFXTextField fxFixed__field5;
    @FXML private JFXTextField fxFixed__field6;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //initValidators();
    }

    private void initValidators(JFXTextField node) {
        node.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) node.validate();
        });

        node.textProperty().addListener((o, oldVal, newVal) -> {
            node.validate();
        });
    }

    private void initFixedValidators(JFXTextField node) {
        node.focusedProperty().addListener((o, oldVal, newVal) -> {
            node.setAlignment(Pos.TOP_LEFT);
            if (!newVal) node.validate();
            node.setAlignment(Pos.CENTER);
        });

        node.textProperty().addListener((o, oldVal, newVal) -> {
            node.setAlignment(Pos.TOP_LEFT);
            node.validate();
            node.setAlignment(Pos.CENTER);
        });
    }

}
