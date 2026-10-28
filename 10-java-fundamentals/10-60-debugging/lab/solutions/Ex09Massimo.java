import java.util.Scanner;

public class Ex09Massimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Numero " + i + ": ");
            int numero = scanner.nextInt();
            // Il primo numero diventa sempre il massimo provvisorio:
            // con max = 0 e tutti numeri negativi, max restava 0
            if (i == 1 || numero > max) {
                max = numero;
            }
        }

        System.out.println("Massimo: " + max);
    }
}
