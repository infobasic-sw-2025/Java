public class Autocarro extends Veicolo {
    private double caricoMax;

    public Autocarro(String targa, int posti, double caricoMax) {
        super(targa, posti);
        this.caricoMax = caricoMax;
    }

    @Override
    public String toString() {
        return getTarga() + ":" + caricoMax;
    }
}
