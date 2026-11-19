public class ProdottoScontato extends Prodotto {
    private int sconto;

    public ProdottoScontato(String nome, double prezzo, int sconto) {
        super(nome, prezzo);
        this.sconto = sconto;
    }

    public double getPrezzoScontato() {
        return getPrezzo() - getPrezzo() * sconto / 100;
    }

    @Override
    public String toString() {
        return super.toString() + " (sconto " + sconto + "%)";
    }
}
