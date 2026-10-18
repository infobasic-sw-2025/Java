import java.util.Scanner;

public class Ex10GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Math.random() dà un double in [0, 1): * 100 lo porta in [0, 100), + 1 in [1, 100]
        int segreto = (int) (Math.random() * 100) + 1;
        int tentativi = 0;
        int tentativo;

        do {
            System.out.print("Tentativo (1-100): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Inserisci un numero");
                scanner.next();
                tentativo = -1; // forza un altro giro
                continue;
            }

            tentativo = scanner.nextInt();
            tentativi++;

            if (tentativo > segreto) {
                System.out.println("Troppo alto");
            } else if (tentativo < segreto) {
                System.out.println("Troppo basso");
            }
        } while (tentativo != segreto);

        if (tentativi == 1) {
            System.out.println("Indovinato al primo tentativo!");
        } else {
            System.out.println("Indovinato in " + tentativi + " tentativi!");
        }
    }
}
