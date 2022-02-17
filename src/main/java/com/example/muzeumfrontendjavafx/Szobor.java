package com.example.muzeumfrontendjavafx;

public class Szobor {
    private int id;
    private String szemely;
    private int magassag;
    private int ar;

    public Szobor(int id, String szemely, int magassag, int ar) {
        this.id = id;
        this.szemely = szemely;
        this.magassag = magassag;
        this.ar = ar;
    }

    public int getId() {
        return id;
    }

    public String getSzemely() {
        return szemely;
    }

    public int getMagassag() {
        return magassag;
    }

    public int getAr() {
        return ar;
    }
}
