package com.example.erp.Controller;

import javafx.scene.control.TextField;

public class Constraints {

    //Todas as funções são executadas somente quando os valores são alterados

    //Realiza a verificação se o valor inserido é um valor inteiro ou não

    public static void setTextFieldInteger(TextField txt) {
        txt.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && !newValue.matches("\\d*")) {
                txt.setText(oldValue);
            }
        });
    }

    //Realiza a verificação se o valor do novo tamanho é maior que o maximo. Se sim, fica com o tamanho do ultimo valor inserido

    public static void setTextFieldMaxLength(TextField txt, int max) {
        txt.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && newValue.length() > max) {
                txt.setText(oldValue);
            }
        });
    }

    //Realiza a verificação se o valor inserido é um valor double ou não

    public static void setTextFieldDouble(TextField txt) {
        txt.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) {
                txt.setText(oldValue);
            }
        });
    }

}
