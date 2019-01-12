package com;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class Index implements Initializable {
    @FXML private JFXTextField fxNoError__field1, fxNoError__field2, fxNoError__field3;
    @FXML private JFXTextField fxNoError__field4, fxNoError__field5, fxNoError__field6;

    @FXML private JFXTextField fxWithError__field1, fxWithError__field2, fxWithError__field3;
    @FXML private JFXTextField fxWithError__field4, fxWithError__field5, fxWithError__field6;

    @FXML private JFXTextField fxFixed__field1, fxFixed__field2, fxFixed__field3;
    @FXML private JFXTextField fxFixed__field4, fxFixed__field5, fxFixed__field6;

    @FXML public void fxOnResetAll() { resetAll(); }
    @FXML public void fxOnValidateAll() { validateAll(); }

    private JFXTextField[] noErrorFields = {
            fxNoError__field1, fxNoError__field2, fxNoError__field3,
            fxNoError__field4, fxNoError__field5, fxNoError__field6
    };

    private JFXTextField[] withErrorFields = {
            fxWithError__field1, fxWithError__field2, fxWithError__field3,
            fxWithError__field4, fxWithError__field5, fxWithError__field6
    };

    private JFXTextField[] fixedField = {
            fxFixed__field1, fxFixed__field2, fxFixed__field3,
            fxFixed__field4, fxFixed__field5, fxFixed__field6
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setValidators();
        initAllValidators();
    }

    private void setValidators() {
        var required = new RequiredFieldValidator("Required field");

        for (var field : noErrorFields) {
            field.getValidators().add(required);
        }

        for (var field : withErrorFields) {
            field.getValidators().add(required);
        }

        for (var field : fixedField) {
            field.getValidators().add(required);
        }
    }

    private void initAllValidators() {
        for (var field : noErrorFields) {
            initValidators(field);
        }

        for (var field : withErrorFields) {
            initValidators(field);
        }

        for (var field : fixedField) {
            initFixedValidators(field);
        }
    }

    private void resetAll() {
        for (var field : noErrorFields) {
            resetField(field);
        }

        for (var field : withErrorFields) {
            resetField(field);
        }

        for (var field : fixedField) {
            resetField(field);
        }
    }

    private void resetField(JFXTextField node) {
        node.clear();
        node.resetValidation();
    }

    private void validateAll() {
        for (var field : noErrorFields) {
            field.validate();
        }

        for (var field : withErrorFields) {
            field.validate();
        }

        for (var field : fixedField) {
            field.validate();
        }
    }

    private void initValidators(JFXTextField node) {
        node.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) node.validate();
        });

        node.textProperty().addListener((o, oldVal, newVal) -> node.validate());
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
