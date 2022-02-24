package com.example.muzeumfrontendjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

public class MainController {
    @FXML
    private TableColumn<Festmeny, String> colFestmenyCim;
    @FXML
    private TableColumn<Festmeny, String> colFestmenyKiallitva;
    @FXML
    private TableColumn<Festmeny, Integer> colFestmenyEv;
    @FXML
    private TableView<Szobor> szobrokTableView;
    @FXML
    private TableColumn<Szobor, Integer> colSzoborMagassag;
    @FXML
    private TableColumn<Szobor, String> colSzoborSzemely;
    @FXML
    private TableView<Festmeny> festmenyekTableView;
    @FXML
    private TableColumn<Szobor, Integer> colSzoborAr;

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

    public void initialize(){
        colFestmenyCim.setCellValueFactory(new PropertyValueFactory<>("title"));
        colFestmenyEv.setCellValueFactory(new PropertyValueFactory<>("year"));
        colFestmenyKiallitva.setCellValueFactory(new PropertyValueFactory<>("on_display"));

        colSzoborSzemely.setCellValueFactory(new PropertyValueFactory<>("person"));
        colSzoborMagassag.setCellValueFactory(new PropertyValueFactory<>("height"));
        colSzoborAr.setCellValueFactory(new PropertyValueFactory<>("price"));

        szoborFeltolt();
        festmenyFeltolt();
    }

    private void festmenyFeltolt() {
        try {
            List<Festmeny> festmenyek = MuzeumApi.getFestmenyek();
            festmenyekTableView.getItems().clear();
            for (Festmeny item : festmenyek){
                festmenyekTableView.getItems().add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void szoborFeltolt() {
        try {
            List<Szobor> szobrok = MuzeumApi.getSzobrok();
            szobrokTableView.getItems().clear();
            for (Szobor item : szobrok){
                szobrokTableView.getItems().add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}