package com;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.event.ActionEvent;
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

    @FXML private JFXTextField fxWithError__field1;
    @FXML private JFXTextField fxWithError__field2;
    @FXML private JFXTextField fxWithError__field3;
    @FXML private JFXTextField fxWithError__field4;
    @FXML private JFXTextField fxWithError__field5;
    @FXML private JFXTextField fxWithError__field6;

    @FXML private JFXTextField fxFixed__field1;
    @FXML private JFXTextField fxFixed__field2;
    @FXML private JFXTextField fxFixed__field3;
    @FXML private JFXTextField fxFixed__field4;
    @FXML private JFXTextField fxFixed__field5;
    @FXML private JFXTextField fxFixed__field6;

    @FXML public void fxOnResetAll() { resetAll(); }
    @FXML public void fxOnValidateAll() { validateAll(); }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setValidators();
        initAllValidators();
    }

    private void setValidators() {
        var required = new RequiredFieldValidator("Required field");

        fxNoError__field1.getValidators().add(required);
        fxNoError__field2.getValidators().add(required);
        fxNoError__field3.getValidators().add(required);
        fxNoError__field4.getValidators().add(required);
        fxNoError__field5.getValidators().add(required);
        fxNoError__field6.getValidators().add(required);

        fxWithError__field1.getValidators().add(required);
        fxWithError__field2.getValidators().add(required);
        fxWithError__field3.getValidators().add(required);
        fxWithError__field4.getValidators().add(required);
        fxWithError__field5.getValidators().add(required);
        fxWithError__field6.getValidators().add(required);

        fxFixed__field1.getValidators().add(required);
        fxFixed__field2.getValidators().add(required);
        fxFixed__field3.getValidators().add(required);
        fxFixed__field4.getValidators().add(required);
        fxFixed__field5.getValidators().add(required);
        fxFixed__field6.getValidators().add(required);
    }

    private void initAllValidators() {
        initValidators(fxNoError__field1);
        initValidators(fxNoError__field2);
        initValidators(fxNoError__field3);
        initValidators(fxNoError__field4);
        initValidators(fxNoError__field5);
        initValidators(fxNoError__field6);

        initValidators(fxWithError__field1);
        initValidators(fxWithError__field2);
        initValidators(fxWithError__field3);
        initValidators(fxWithError__field4);
        initValidators(fxWithError__field5);
        initValidators(fxWithError__field6);

        initFixedValidators(fxFixed__field1);
        initFixedValidators(fxFixed__field2);
        initFixedValidators(fxFixed__field3);
        initFixedValidators(fxFixed__field4);
        initFixedValidators(fxFixed__field5);
        initFixedValidators(fxFixed__field6);
    }

    private void resetAll() {

    }

    private void validateAll() {

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
