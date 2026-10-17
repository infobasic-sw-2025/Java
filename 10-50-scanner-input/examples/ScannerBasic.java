import java.util.Locale;
import java.util.Scanner;

/**
 * Esempi 1/2 — Scanner e input base.
 *
 * Argomenti:
 *  - creare un oggetto Scanner
 *  - nextLine(): leggere una stringa
 *  - nextInt(): leggere un intero
 *  - nextDouble(): leggere un decimale
 *  - il problema del newline residuo dopo nextInt()
 *  - la soluzione: nextLine() di consumo
 *  - useLocale() per il separatore decimale
 */
public class ScannerBasic {
    public static void main(String[] args) {

        // ── 1. Creare uno Scanner ──────────────────────────────
        // Scanner legge dall'input standard (tastiera).
        // Serve l'import: java.util.Scanner
        Scanner scanner = new Scanner(System.in);

        // ── 2. nextLine() — leggere una stringa ────────────────
        // nextLine() legge tutta la riga fino a Invio.
        System.out.print("Come ti chiami? ");
        String nome = scanner.nextLine();
        System.out.println("Ciao, " + nome + "!");

        // ── 3. nextInt() — leggere un intero ───────────────────
        // nextInt() legge il prossimo token come int.
        // Se l'utente scrive qualcosa che non è un numero,
        // viene lanciata InputMismatchException.
        System.out.print("Quanti anni hai? ");
        int eta = scanner.nextInt();
        System.out.println("Tra 10 anni ne avrai " + (eta + 10));

        // ── 4. Il problema del newline ─────────────────────────
        // Dopo nextInt(), il '\n' resta nel buffer.
        // La nextLine() successiva lo trova e restituisce "".
        //
        // SBAGLIATO: commentare e provare per vedere il bug
        // System.out.print("Città: ");
        // String cittaErrata = scanner.nextLine(); // legge "" !
        // System.out.println("Città: [" + cittaErrata + "]");

        // CORRETTO: consumare il '\n' residuo
        scanner.nextLine(); // <-- consuma il '\n' dopo nextInt()

        System.out.print("Città: ");
        String citta = scanner.nextLine();
        System.out.println("Città: " + citta);

        // ── 5. nextDouble() e il Locale ────────────────────────
        // nextDouble() usa il separatore decimale del sistema.
        // In Italia: virgola (3,14). Negli USA: punto (3.14).
        // Per forzare il punto si usa useLocale(Locale.US).
        scanner.useLocale(Locale.US);

        System.out.print("Inserisci un decimale (usa il punto): ");
        if (scanner.hasNextDouble()) {
            double decimale = scanner.nextDouble();
            System.out.println("Hai inserito: " + decimale);
        } else {
            System.out.println("Input non valido (atteso un numero)");
            scanner.next(); // scarta il token errato
        }

        // ── 6. Riepilogo ──────────────────────────────────────
        // - nextLine()   → String (intera riga)
        // - nextInt()    → int
        // - nextDouble() → double
        // - next()       → String (singolo token, fino allo spazio)
        // - Dopo nextInt/nextDouble: aggiungere nextLine() di consumo
        //   se poi serve leggere una riga.
    }
}
