import java.util.Scanner;

public class Ex06CountOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeri = {1, 3, 5, 3, 7, 3, 9, 2, 4, 6};

        System.out.print("Numero da cercare: ");
        int cercato = scanner.nextInt();

        // Contatore: quante celle contengono il numero cercato
        int volte = 0;
        for (int n : numeri) {
            if (n == cercato) {
                volte++;
            }
        }

        System.out.println("Il numero " + cercato + " compare " + volte + " volte");
    }
}
