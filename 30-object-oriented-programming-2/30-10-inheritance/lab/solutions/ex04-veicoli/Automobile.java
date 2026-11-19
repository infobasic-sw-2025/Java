public class Automobile extends Veicolo {
    private int porte;

    public Automobile(String targa, int posti, int porte) {
        super(targa, posti);
        this.porte = porte;
    }

    @Override
    public String toString() {
        return getTarga() + ":" + porte;
    }
}
