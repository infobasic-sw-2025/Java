public class Leone extends Animale {
    private boolean maschio;

    public Leone(String nome, boolean maschio) {
        super(nome, "Leone");
        this.maschio = maschio;
    }

    @Override
    public String verso() {
        return "Ruggito!";
    }

    @Override
    public String toString() {
        return super.toString() + (maschio ? ", con la criniera" : "");
    }
}
