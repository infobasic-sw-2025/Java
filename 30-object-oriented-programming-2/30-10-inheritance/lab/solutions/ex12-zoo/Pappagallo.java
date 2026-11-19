public class Pappagallo extends Animale {
    private boolean parla;

    public Pappagallo(String nome, boolean parla) {
        super(nome, "Pappagallo");
        this.parla = parla;
    }

    @Override
    public String verso() {
        return "Cra cra!";
    }

    @Override
    public String toString() {
        return super.toString() + (parla ? ", sa parlare" : "");
    }
}
