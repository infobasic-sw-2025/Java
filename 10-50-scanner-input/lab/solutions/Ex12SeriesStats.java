import java.util.Scanner;

public class Ex12SeriesStats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int conteggio = 0;
        int somma = 0;
        int minimo = Integer.MAX_VALUE; // qualsiasi numero inserito sarà minore o uguale
        int massimo = Integer.MIN_VALUE; // qualsiasi numero inserito sarà maggiore o uguale

        while (true) {
            System.out.print("Numero (0 per terminare): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Valore non numerico, riprova");
                scanner.next();
                continue;
            }

            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }

            conteggio++;
            somma += n;
            if (n < minimo) {
                minimo = n;
            }
            if (n > massimo) {
                massimo = n;
            }
        }

        // Senza numeri la media sarebbe una divisione per zero
        if (conteggio == 0) {
            System.out.println("Nessun numero inserito");
        } else {
            double media = (double) somma / conteggio;
            System.out.println("Numeri inseriti: " + conteggio);
            System.out.println("Somma: " + somma);
            System.out.println("Media: " + media);
            System.out.println("Minimo: " + minimo);
            System.out.println("Massimo: " + massimo);
        }
    }
}
