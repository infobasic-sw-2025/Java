// Esercizio 5 · Vocali e consonanti
// Obiettivo: scorrere i caratteri con toCharArray e for-each, contare con indexOf
import java.util.Scanner;

public class VowelCount {
    public static void main(String[] args) {
        String vocali = "aeiou";
        String lettere = "abcdefghijklmnopqrstuvwxyz";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci una stringa: ");
        String s = scanner.nextLine().toLowerCase();    // maiuscole e minuscole uguali

        int numVocali = 0;
        int numConsonanti = 0;
        for (char c : s.toCharArray()) {
            // indexOf restituisce -1 se il carattere non c'è
            if (vocali.indexOf(c) != -1) {
                numVocali++;
            } else if (lettere.indexOf(c) != -1) {
                numConsonanti++;
            }
            // spazi, cifre e punteggiatura non contano
        }

        System.out.println("Vocali: " + numVocali);
        System.out.println("Consonanti: " + numConsonanti);

        scanner.close();
    }
}
