public class Animale {
    private String nome;
    private String specie;

    public Animale(String nome, String specie) {
        this.nome = nome;
        this.specie = specie;
    }

    public String getNome() {
        return nome;
    }

    public String getSpecie() {
        return specie;
    }

    public String verso() {
        return "...";
    }

    @Override
    public String toString() {
        return nome + " (" + specie + ")";
    }
}
