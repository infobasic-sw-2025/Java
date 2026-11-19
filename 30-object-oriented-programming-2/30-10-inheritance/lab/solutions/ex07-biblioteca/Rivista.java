public class Rivista extends Pubblicazione {
    private int numero;

    public Rivista(String titolo, int anno, int numero) {
        super(titolo, anno);
        this.numero = numero;
    }

    @Override
    public String toString() {
        return super.toString() + ", numero " + numero;
    }
}
