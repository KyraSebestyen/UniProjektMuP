package serie5;

public class Durchschnitt implements Operator{
    private int anzahlSummanden;
    private double summe;

    public Durchschnitt(){

    }

    @Override
    public void verarbeiteWert(double wert){
        summe += wert;
        anzahlSummanden += 1;
    }

    @Override
    public double liefereErgebnis(){
        return summe/anzahlSummanden;
    }

    @Override
    public String getBezeichnung(){
        return "Durchschnitt:";
    }
}
