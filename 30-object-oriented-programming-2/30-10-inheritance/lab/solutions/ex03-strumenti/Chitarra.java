public class Chitarra extends Strumento {
    public Chitarra(String nome) {
        super(nome);
    }

    @Override
    public String suona() {
        return "Tlin tlin!";
    }
}
