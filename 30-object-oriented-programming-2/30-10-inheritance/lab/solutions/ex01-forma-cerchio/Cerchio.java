public class Cerchio extends Forma {
    private double raggio;

    public Cerchio(String colore, double raggio) {
        super(colore);
        this.raggio = raggio;
    }

    @Override
    public String descrizione() {
        return super.descrizione() + ", raggio: " + raggio;
    }
}
