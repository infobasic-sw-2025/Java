// Esercizio 11 · Frequenza delle lettere
// Obiettivo: un array di contatori, la posizione di ogni lettera si trova con indexOf
import java.util.Scanner;

public class CharFrequency {
    public static void main(String[] args) {
        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        int[] frequenze = new int[26];

        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci una stringa: ");
        String s = scanner.nextLine().toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            int pos = alfabeto.indexOf(s.charAt(i));
            if (pos != -1) {            // spazi e simboli non sono nell'alfabeto
                frequenze[pos]++;
            }
        }

        for (int i = 0; i < frequenze.length; i++) {
            if (frequenze[i] > 0) {
                System.out.println(alfabeto.charAt(i) + ": " + frequenze[i]);
            }
        }

        scanner.close();
    }
}
