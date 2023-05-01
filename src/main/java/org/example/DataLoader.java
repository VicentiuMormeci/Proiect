package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class DataLoader {

    private Map<Produs, List<MetodePlata>> dataMap;
    private List<MetodePlata> listaMetode;

    public DataLoader(){
        dataMap = new HashMap<>();
        listaMetode = new ArrayList<>();
    }

        public void loadData() throws IOException {
            loadProdus();
            loadMetodeDePlata();
    }

    public void loadProdus() throws IOException{
        List<String> produsInputData = IncarcareDate.readFile(IncarcareDate.CosCumparaturi_FILE_PATH);
        for (String produsInputDatum : produsInputData){
            String[] data = produsInputDatum.split(",");
            Produs produse = createProdus(data);
            dataMap.put(produse, new ArrayList<>());
        }
    }
    public Produs createProdus(String[] data){
        String nume = data[0];
        Double pret = Double.parseDouble(data[1]);
        int cantitate = Integer.parseInt(data[2]);
        int discount = Integer.parseInt(data[3]);
        return new Produs(nume,pret,cantitate,discount);
    }
    private void loadMetodeDePlata() throws IOException{
        List<String> metode = IncarcareDate.readFile(IncarcareDate.MetodePlata_FILE_PATH);

        for (String line: metode){
            String[] datePlata = line.split(",");
            MetodePlata metodePlata = createMetodePlata(datePlata);
            listaMetode.add(metodePlata);
        }

    }
    private MetodePlata createMetodePlata(String[] datePlata){
        String card = datePlata[0];
        String cash = datePlata[1];
        MetodePlata metodePlata = new MetodePlata (card,cash);
        return metodePlata;
    }


    public Map<Produs, List<MetodePlata>> getDataMap() {
        return dataMap;
    }
}
