public class PersonalCard {
    public static void main(String[] args) {
        final int ANNO_CORRENTE = 2026;

        String nome = "Anna";
        char iniziale = 'R';
        int eta = 22;
        double altezza = 1.68;
        boolean studente = true;
        var citta = "Torino";

        int annoDiNascita = ANNO_CORRENTE - eta;

        System.out.println("Nome: " + nome + " " + iniziale + ".");
        System.out.println("Età: " + eta + " anni");
        System.out.println("Anno di nascita: " + annoDiNascita);
        System.out.println("Altezza: " + altezza + " m");
        System.out.println("Studente: " + studente);
        System.out.println("Città: " + citta);
    }
}
