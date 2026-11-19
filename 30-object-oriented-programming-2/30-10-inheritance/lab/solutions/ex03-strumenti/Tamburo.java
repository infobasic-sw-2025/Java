public class Tamburo extends Strumento {
    public Tamburo(String nome) {
        super(nome);
    }

    @Override
    public String suona() {
        return "Bum bum!";
    }
}
