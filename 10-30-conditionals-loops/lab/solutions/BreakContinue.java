public class BreakContinue {
    public static void main(String[] args) {
        // 1. Si ferma al 7
        for (int i = 1; i <= 10; i++) {
            if (i == 7) {
                break;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        // 2. Salta il 5
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        // 3. Il primo multiplo di 7 maggiore di 100
        int n = 101;
        while (true) {
            if (n % 7 == 0) {
                break;
            }
            n++;
        }
        System.out.println("Primo multiplo di 7 dopo 100: " + n);

        // 4. Da 1 a 30 senza i multipli di 3, fermandosi alla somma 100
        int somma = 0;
        for (int i = 1; i <= 30; i++) {
            if (i % 3 == 0) {
                continue;
            }
            if (somma + i > 100) {
                break;
            }
            somma += i;
            System.out.print(i + " ");
        }
        System.out.println("-> somma " + somma);
    }
}
