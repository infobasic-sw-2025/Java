public class Serpente extends Animale {
    private boolean velenoso;

    public Serpente(String nome, boolean velenoso) {
        super(nome, "Serpente");
        this.velenoso = velenoso;
    }

    @Override
    public String verso() {
        return "Sss!";
    }

    @Override
    public String toString() {
        return super.toString() + (velenoso ? ", velenoso" : "");
    }
}
