public class Delfino extends Animale {
    public Delfino(String nome) {
        super(nome, "Delfino");
    }

    @Override
    public String verso() {
        return "Click click!";
    }

    @Override
    public String toString() {
        return super.toString() + ", vive in acqua";
    }
}
