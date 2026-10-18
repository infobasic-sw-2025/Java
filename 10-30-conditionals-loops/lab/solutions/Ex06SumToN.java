public class Ex06SumToN {
    public static void main(String[] args) {
        int n = 100;

        // Con for
        int somma = 0;
        for (int i = 1; i <= n; i++) {
            somma += i;
        }
        System.out.println("Somma da 1 a " + n + " (for): " + somma);

        // Con while
        int sommaWhile = 0;
        int i = 1;
        while (i <= n) {
            sommaWhile += i;
            i++;
        }
        System.out.println("Somma da 1 a " + n + " (while): " + sommaWhile);

        // Verifica con la formula di Gauss
        System.out.println("Formula n * (n + 1) / 2: " + n * (n + 1) / 2);

        // Bonus: somma dei pari e dei dispari
        int pari = 0;
        int dispari = 0;
        for (int k = 1; k <= n; k++) {
            if (k % 2 == 0) {
                pari += k;
            } else {
                dispari += k;
            }
        }
        System.out.println("Pari: " + pari + ", dispari: " + dispari);
    }
}
