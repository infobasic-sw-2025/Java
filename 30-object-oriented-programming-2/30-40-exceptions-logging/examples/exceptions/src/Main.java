import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        // --- 1. try, catch e finally ---
        System.out.println("=== try e catch ===");
        String[] input = {"12", "abc", "0"};
        for (String s : input) {
            try {
                int n = Integer.parseInt(s);
                System.out.println("100 / " + n + " = " + (100 / n));
            } catch (NumberFormatException e) {
                System.out.println("Non è un numero: " + s);
            } catch (ArithmeticException e) {
                System.out.println("Divisione per zero");
            } finally {
                System.out.println("-- fine tentativo");
            }
        }

        // --- 2. L'eccezione risale fino al catch ---
        System.out.println("\n=== L'eccezione risale ===");
        a();
        System.out.println("Il main continua");

        // --- 3. throw: un parametro non valido ---
        System.out.println("\n=== throw ===");
        try {
            new Conto(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }

        // --- 4. Una checked: il file, con try-with-resources ---
        System.out.println("\n=== File ===");
        try {
            stampaFile("dati.txt");
            stampaFile("manca.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato: " + e.getMessage());
        }

        // --- 5. Un'eccezione nuova ---
        System.out.println("\n=== Eccezione nuova ===");
        Conto conto = new Conto(100);
        try {
            conto.preleva(30);
            conto.preleva(200);
        } catch (SaldoInsufficienteException e) {
            System.out.println("Errore: " + e.getMessage());
        }

        // --- 6. Il logging (su System.err) ---
        logger.info("Fine della dimostrazione");
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            logger.log(Level.SEVERE, "Errore nel calcolo", e);
        }
    }

    static void c() {
        int[] a = {1};
        a[5] = 0;
    }

    static void b() {
        c();
        System.out.println("fine di b");   // mai eseguita
    }

    static void a() {
        try {
            b();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catturata in a: " + e.getMessage());
        }
    }

    // FileNotFoundException è checked: il metodo la dichiara con throws
    static void stampaFile(String percorso) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(percorso))) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
    }
}
