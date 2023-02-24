package serie5;

public class BaumProzessor {
    private Knoten wurzelDesBaums;
    private Operator operator;

    public BaumProzessor(Knoten wurzelDesbaums, Operator operator){
        this.wurzelDesBaums = wurzelDesbaums;
        this.operator = operator;
    }

    public void berechneErgebnis(){
        verarbeiteKnoten(wurzelDesBaums);
        System.out.println(operator.getBezeichnung());
        System.out.println(operator.liefereErgebnis());
    }

    private void verarbeiteKnoten(Knoten knoten){
        operator.verarbeiteWert(knoten.getWert());
        for(Knoten kind : knoten.getKinder()){
            verarbeiteKnoten(kind);
        }
    }
}
