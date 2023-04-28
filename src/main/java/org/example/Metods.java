package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Metods {
    public void afisareProdus(Map<Produs, List<MetodePlata>> dataMap){
        System.out.println(dataMap.keySet());
    }

    public void adaugaProdus(Produs produs, Map<Produs, List<MetodePlata>> dataMap){
        dataMap.put(produs, new ArrayList<>());
    }
    public void afisareMetodaPlata(){
        HashMap<Object, Object> dataMap = null;
        System.out.println(dataMap.keySet());
    }
    public void selectareMetodaPlata(){

    }

    public void afiseazaCosCumparaturi (Produs produs, Map<Produs, List<MetodePlata>> dataMap) {
        System.out.println(dataMap.keySet());
    }
}
