package org.example;

import java.util.Objects;

public class Produs {
    private String nume;
    private double pret;
    private int discount;
    private int cantitate;

    public Produs(String nume, double pret, int discount,int cantitate){
        this.nume=nume;
        this.pret=pret;
//        this.discount=discount;
        this.cantitate=cantitate;
    }

    public Produs(String nume, double pret, int cantitate) {
    }

    public void afiseazaDateProdus(){
        System.out.println("Produsul ales este: " + this.nume +
                "\n Avand pretul de: " + this.pret + " Lei" +
                "\n Si o cantitate de: " + this.cantitate );
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        //this.discount = discount;
        if (discount > 0 && discount < 100){
            this.discount = discount;
        } else {
            System.out.println("Acest discount nu este valid");
        }
    }

    public void produs() { //ca sa functiuneze cu return pretFinal trebuie declarat public double
        double pretFinal = (pret - pret * discount / 100) * cantitate;
        System.out.println("Pretul final este: " + pretFinal);
        //return pretFinal;
    }

    @Override
    public String toString() {
        return nume + "," + pret + "," + discount + "," + cantitate;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produs)) return false;
        Produs produs = (Produs) o;
        return Double.compare(produs.getPret(), getPret()) == 0 && getDiscount() == produs.getDiscount() && getCantitate() == produs.getCantitate() && Objects.equals(getNume(), produs.getNume());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNume(), getPret(), getDiscount(), cantitate);
    }


}
