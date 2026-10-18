import java.util.Scanner;

public class Ex01Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // nextLine() legge l'intera riga, spazi compresi
        System.out.print("Come ti chiami? ");
        String nome = scanner.nextLine();

        System.out.println("Ciao, " + nome + "!");
    }
}
