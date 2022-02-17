package com.example.muzeumfrontendjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HelloController {
    @FXML
    private TableColumn colFestmenyCim;
    @FXML
    private TableColumn colFestmenyKiallitva;
    @FXML
    private TableColumn colFestmenyEv;
    @FXML
    private TableView szobrokTableView;
    @FXML
    private TableColumn colSzoborMagassag;
    @FXML
    private TableColumn colSzoborSzemely;
    @FXML
    private TableView festmenyekTableView;
    @FXML
    private TableColumn colSzoborAr;

    @FXML
    public void onClickFestmenyModositasButton(ActionEvent actionEvent) {
    }

    @FXML
    public void onClickFestmenyHozzaadasButton(ActionEvent actionEvent) {
    }

    @FXML
    public void onClickFestmenyTorlesButton(ActionEvent actionEvent) {
    }

    @FXML
    public void onClickSzoborModositasButton(ActionEvent actionEvent) {
    }

    @FXML
    public void onClickSzoborTorlesButton(ActionEvent actionEvent) {
    }

    @FXML
    public void onClickSzoborHozzaadasButton(ActionEvent actionEvent) {
    }
}