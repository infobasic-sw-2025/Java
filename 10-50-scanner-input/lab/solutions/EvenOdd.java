import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci un intero: ");
        int numero = scanner.nextInt();

        // Con i negativi il resto può valere -1: per questo si confronta con 0
        if (numero % 2 == 0) {
            System.out.println(numero + " è pari");
        } else {
            System.out.println(numero + " è dispari");
        }
    }
}
