package serieVier;

import java.io.*;
import java.util.*;

public class BuchstabenStat {
    private Map<Character, Integer> buchstabenHauefigkeiten;
    private long buchstabenAnzahl;

    public BuchstabenStat() {
        buchstabenHauefigkeiten = new TreeMap<>();
        buchstabenAnzahl = 0;
    }

    private void pruefeDateityp(String dateiname) throws FalscherDateiTypException {
        if (!dateiname.toUpperCase().endsWith(".TXT")) {
            throw new FalscherDateiTypException(dateiname);
        }

    }


    private void verarbeiteZeichen(char zeichen) throws UngueltigesZeichenException {
        boolean isLetter = Character.isLetter(zeichen);
        if (isLetter) {
            zeichen = Character.toUpperCase(zeichen);
            buchstabenAnzahl++;
            if (buchstabenHauefigkeiten.containsKey(zeichen)) {
                int aktuelleAnzahl = buchstabenHauefigkeiten.get(zeichen);
                buchstabenHauefigkeiten.put(zeichen, aktuelleAnzahl + 1);
            } else {
                buchstabenHauefigkeiten.put(zeichen, 1);
            }
        } else {
            if (!Character.isDefined(zeichen)) {
                throw new UngueltigesZeichenException();
            }
        }
    }

    private void verarbeiteZeile(String zeile) throws UngueltigesZeichenException {
        for (int i = 0; i < zeile.length(); i++) {
            verarbeiteZeichen(zeile.charAt(i));
        }
    }

    public void analysiere(String dateiname) throws FalscherDateiTypException, UngueltigesZeichenException {
        pruefeDateityp(dateiname);
        File file = new File(dateiname);
        int zeilenZaehler = 0;
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String aktuelleZeile = bufferedReader.readLine();
            while (aktuelleZeile != null) {
                verarbeiteZeile(aktuelleZeile);
                zeilenZaehler++;
                aktuelleZeile = bufferedReader.readLine();
            }
        } catch (FileNotFoundException fnfEx) {
            System.err.println("File not found");
            System.exit(1);
        } catch (IOException ioException) {
            System.err.println("IO Exception");
            System.exit(1);
        } catch (UngueltigesZeichenException e) {
            throw new UngueltigesZeichenException(dateiname, zeilenZaehler);
        }
    }

    public void zeigeTopTen() {
      List<Map.Entry<Character, Integer>> sortierteListe = new ArrayList(buchstabenHauefigkeiten.entrySet());
        Collections.sort(sortierteListe, Map.Entry.comparingByValue());
        System.out.println("Buchstaben-Top 10:");
        for(int i = 1; i<=10; i++){
            Map.Entry eintrag = sortierteListe.get(sortierteListe.size()-i);
            System.out.println(eintrag.getKey() + ": " + eintrag.getValue());
        }
    }

    public String statistik() {
        double prozentanteil;
        StringBuilder ausgabe = new StringBuilder();
        for (Map.Entry<Character, Integer> eintrag : buchstabenHauefigkeiten.entrySet()) {
            prozentanteil = Math.round((double) eintrag.getValue() / buchstabenAnzahl * 100) / 100.0;
            ausgabe.append(eintrag.getKey()).append(": ").append(prozentanteil).append("\n");
        }
        return ausgabe.toString();
    }

    public void schreibeStatistik(String dateiname) {
        File file = new File(dateiname);
        try (FileWriter fw = new FileWriter(file);

             BufferedWriter bw = new BufferedWriter
                     (fw);

             PrintWriter pw = new PrintWriter(bw);
        ) {
            pw.print(statistik());
        } catch (IOException ioEx) {
            System.err.println("IO Exception");
            System.exit(1);
        }

    }
}

