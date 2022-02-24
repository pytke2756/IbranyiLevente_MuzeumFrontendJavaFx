package com.example.muzeumfrontendjavafx;

public class Szobor {
    private int id;
    private String person;
    private int height;
    private int price;

    public Szobor(int id, String szemely, int magassag, int ar) {
        this.id = id;
        this.person = szemely;
        this.height = magassag;
        this.price = ar;
    }

    public int getId() {
        return id;
    }

    public String getPerson() {
        return person;
    }

    public int getHeight() {
        return height;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
