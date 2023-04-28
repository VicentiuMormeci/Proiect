package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataLoader {

    private Map<Produs, List<MetodePlata>> dataMap;

    private List<MetodePlata> metodePlataList;

    public DataLoader() {
        dataMap = new HashMap<>();
        metodePlataList = new ArrayList<>();

    }

    public void loadData() throws IOException {
        loadProdus();
        loadMetodePlata();
    }


    private void loadProdus() throws IOException {
        List<String> produsInputData = IncarcareDate.readFile(IncarcareDate.CosCumparaturi_FILE_PATH);
        for (String produsInputDatum : produsInputData) {
            String[] data = produsInputDatum.split(",");
            Produs produsNou = createProdus(data);
            dataMap.put(produsNou, new ArrayList<>());
        }
    }

    private Produs createProdus(String[] data) {
        String nume = data[0];
        double pret = Double.parseDouble(data[1]);
        int discount = Integer.parseInt(data[2]);
        int cantitate = Integer.parseInt(data[3]);
        return new Produs(nume,pret, discount,cantitate);
    }

    private void loadMetodePlata() throws IOException {
        List<String> plataInputdata = IncarcareDate.readFile(IncarcareDate.MetodePlata_FILE_PATH);
        for (String plataInputDatum : plataInputdata) {
            String[] metodeDePlata = plataInputDatum.split(",");
            MetodePlata metodePlata = createMetodePlata(metodeDePlata);
            metodePlataList.add(metodePlata);
        }
    }
    private MetodePlata createMetodePlata(String[] datePlata) {
        String card = datePlata[0];
        String cash = datePlata[1];

        MetodePlata metodePlata = new MetodePlata(card, cash);
        return metodePlata;
    }

    public Map<Produs, List<MetodePlata>> getDataMap() {
        return dataMap;
    }

}