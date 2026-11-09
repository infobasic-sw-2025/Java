// Esercizio 4 · Analisi di una frase
// Obiettivo: length, split, toUpperCase, toLowerCase e StringBuilder.reverse su un input
import java.util.Scanner;

public class SentenceAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci una frase: ");
        String frase = scanner.nextLine();

        System.out.println("Caratteri: " + frase.length());           // spazi compresi
        System.out.println("Parole: " + frase.split(" ").length);
        System.out.println("Maiuscolo: " + frase.toUpperCase());
        System.out.println("Minuscolo: " + frase.toLowerCase());
        System.out.println("Al contrario: " + new StringBuilder(frase).reverse().toString());

        scanner.close();
    }
}
