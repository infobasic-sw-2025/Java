import java.util.Scanner;

public class SentinelSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int somma = 0;

        while (true) {
            System.out.print("Numero (0 per terminare): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Valore non numerico, riprova");
                scanner.next(); // scarta il token non valido
                continue;
            }

            int n = scanner.nextInt();

            if (n == 0) {
                break; // sentinella: fine dell'input
            }
            if (n > 0) {
                somma += n; // i negativi si ignorano
            }
        }

        System.out.println("Somma dei numeri positivi: " + somma);
    }
}
