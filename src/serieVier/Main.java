package serieVier;

public class Main {
    public static void main(String[] args) {
        try {
            BuchstabenStat buchstabenStat = new BuchstabenStat();
            buchstabenStat.analysiere("Faust.txt");
            buchstabenStat.zeigeTopTen();
            buchstabenStat.schreibeStatistik("FaustStat.txt");
        } catch (FalscherDateiTypException | UngueltigesZeichenException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
