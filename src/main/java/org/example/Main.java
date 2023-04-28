package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        DataLoader dl = new DataLoader();
        DataSaver ds = new DataSaver();
        dl.loadData();
        Map<Produs, List<MetodePlata>> date = dl.getDataMap();
        Metods metode = new Metods();


        //metode.afisareProdus(date);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Alegeti o optiune: \n" +
                "0 - Iesire din program \n" +
                "1 - Cos cumparaturi initial \n" +
                "2 - Sectiunea imbracaminte \n" +
                "3 - CosCumparaturi \n" +
                "4 - Metode de plata \n" +
                "5 - Date despre produs \n");
        while (true) {
            System.out.println("Va rugam introduceti o optiune: ");
            int optiune = Integer.parseInt(scanner.nextLine());
            switch (optiune){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Afiseaza cos cumparaturi: ");
                    metode.afisareProdus(date);
                    break;
                case 2:
                    System.out.println("Imbracaminte ");
                    System.out.println("Introdu numele produsului:");
                    String nume = scanner.nextLine();
                    System.out.println("Introdu pretul produsului: ");
                    double pret = Double.parseDouble(scanner.nextLine());
                    System.out.println("introdu tipul produsului: ");
                    String tip = scanner.nextLine();
                    System.out.println("Introdu numarul de bucati: ");
                    int cantitate = Integer.parseInt(scanner.nextLine());
                    if (tip.equals("bluza")) {
                        int discount = 30;
                        Clothes imbracaminte = new Clothes(nume, pret, tip, cantitate);
                        imbracaminte.setDiscount(discount);
                        if (imbracaminte.getDiscount() > 0) {
                            imbracaminte.produs();
                        } else {
                            System.out.println("Pretul final nu se poate calcula deoarece discountul nu a fost valid");
                        }
                    }
                    if (tip.equals("pantaloni")) {
                        int discount = 20;
                        Clothes imbracaminte = new Clothes(nume, pret, tip, cantitate);
                        imbracaminte.setDiscount(discount);
                        if (imbracaminte.getDiscount() > 0) {
                            imbracaminte.produs();
                        } else {
                            System.out.println("Pretul final nu se poate calcula deoarece discountul nu a fost valid");
                        }
                    }
                    if (tip.equals("accesoriu")) {
                        int discount = 35;
                        Clothes imbracaminte = new Clothes(nume, pret, tip, cantitate);
                        imbracaminte.setDiscount(discount);
                        if (imbracaminte.getDiscount() > 0) {
                            imbracaminte.produs();
                        } else {
                            System.out.println("Pretul final nu se poate calcula deoarece discountul nu a fost valid");
                        }
                    }
                    Produs produsNou = new Produs(nume,pret,cantitate);
                    metode.adaugaProdus(produsNou, date);
                    ds.saveData(date);
                    break;
                case 3:
                    System.out.println("CosCumparaturi: ");
                    System.out.println("In cos aveti urmatoarele produse: ");
                    System.out.println("Pentru a finaliza cumparaturile apasati tasta 4:");

                    metode.afisareProdus(date);
                    ds.saveData(date);
                    break;
                case 4:
                    System.out.println("Metode de plata:");
                    metode.afisareMetodaPlata();
                    break;

                case 5:
                    Produs produseNoi = new Produs();
                    produseNoi.afiseazaDateProdus();
                    break;

            }
        }
    }
}

