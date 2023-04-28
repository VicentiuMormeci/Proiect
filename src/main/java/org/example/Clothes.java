package org.example;

public class Clothes extends Produs{
    private String tip;

    public Clothes(String nume, double pret, String tip, int cantitate) {
        super(nume, pret, cantitate);
        this.tip = tip;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
