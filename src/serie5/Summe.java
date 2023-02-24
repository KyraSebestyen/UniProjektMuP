package serie5;

public class Summe implements Operator{
    private double summe;

    public Summe(){

    }

    @Override
    public void verarbeiteWert(double wert){
        summe += wert;
    }

    @Override
    public double liefereErgebnis(){
        return summe;
    }

    @Override
    public String getBezeichnung(){
        return "Summe:";
    }
}
