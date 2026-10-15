import java.util.Scanner;

public class GradeValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int voto;

        while (true) {
            System.out.print("Voto (1-10): ");

            // Prima si controlla il tipo, poi l'intervallo
            if (!scanner.hasNextInt()) {
                System.out.println("Inserisci un numero");
                scanner.next(); // scarta il token non valido
                continue;
            }

            voto = scanner.nextInt();

            if (voto >= 1 && voto <= 10) {
                break;
            }

            System.out.println("Il voto deve essere tra 1 e 10");
        }

        System.out.println("Voto registrato: " + voto);
    }
}
