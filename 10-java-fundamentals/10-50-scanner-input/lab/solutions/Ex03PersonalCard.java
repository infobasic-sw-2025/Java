import java.util.Scanner;

public class Ex03PersonalCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Età: ");
        int eta = scanner.nextInt();
        scanner.nextLine(); // consuma il '\n' lasciato da nextInt()

        System.out.print("Città: ");
        String citta = scanner.nextLine();

        System.out.println(nome + ", " + eta + " anni, vive a " + citta);
    }
}
