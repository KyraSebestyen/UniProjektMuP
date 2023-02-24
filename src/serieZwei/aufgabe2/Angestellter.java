package serieZwei.aufgabe2;

public class Angestellter extends Mitarbeiter {
    private double gehalt;

    public Angestellter(String name, double gehalt){
        super(name);
        this.gehalt = gehalt;
    }

    public double getGehalt() {
        return gehalt;
    }

    public void setGehalt(double gehalt) {
        this.gehalt = gehalt;
    }

   public double berechneVerdienst(){
        return gehalt;
    }

    public String toString(){
        return String.format("%s Gehalt: %.2f Euro",getName(), berechneVerdienst());
    }
}
