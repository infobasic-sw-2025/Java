public class Gatto extends Animale {

    private boolean indoor;

    public Gatto(String nome, boolean indoor) {
        super(nome);
        this.indoor = indoor;
    }

    public boolean isIndoor() {
        return indoor;
    }

    @Override
    public String verso() {
        return "Miao!";
    }

    @Override
    public String toString() {
        return super.toString() + (indoor ? " (indoor)" : " (outdoor)");
    }
}
