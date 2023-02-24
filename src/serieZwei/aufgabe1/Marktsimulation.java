package serieZwei.aufgabe1;

public class Marktsimulation {
    private Marktanteil[] tagesMarktanteil;
    private double bleibBeiA;
    private double bleibBeiB;

    public Marktsimulation(Marktanteil start, int tage, double bleibBeiA, double bleibBeiB) {
        this.bleibBeiA = bleibBeiA;
        this.bleibBeiB = bleibBeiB;
        tagesMarktanteil = new Marktanteil[tage + 1];
        tagesMarktanteil[0] = start;
    }

    public void simuliere() {
        for (int i = 1; i < tagesMarktanteil.length; i++) {
            tagesMarktanteil[i] = tagesMarktanteil[i - 1].naechsterTag(bleibBeiA, bleibBeiB);
        }
    }

    public void zeigeMarktverlauf() {
        System.out.print("Marktentwicklung\nProdukt A: ");
        for (Marktanteil marktanteil : tagesMarktanteil) {
            System.out.print(marktanteil.getKaeuferVonA() + " ");
        }
        System.out.print("\nProdukt B: ");
        for (Marktanteil marktanteil : tagesMarktanteil) {
            System.out.print(marktanteil.getKaeuferVonB() + " ");
        }
        System.out.println("\nFinale Marktaufteilung:");
        System.out.println(tagesMarktanteil[tagesMarktanteil.length - 1].toString());
    }
}
