public class Cane extends Animale {

    private String razza;

    public Cane(String nome, String razza) {
        super(nome);
        this.razza = razza;
    }

    public String getRazza() {
        return razza;
    }

    @Override
    public String verso() {
        return "Bau!";
    }

    @Override
    public String toString() {
        return super.toString() + " (" + razza + ")";
    }
}
