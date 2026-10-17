// 3/3 · Cicli, break e continue
public class Loops {
    public static void main(String[] args) {
        // Conto alla rovescia: da 3 a 1, poi "Via!"
        int n = 3;
        while (n > 0) {
            System.out.println(n);
            n--;
        }
        System.out.println("Via!");

        // Un while che gira finché la condizione resta vera: qui la rendiamo falsa al primo giro
        boolean loopCondition = true;
        while (loopCondition) {
            System.out.println("Giro del ciclo");
            loopCondition = false;   // senza questa riga sarebbe un loop infinito
        }
        System.out.println("Sono uscito dal ciclo");

        // Stampiamo n anche se la condizione è già falsa: il corpo si esegue almeno una volta
        n = 10;
        do {
            System.out.println("n = " + n);
            n++;
        } while (n < 5);

        // Stampiamo i numeri da 1 a 5 con un contatore
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Sommiamo i numeri da 1 a 10 e contiamo quanti sono pari
        int somma = 0;
        int pari = 0;
        for (int i = 1; i <= 10; i++) {
            somma += i;
            if (i % 2 == 0) pari++;
        }
        System.out.println("Somma: " + somma + ", pari: " + pari);

        // Cicli annidati: per ogni giro di i, j fa tutti i suoi giri
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Indice [" + i + "][" + j + "], somma: " + (i + j));
            }
        }

        // Stampiamo una tabellina 3×4
        for (int riga = 1; riga <= 3; riga++) {
            for (int col = 1; col <= 4; col++) {
                System.out.print(riga * col + "\t");
            }
            System.out.println();
        }

        // Troviamo il primo divisore di 91 e ci fermiamo
        int numero = 91;
        for (int d = 2; d < numero; d++) {
            if (numero % d == 0) {
                System.out.println("Primo divisore di 91: " + d);
                break;
            }
        }

        // Stampiamo da 1 a 10 saltando i multipli di 3
        for (int i = 1; i <= 10; i++) {
            if (i % 3 == 0) continue;
            System.out.print(i + " ");
        }
        System.out.println();

        // Troviamo il primo n il cui quadrato supera 50
        n = 0;
        while (true) {
            n++;
            if (n * n > 50) break;
        }
        System.out.println("Primo n con n*n > 50: " + n);
    }
}
