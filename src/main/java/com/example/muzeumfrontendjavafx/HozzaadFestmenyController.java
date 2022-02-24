package com.example.muzeumfrontendjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HozzaadFestmenyController extends Controller{
    @FXML
    private TextField festmenyCim;
    @FXML
    private Spinner<Integer> festmenyEv;
    @FXML
    private CheckBox festmenyKiallitva;

    @FXML
    public void festmenyHozzadButtonClick(ActionEvent actionEvent) {
        String cim = festmenyCim.getText().trim();
        int ev = 0;
        boolean kiallitva = festmenyKiallitva.isSelected();

        if (cim.isEmpty()){
            alert("Cím megadása kötelező!");
            return;
        }
        try {
            ev = festmenyEv.getValue();
        } catch (NullPointerException ex){
            alert("Az év megadása kötelező");
            return;
        } catch (Exception ex){
            alert("Az év csak 1 és 2022 közötti szám lehet");
            return;
        }

        try {
            Festmeny ujFestmeny = new Festmeny(0, cim, ev, kiallitva);
            Festmeny letrehozott = MuzeumApi.festmenyHozzaadasa(ujFestmeny);
            if (letrehozott != null){
                alert("Festmény hozzáadása sikeres");
            }else{
                alert("Festmény hozzáadása sikeretelen");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
