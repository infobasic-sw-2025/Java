import java.util.Scanner;

public class VowelCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Parola: ");
        String parola = scanner.nextLine();

        int vocali = 0;
        // length() dà il numero di caratteri, charAt(i) il carattere in posizione i
        for (int i = 0; i < parola.length(); i++) {
            char c = parola.charAt(i);
            switch (c) {
                case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> vocali++;
            }
        }

        System.out.println("Numero di vocali: " + vocali);
    }
}
