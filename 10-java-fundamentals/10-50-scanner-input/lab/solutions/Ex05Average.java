import java.util.Locale;
import java.util.Scanner;

public class Ex05Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // il separatore decimale è il punto

        System.out.print("Primo numero: ");
        double a = scanner.nextDouble();
        System.out.print("Secondo numero: ");
        double b = scanner.nextDouble();
        System.out.print("Terzo numero: ");
        double c = scanner.nextDouble();

        double media = (a + b + c) / 3;
        System.out.println("Media: " + media);
    }
}
