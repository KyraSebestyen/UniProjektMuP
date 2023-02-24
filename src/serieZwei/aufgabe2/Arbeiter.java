package serieZwei.aufgabe2;

public class Arbeiter extends Mitarbeiter{
    private double stundenlohn;
    private double geleisteteStunden;

    Arbeiter(String name, double stundenlohn, double geleisteteStunden){
        super(name);
        this.stundenlohn = stundenlohn;
        this.geleisteteStunden = geleisteteStunden;
    }

    public double getStundenlohn(){
        return stundenlohn;
    }

    public void setStundenlohn(double stundenlohn){

    }

    public double getGeleisteteStunden(){
        return geleisteteStunden;
    }

    public void setGeleisteteStunden(double geleisteteStunden){

    }


    public double berechneVerdienst(){
        return geleisteteStunden*stundenlohn;
    }

    public String toString(){
        return String.format("%s Stundenlohn: %.2f Euro geleistete Stunden: %.1f Stunden",
                getName(), stundenlohn, geleisteteStunden);
    }
}
