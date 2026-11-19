public class Animale {

    private String nome;

    public Animale(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String verso() {
        return "...";
    }

    @Override
    public String toString() {
        return nome;
    }
}
