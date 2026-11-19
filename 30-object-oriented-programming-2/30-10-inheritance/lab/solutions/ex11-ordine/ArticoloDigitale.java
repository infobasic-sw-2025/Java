public class ArticoloDigitale extends Articolo {
    public ArticoloDigitale(String nome, double prezzo) {
        super(nome, prezzo);
    }

    @Override
    public double costoFinale() {
        return super.costoFinale() * 0.9;
    }
}
