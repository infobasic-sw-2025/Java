import java.util.Scanner;

/**
 * Esempi 2/2 — Validazione input e menu testuale.
 *
 * Argomenti:
 *  - hasNextInt(): controllare il tipo prima di leggere
 *  - ciclo di validazione: chiedere di nuovo se il dato è errato
 *  - validazione di un intervallo
 *  - menu testuale con do-while e switch
 *  - ciclo con sentinella
 */
public class ScannerLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ── 1. Validazione del tipo ────────────────────────────
        // hasNextInt() controlla se il prossimo token è un intero
        // SENZA consumarlo. Se non lo è, next() scarta il token.
        System.out.println("=== Validazione tipo ===");

        System.out.print("Inserisci un intero: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Non è un intero, riprova");
            scanner.next(); // scarta il token non valido
            System.out.print("Inserisci un intero: ");
        }

        int numero = scanner.nextInt();
        System.out.println("Hai inserito: " + numero);
        scanner.nextLine(); // consumo '\n'

        // ── 2. Validazione di un intervallo ────────────────────
        // Il ciclo controlla sia il tipo sia il range.
        System.out.println("\n=== Validazione intervallo ===");

        int voto;

        while (true) {
            System.out.print("Voto (1-10): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Inserisci un numero");
                scanner.next();
                continue;
            }

            voto = scanner.nextInt();

            if (voto >= 1 && voto <= 10) {
                break; // valore valido, esco dal ciclo
            }

            System.out.println("Il voto deve essere tra 1 e 10");
        }

        System.out.println("Voto registrato: " + voto);
        scanner.nextLine(); // consumo '\n'

        // ── 3. Somma con sentinella ────────────────────────────
        // L'utente inserisce numeri; 0 termina il ciclo.
        // I valori non numerici vengono scartati.
        System.out.println("\n=== Somma con sentinella ===");

        int somma = 0;

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
            if (n < 0) {
                System.out.println("Numero negativo ignorato");
                continue;
            }

            somma += n;
        }

        System.out.println("Somma dei numeri positivi: " + somma);
        scanner.nextLine(); // consumo '\n'

        // ── 4. Menu testuale ───────────────────────────────────
        // Un do-while che mostra le opzioni e legge la scelta.
        // Lo switch-freccia esegue l'azione corrispondente.
        System.out.println("\n=== Menu testuale ===");

        int scelta;

        do {
            System.out.println();
            System.out.println("1. Saluta");
            System.out.println("2. Somma due numeri");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            // Validazione: se non è un intero, chiedi di nuovo
            if (!scanner.hasNextInt()) {
                System.out.println("Inserisci un numero");
                scanner.next();
                scelta = -1; // forza un altro giro
                continue;
            }

            scelta = scanner.nextInt();
            scanner.nextLine(); // consumo '\n'

            switch (scelta) {
                case 1 -> System.out.println("Ciao dal menu!");

                case 2 -> {
                    System.out.print("Primo numero: ");
                    int a = scanner.nextInt();
                    System.out.print("Secondo numero: ");
                    int b = scanner.nextInt();
                    System.out.println("Risultato: " + (a + b));
                    scanner.nextLine(); // consumo '\n'
                }

                case 0 -> System.out.println("Arrivederci!");

                default -> System.out.println("Scelta non valida");
            }

        } while (scelta != 0);
    }
}
