package serieDrei;

import java.util.*;

public class MenuePlaner {

    private List<Zutat> zutatenListe;
    private Map<String, List<Gericht>> speiseplan;

    public MenuePlaner(Zutat[] zutatenArray) {
        zutatenListe = new ArrayList<Zutat>(Arrays.asList(zutatenArray));
        speiseplan = new HashMap<>();
    }

    private int zufallszahl(int minimum, int maximum) {
        return (int) (Math.random() * (maximum + 1 - minimum)) + minimum;
    }

    public Gericht erstelleGericht() {
        int anzahlZutaten = zufallszahl(3, 5);
        int hinzugefuegt = 0;
        Gericht gericht = new Gericht();
        while (hinzugefuegt < anzahlZutaten) {
            Zutat zutat = zutatenListe.get(zufallszahl(0, zutatenListe.size() - 1));
            if (!gericht.getZutaten().contains(zutat)) {
                gericht.addZutat(zutat);
                hinzugefuegt++;
            }
        }
        return gericht;
    }

    public void erstelleMenueFuerWochentag(String tag, int anzahlGerichte) {
        List<Gericht> gerichte = new ArrayList<>();
        for (int i = 0; i < anzahlGerichte; i++) {
            gerichte.add(erstelleGericht());
        }
        speiseplan.put(tag, gerichte);
    }

    public void erstelleSpeiseplan() {
        erstelleMenueFuerWochentag("Montag", 4);
        erstelleMenueFuerWochentag("Dienstag", 4);
        erstelleMenueFuerWochentag("Mittwoch", 5);
    }

    public String getMenueFuerWochentag(String tag) {
        if (speiseplan.containsKey(tag)) {
            StringBuilder rueckgabe = new StringBuilder();
            rueckgabe.append(tag).append(": \n");
            Collections.sort(speiseplan.get(tag));
            for (Gericht gericht : speiseplan.get(tag)) {
                rueckgabe.append(gericht).append("\n");
            }
            return rueckgabe.toString();
        }
        return "Die Mensa hat heute geschlossen!";
    }
}