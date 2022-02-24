package com.example.muzeumfrontendjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HozzaadSzoborController extends Controller{
    @FXML
    private TextField szoborSzemely;
    @FXML
    private Spinner<Integer> szoborAr;
    @FXML
    private Spinner<Integer> szoborMagassag;

    @FXML
    public void szoborHozzaadButtonClick(ActionEvent actionEvent) {
        String szemely = szoborSzemely.getText().trim();
        int ar = 0;
        int magassag = 0;

        if (szemely.isEmpty()){
            alert("Személy megadása kötelező!");
            return;
        }

        try {
            ar = szoborAr.getValue();
        } catch (NullPointerException ex){
            alert("Az ár megadása kötelező");
            return;
        } catch (Exception ex){
            alert("Az ár csak 1 és 50000000 közötti szám lehet");
            return;
        }

        try {
            magassag = szoborMagassag.getValue();
        } catch (NullPointerException ex){
            alert("A magasság megadása kötelező");
            return;
        } catch (Exception ex){
            alert("A magasság csak 1 és 300 közötti szám lehet");
            return;
        }

        try {
            Szobor ujSzobor = new Szobor(0, szemely, magassag, ar);
            Szobor letrehozott = MuzeumApi.szoborHozzaadasa(ujSzobor);
            if (letrehozott != null){
                alert("Szobor hozzáadása sikeres");
            }else{
                alert("Szobor hozzáadása sikeretelen");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
