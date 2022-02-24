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

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setOn_display(boolean on_display) {
        this.on_display = on_display;
    }
}
