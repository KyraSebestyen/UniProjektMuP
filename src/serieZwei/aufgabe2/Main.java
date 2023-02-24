package serieZwei.aufgabe2;

public class Main {
    public static void main(String[] args) {
        Verwaltung verwaltung = new Verwaltung(20);
        Angestellter angestellter = new Angestellter("Müller", 10000.0);
        verwaltung.addMitarbeiter(angestellter);
        verwaltung.addMitarbeiter(new Angestellter("Meier", 60000.0));
        verwaltung.addMitarbeiter(new Angestellter("Schmidt", 40000.5));
        verwaltung.addMitarbeiter(new Angestellter("Schulz", 1000.8));
        verwaltung.addMitarbeiter(new Arbeiter("Mustermann", 9.5, 19));
        verwaltung.addMitarbeiter(new Arbeiter("Musterfrau", 10.5, 12));
        verwaltung.addMitarbeiter(new Arbeiter("Duck", 100.0, 30));
        verwaltung.addMitarbeiter(new Arbeiter("Mouse", 9.35, 40));
        System.out.println(verwaltung.berechnePersonalkosten());
        verwaltung.removeMitarbeiter(angestellter);
        System.out.println(verwaltung.berechnePersonalkosten());
        verwaltung.zeigeArbeiterMitWenigerAlsXStunden(20);
    }
}
