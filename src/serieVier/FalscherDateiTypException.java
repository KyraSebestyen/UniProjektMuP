package serieVier;

public class FalscherDateiTypException extends Exception {
    public FalscherDateiTypException(String dateiname) {
        super(dateiname + " hat eine nicht kompatible Dateiendung.");
    }
}
