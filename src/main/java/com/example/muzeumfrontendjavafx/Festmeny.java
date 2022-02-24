package com.example.muzeumfrontendjavafx;

public class Festmeny {
    private int id;
    private String title;
    private int year;
    private boolean on_display;

    public Festmeny(int id, String cim, int ev, boolean kiallitva) {
        this.id = id;
        this.title = cim;
        this.year = ev;
        this.on_display = kiallitva;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getOn_display() {
        if (this.on_display){
            return "igen";
        }else{
            return "nem";
        }
    }

    public boolean is() {
        return on_display;
    }
}
