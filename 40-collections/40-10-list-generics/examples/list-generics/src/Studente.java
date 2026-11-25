public class Studente {

    private String nome;
    private int voto;

    public Studente(String nome, int voto) {
        this.nome = nome;
        this.voto = voto;
    }

    public String getNome() {
        return nome;
    }

    public int getVoto() {
        return voto;
    }

    // decide come appare lo studente quando si stampa la lista
    @Override
    public String toString() {
        return nome + " (" + voto + ")";
    }
}
