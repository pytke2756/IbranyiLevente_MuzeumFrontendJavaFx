package com.example.muzeumfrontendjavafx;

public class Festmeny {
    private int id;
    private String cim;
    private int ev;
    private int kiallitva;

    public Festmeny(int id, String cim, int ev, int kiallitva) {
        this.id = id;
        this.cim = cim;
        this.ev = ev;
        this.kiallitva = kiallitva;
    }

    public int getId() {
        return id;
    }

    public String getCim() {
        return cim;
    }

    public int getEv() {
        return ev;
    }

    public String getKiallitva() {
        if (this.kiallitva == 1){
            return "igen";
        }else{
            return "nem";
        }
    }
}
