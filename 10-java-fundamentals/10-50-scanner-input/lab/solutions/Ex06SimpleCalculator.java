import java.util.Locale;
import java.util.Scanner;

public class Ex06SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("Primo numero: ");
        double a = scanner.nextDouble();
        System.out.print("Secondo numero: ");
        double b = scanner.nextDouble();
        scanner.nextLine(); // consuma il '\n' lasciato da nextDouble()

        System.out.print("Operazione (+ - * /): ");
        String operazione = scanner.nextLine();

        switch (operazione) {
            case "+" -> System.out.println("Risultato: " + (a + b));
            case "-" -> System.out.println("Risultato: " + (a - b));
            case "*" -> System.out.println("Risultato: " + (a * b));
            case "/" -> {
                // Con i double la divisione per zero non dà errore ma Infinity o NaN
                if (b == 0) {
                    System.out.println("Attenzione: divisione per zero");
                } else {
                    System.out.println("Risultato: " + (a / b));
                }
            }
            default -> System.out.println("Operazione non valida: " + operazione);
        }
    }
}
