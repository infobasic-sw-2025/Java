package scuola.modello;

public class Corso {
    private String nome;
    private Studente[] studenti;
    private int contatore;

    public Corso(String nome, int capienza) {
        this.nome = nome;
        this.studenti = new Studente[capienza];
        this.contatore = 0;
    }

    public void aggiungi(Studente s) {
        if (contatore < studenti.length) {
            studenti[contatore] = s;
            contatore++;
        } else {
            System.out.println("Corso pieno!");
        }
    }

    public void stampa() {
        System.out.println("=== " + nome + " (" + contatore + " iscritti) ===");
        for (int i = 0; i < contatore; i++) {
            System.out.println("  " + studenti[i]);
        }
    }
}
