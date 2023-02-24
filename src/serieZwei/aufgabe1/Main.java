package serieZwei.aufgabe1;

public class Main {

    public static void main(String[] args) {
        Marktanteil marktanteil = new Marktanteil(5000, 5000);
        Marktsimulation marktsimulation = new Marktsimulation(marktanteil, 20, .8, .7);
        marktsimulation.simuliere();
        marktsimulation.zeigeMarktverlauf();
    }
}
