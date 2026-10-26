public class Ex01ArraySum {
    public static void main(String[] args) {
        int[] numeri = {2, 4, 6, 8, 10};

        // Accumulatore: parte da 0 e somma un elemento alla volta
        int somma = 0;
        for (int n : numeri) {
            somma += n;
        }

        System.out.println("La somma degli elementi è: " + somma); // → 30
    }
}
