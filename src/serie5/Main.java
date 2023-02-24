package serie5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Knoten blatt1 = new Knoten(9.2);
        Knoten blatt2 = new Knoten(5.3);
        Knoten blatt3 = new Knoten(1.0);
        Knoten innerer1 = new Knoten(3.1, Arrays.asList(blatt1));
        Knoten innerer2 = new Knoten(4.4, Arrays.asList(blatt2, blatt3));
        Knoten wurzel = new Knoten(7.0, Arrays.asList(innerer1, innerer2));

        Operator summenOp = new Summe();
        Operator durchschnittOp = new Durchschnitt();

        BaumProzessor baumProzessorSum = new BaumProzessor(wurzel, summenOp);
        BaumProzessor baumProzessorDurch = new BaumProzessor(wurzel, durchschnittOp);

        baumProzessorSum.berechneErgebnis();
        baumProzessorDurch.berechneErgebnis();
    }
}
