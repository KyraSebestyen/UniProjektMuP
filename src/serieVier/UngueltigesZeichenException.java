package serieVier;

public class UngueltigesZeichenException extends Exception {
    public UngueltigesZeichenException() {
        super("Ungültiges Zeichen");
    }

    public UngueltigesZeichenException(String dateiname, int zeilennumer) {
        super("Ungültiges Zeichen in " + dateiname + " Zeile " + zeilennumer);
    }
}
