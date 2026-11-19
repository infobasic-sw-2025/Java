public class ArticoloFisico extends Articolo {
    private double peso;

    public ArticoloFisico(String nome, double prezzo, double peso) {
        super(nome, prezzo);
        this.peso = peso;
    }

    @Override
    public double costoFinale() {
        return super.costoFinale() + peso * 2.5;
    }
}
