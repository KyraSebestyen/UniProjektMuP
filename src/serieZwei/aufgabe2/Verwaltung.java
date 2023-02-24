package serieZwei.aufgabe2;

public class Verwaltung {
    private Mitarbeiter[] mitarbeiter;

    public Verwaltung(int anzahlMitarbeiter) {
        this.mitarbeiter = new Mitarbeiter[anzahlMitarbeiter];
    }

    public Mitarbeiter[] getMitarbeiter() {
        return mitarbeiter;
    }

    public boolean addMitarbeiter(Mitarbeiter neuerMitarbeiter){
        for(int i = 0; i < mitarbeiter.length; i++){
            if(mitarbeiter[i] == null){
                mitarbeiter[i] = neuerMitarbeiter;
                return true;
            }
        }
        return false;
    }

    public boolean removeMitarbeiter(Mitarbeiter mitarbeiter){
        for(int i = 0; i < this.mitarbeiter.length; i++){
            if(this.mitarbeiter[i] == mitarbeiter){
                this.mitarbeiter[i] = null;
                return true;
            }
        }
        return false;
    }

    public double berechnePersonalkosten(){
        double personalkosten = 0.0;
        for(Mitarbeiter mitarbeiter : mitarbeiter) {
            if (mitarbeiter != null) {
                personalkosten += mitarbeiter.berechneVerdienst();
            }
        }
        return personalkosten;
    }

    public void zeigeArbeiterMitWenigerAlsXStunden(double stunden){
        System.out.println("Arbeiter mit weniger als " + stunden + " Stunden:");
        for(Mitarbeiter mitarbeiter : mitarbeiter){
            if(mitarbeiter instanceof Arbeiter && ((Arbeiter) mitarbeiter).getGeleisteteStunden() < stunden){
                System.out.println(mitarbeiter.toString());
            }
        }
    }
}
