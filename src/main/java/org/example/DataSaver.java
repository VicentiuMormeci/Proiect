package org.example;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class DataSaver {

    public void saveData(Map<Produs, List<MetodePlata>> date) throws IOException {
        saveProdus(date);

    }

    private void saveProdus(Map<Produs, List<MetodePlata>> date) throws IOException {
        Set<Produs> setProduse = date.keySet();
        String continut = "";
        for (Produs produs : setProduse) {
            continut = continut.concat(produs.toString().concat("\n"));
        }
        IncarcareDate.writeFile(IncarcareDate.CosCumparaturi_FILE_PATH, continut);
    }

}
