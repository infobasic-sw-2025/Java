package scuola.app;

import scuola.modello.Studente;
import scuola.modello.Corso;

public class Main {
    public static void main(String[] args) {
        Corso corso = new Corso("Programmazione Java", 30);

        corso.aggiungi(new Studente("Marco Rossi", "MAT001"));
        corso.aggiungi(new Studente("Laura Bianchi", "MAT002"));
        corso.aggiungi(new Studente("Luca Verdi", "MAT003"));

        corso.stampa();
    }
}
