import java.util.Scanner;

public class Ex11OperationsMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scelta;

        do {
            System.out.println();
            System.out.println("1. Saluta");
            System.out.println("2. Somma");
            System.out.println("3. Fattoriale");
            System.out.println("0. Esci");
            scelta = leggiIntero(scanner, "Scelta: ");

            switch (scelta) {
                case 1 -> {
                    System.out.print("Come ti chiami? ");
                    String nome = scanner.nextLine();
                    System.out.println("Ciao, " + nome + "!");
                }
                case 2 -> {
                    int a = leggiIntero(scanner, "Primo numero: ");
                    int b = leggiIntero(scanner, "Secondo numero: ");
                    System.out.println("Somma: " + (a + b));
                }
                case 3 -> {
                    int n = leggiIntero(scanner, "Numero (0-20): ");
                    // Oltre 20! il risultato non sta più in un long
                    if (n < 0 || n > 20) {
                        System.out.println("Il numero deve essere tra 0 e 20");
                    } else {
                        long fattoriale = 1;
                        for (int i = 2; i <= n; i++) {
                            fattoriale *= i;
                        }
                        System.out.println(n + "! = " + fattoriale);
                    }
                }
                case 0 -> System.out.println("Arrivederci!");
                default -> System.out.println("Scelta non valida");
            }
        } while (scelta != 0);
    }

    // Chiede un intero finché l'input non è valido, poi consuma il resto della riga
    static int leggiIntero(Scanner scanner, String messaggio) {
        System.out.print(messaggio);
        while (!scanner.hasNextInt()) {
            System.out.println("Inserisci un numero");
            scanner.nextLine(); // scarta l'intera riga non valida
            System.out.print(messaggio);
        }
        int valore = scanner.nextInt();
        scanner.nextLine(); // consuma il '\n' lasciato da nextInt()
        return valore;
    }
}
