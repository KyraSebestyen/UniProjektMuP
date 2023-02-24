package serieDrei;

import java.util.ArrayList;
import java.util.List;

public class Gericht implements Comparable<Gericht> {
    private List<Zutat> zutaten;
    private double preis;

    public Gericht() {
        this.zutaten = new ArrayList<>();
        this.preis = 1.0;
    }

    public void addZutat(Zutat zutat) {
        zutaten.add(zutat);
        preis = preis + zutat.getPreis();
    }

    public boolean hatZutat(Zutat zutat) {
        return zutaten.contains(zutat);
    }

    public String getName() {
        StringBuilder name = new StringBuilder();
        for (Zutat zutat : zutaten) {
            name.append(zutat.getName(), 0, 3);
        }
        return name.toString();
    }

    public boolean istVegan() {
        for (Zutat zutat : zutaten) {
            if (!zutat.getVegan()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder vollstaendigerName = new StringBuilder();
        vollstaendigerName.append(getName()).append(" ");
        if (istVegan()) {
            vollstaendigerName.append("(vegan) ");
        }
        for (Zutat zutat : zutaten) {
            vollstaendigerName.append(zutat.getName()).append(" ");
        }

        vollstaendigerName.append(String.format("%.2f", preis)).append(" Euro");
        return vollstaendigerName.toString();
    }

    @Override
    public int compareTo(Gericht vergleichsobjekt) {
        if (vergleichsobjekt.getPreis() > this.preis) {
            return -1;
        } else if (vergleichsobjekt.getPreis() == this.preis) {
            return 0;
        } else {
            return 1;
        }
    }

    public double getPreis() {
        return preis;
    }

    public List<Zutat> getZutaten() {
        return zutaten;
    }
}
