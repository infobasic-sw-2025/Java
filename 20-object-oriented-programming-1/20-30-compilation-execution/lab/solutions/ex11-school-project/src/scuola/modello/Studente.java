package scuola.modello;

public class Studente {
    private String nome;
    private String matricola;

    public Studente(String nome, String matricola) {
        this.nome = nome;
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricola() {
        return matricola;
    }

    public String toString() {
        return matricola + " - " + nome;
    }
}
