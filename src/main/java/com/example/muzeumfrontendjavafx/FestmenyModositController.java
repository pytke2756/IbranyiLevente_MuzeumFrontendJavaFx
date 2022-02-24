package com.example.muzeumfrontendjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

import java.io.IOException;

public class FestmenyModositController extends Controller{
    private Festmeny modositando;
    @FXML
    private TextField festmenyCim;
    @FXML
    private Spinner<Integer> festmenyEv;
    @FXML
    private CheckBox festmenyKiallitva;

    public void setModositando(Festmeny modositando) {
        this.modositando = modositando;
        ertekekBeallitasa();
    }

    private void ertekekBeallitasa() {
        festmenyCim.setText(modositando.getTitle());
        festmenyEv.getValueFactory().setValue(modositando.getYear());
        if (modositando.getOn_display().equals("igen")){
            festmenyKiallitva.setSelected(true);
        }else {
            festmenyKiallitva.setSelected(false);
        }
    }

    @FXML
    public void festmenyModositButtonClick(ActionEvent actionEvent) {
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

        this.modositando.setTitle(cim);
        this.modositando.setYear(ev);
        this.modositando.setOn_display(kiallitva);

        try {
            Festmeny modositottFestmeny = MuzeumApi.festmenyModositas(modositando);
            if (modositottFestmeny != null){
                alert("Festmény módosítása sikeres");
            }else{
                alert("Festmény módosítása sikeretelen");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
