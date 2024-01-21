package com.example.it.geometrycalculator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    ObservableList<String> unitsArrayList = FXCollections.observableArrayList("mm", "cm", "dm", "m");
    protected String rad;
    protected String height;
    protected String length;
    protected String width;
    protected double result;

    @FXML
    private Text blockRes;

    @FXML
    private TextField blockHeight;

    @FXML
    private TextField blockLen;

    @FXML
    private TextField blockWidth;

    @FXML
    private TextField cylHeight;

    @FXML
    private TextField cylRad;

    @FXML
    private Text cylRes;

    @FXML
    private TextField sphereRad;

    @FXML
    private Text sphereRes;

    @FXML
    private ComboBox<String> unitsBlock;

    @FXML
    private ComboBox<String> unitsCyl;

    @FXML
    private ComboBox<String> unitsSph;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        unitsCyl.setItems(unitsArrayList);
        unitsSph.setItems(unitsArrayList);
        unitsBlock.setItems(unitsArrayList);
        unitsCyl.setValue("cm");
        unitsSph.setValue("cm");
        unitsBlock.setValue("cm");
    }

    public String getUnits(String result, String anotherValue, String unitValue){
        switch(unitValue){
            case "mm":
                result += " mm" + anotherValue;
                break;
            case "cm":
                result += " cm" + anotherValue;
                break;
            case "dm":
                result += " dm" + anotherValue;
                break;
            case "m":
                result += " m" + anotherValue;
                break;
        }

        return result;
    }

    public void setVarToZero(){
        rad = "0";
        height = "0";
        result = 0.0;
        length = "0";
        width = "0";
    }

    @FXML
    void blockSur(ActionEvent event) {
        length = blockLen.getText();
        height = blockHeight.getText();
        width = blockWidth.getText();
        result = (2.0 * Double.parseDouble(length) * Double.parseDouble(height)) + (2.0 * Double.parseDouble(length) * Double.parseDouble(width)) + (2 * Double.parseDouble(width) * Double.parseDouble(height));
        blockRes.setText(getUnits(Double.toString(result), "2", unitsBlock.getValue()));
        setVarToZero();
    }

    @FXML
    void blockVol(ActionEvent event) {
        length = blockLen.getText();
        height = blockHeight.getText();
        width = blockWidth.getText();
        result = Double.parseDouble(length) * Double.parseDouble(height) * Double.parseDouble(width);
        blockRes.setText(getUnits(Double.toString(result), "3", unitsBlock.getValue()));
        setVarToZero();
    }

    @FXML
    void cylSur(ActionEvent event) {
        rad = cylRad.getText();
        height = cylHeight.getText();
        result = Math.round((2.0 * Math.PI * Math.pow(Double.parseDouble(rad), 2.0)) + (2.0 * Math.PI * Double.parseDouble(rad) * Double.parseDouble(height)));
        cylRes.setText(getUnits(Double.toString(result),"2", unitsCyl.getValue()));
        setVarToZero();
    }

    @FXML
    void cylVol(ActionEvent event) {
        rad = cylRad.getText();
        height = cylHeight.getText();
        result = Math.round(Math.PI * Math.pow(Double.parseDouble(rad), 2.0) * Double.parseDouble(height));
        cylRes.setText(getUnits(Double.toString(result), "3", unitsCyl.getValue()));
        setVarToZero();
    }

    @FXML
    void sphereSur(ActionEvent event) {
        rad = sphereRad.getText();
        result = Math.round((4.0/3.0) * Math.PI * Math.pow(Double.parseDouble(rad), 3.0));
        sphereRes.setText(getUnits(Double.toString(result), "2", unitsSph.getValue()));
        setVarToZero();
    }

    @FXML
    void sphereVol(ActionEvent event) {
        rad = sphereRad.getText();
        result = Math.round(4.0 * Math.PI * Math.pow(Double.parseDouble(rad), 2));
        sphereRes.setText(getUnits(Double.toString(result), "3", unitsSph.getValue()));
        setVarToZero();
    }
}