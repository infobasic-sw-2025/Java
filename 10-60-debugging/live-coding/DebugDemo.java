/**
 * DebugDemo.java — Programma con un errore logico sottile.
 *
 * Il programma calcola la media di un array di voti,
 * ma usa la divisione intera: il risultato viene troncato.
 *
 * Obiettivo: usare println e il debugger per trovare il problema.
 */
public class DebugDemo {

    public static void main(String[] args) {
        int[] voti = {28, 30, 25, 27, 29};

        int somma = 0;
        for (int i = 0; i < voti.length; i++) {
            somma += voti[i];
        }

        // BUG LOGICO: divisione intera tronca il decimale
        // somma = 139, voti.length = 5 → 139 / 5 = 27 (non 27.8)
        double media = somma / voti.length;

        System.out.println("Somma: " + somma);
        System.out.println("Numero voti: " + voti.length);
        System.out.println("Media: " + media);
        System.out.println("Media attesa: 27.8");

        // Dopo aver trovato il bug, la correzione è:
        // double media = (double) somma / voti.length;
    }
}
