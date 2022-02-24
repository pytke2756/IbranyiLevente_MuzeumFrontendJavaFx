package com.example.muzeumfrontendjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

public class MainController extends Controller{
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
        try {
            Controller hozzadas = ujAblak("hozzaad-festmeny-view.fxml", "Festmény hozzáadása",
                    300, 230);
            hozzadas.getStage().setOnCloseRequest(event -> festmenyFeltolt());
            hozzadas.getStage().show();
        } catch (Exception e) {
            hibaKiir(e);
        }
    }

    @FXML
    public void onClickFestmenyTorlesButton(ActionEvent actionEvent) {
        int selectedIndex = festmenyekTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex == -1){
            alert("A törléshez előbb válasszon ki egy elemet a festmények táblázatból");
            return;
        }
        Festmeny torlendoFestmeny = festmenyekTableView.getSelectionModel().getSelectedItem();
        if (!confirm("Biztos hogy törölni szeretné az alábbi festményt: "+torlendoFestmeny.getTitle())){
            return;
        }
        try {
            boolean sikeres = MuzeumApi.festmenyTorlese(torlendoFestmeny.getId());
            alert(sikeres?"Sikeres törlés": "Sikertelen törlés");
            festmenyFeltolt();
        } catch (IOException e) {
            hibaKiir(e);
        }
    }

    @FXML
    public void onClickSzoborModositasButton(ActionEvent actionEvent) {
    }

    @FXML
    public void onClickSzoborTorlesButton(ActionEvent actionEvent) {
        int selectedIndex = szobrokTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex == -1){
            alert("A törléshez előbb válasszon ki egy elemet a szobrot táblázatból");
            return;
        }
        Szobor torlendoSzobor = szobrokTableView.getSelectionModel().getSelectedItem();
        if (!confirm("Biztos hogy törölni szeretné az alábbi szobrot: "+torlendoSzobor.getPerson())){
            return;
        }
        try {
            boolean sikeres = MuzeumApi.szoborTorlese(torlendoSzobor.getId());
            alert(sikeres?"Sikeres törlés": "Sikertelen törlés");
            szoborFeltolt();
        } catch (IOException e) {
            hibaKiir(e);
        }
    }

    @FXML
    public void onClickSzoborHozzaadasButton(ActionEvent actionEvent) {
        try {
            Controller hozzadas = ujAblak("hozzaad-szobor-view.fxml", "Szobor hozzáadása",
                    300, 230);
            hozzadas.getStage().setOnCloseRequest(event -> szoborFeltolt());
            hozzadas.getStage().show();
        } catch (Exception e) {
            hibaKiir(e);
        }
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
            hibaKiir(e);
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
            hibaKiir(e);
        }
    }
}