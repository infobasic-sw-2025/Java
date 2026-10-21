import java.util.Scanner;

public class Ex11MediaInterattiva {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int somma = 0;
        int conteggio = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Inserisci il voto " + i + ": ");  // 1. mancava il ; (compilazione)
            int voto = scanner.nextInt();
            somma += voto;
            conteggio++;  // 3. mancava: conteggio restava 0, divisione per zero (runtime)
        }

        double media = (double) somma / conteggio;  // 4. era somma / conteggio: divisione intera (logico)
        System.out.println("Media: " + media);

        if (media >= 18) {  // 2. era media = 18: assegnamento, non condizione (compilazione)
            System.out.println("Sufficiente");
        } else {
            System.out.println("Insufficiente");
        }
    }
}
