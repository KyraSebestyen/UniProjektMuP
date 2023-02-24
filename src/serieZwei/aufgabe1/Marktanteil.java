package serieZwei.aufgabe1;

public class Marktanteil {
    private int kaeuferVonA;
    private int kaeuferVonB;

    public Marktanteil(int kaeuferVonA, int kaeuferVonB) {
        this.kaeuferVonA = kaeuferVonA;
        this.kaeuferVonB = kaeuferVonB;
    }

    public int getKaeuferVonA() {
        return kaeuferVonA;
    }

    public int getKaeuferVonB() {
        return kaeuferVonB;
    }

    public Marktanteil naechsterTag(double bleibBeiA, double bleibBeiB) {
        int newA =  (int) (Math.round(kaeuferVonA * bleibBeiA) + Math.round(kaeuferVonB * (1 - bleibBeiB)));
        int newB = kaeuferVonA + kaeuferVonB - newA;

        return new Marktanteil(newA, newB);
    }

    public String toString() {
        int percentageA = (int) Math.round((double) 100 * kaeuferVonA / (kaeuferVonA + kaeuferVonB));
        int percentageB = 100 - percentageA;
        return "Marktanteil Käufer Produkt A: " + kaeuferVonA + "(" + percentageA + "%)\n" +
        "Käufer Produkt B: " + kaeuferVonB + "(" + percentageB + "%)";
    }
}
