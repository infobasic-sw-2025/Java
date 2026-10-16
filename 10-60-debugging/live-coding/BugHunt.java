/**
 * BugHunt.java — Programma con 5 bug intenzionali.
 *
 * Obiettivo: trovare e correggere tutti i bug durante il live coding.
 * I bug coprono le tre categorie: compilazione, runtime e logici.
 *
 * Per compilare (con errori): javac BugHunt.java
 */
public class BugHunt {

    public static void main(String[] args) {

        // ── BUG 1 (compilazione): manca il punto e virgola ──
        int punteggio = 100;  // BUG 1 — originale: int punteggio = 100

        // ── BUG 2 (compilazione): tipo incompatibile ──
        int eta = 25;         // BUG 2 — originale: int eta = "25";

        System.out.println("Punteggio: " + punteggio);
        System.out.println("Età: " + eta);

        // ── BUG 3 (runtime): divisione per zero ──
        int studenti = 5;     // BUG 3 — originale: int studenti = 0;
        int totaleVoti = 140;
        int media = totaleVoti / studenti;
        System.out.println("Media voti: " + media);

        // ── BUG 4 (runtime): indice fuori dai limiti ──
        int[] voti = {28, 30, 25, 27};
        System.out.println("Ultimo voto: " + voti[3]);  // BUG 4 — originale: voti[4]

        // ── BUG 5 (logico): operatore sbagliato per l'area ──
        int base = 8;
        int altezza = 5;
        int area = base * altezza;   // BUG 5 — originale: base + altezza
        System.out.println("Area rettangolo: " + area);
    }
}
