package serieZwei;

import java.util.ArrayList;
import java.util.Collections;

public class Uebung {
    public static void main(String[] args) {
        ArrayList<Double> arrayList = new ArrayList<>(); //neue ArrayList mit doubles

        for(int i = 0; i < 10; i++){ //durch alle Elemente iterieren
            arrayList.add((double) Math.round(Math.random()*10.0)); //jedes Element mit Zufallsdouble belegen
        }

        System.out.print("Unsortiert: " + arrayList); //ArrayList printen

        Collections.sort(arrayList); //ArrayList sortieren -> dafür auf Collections zurückgreifen

        System.out.print("\n Sortiert: " + arrayList); //ArrayList printen
    }
}
