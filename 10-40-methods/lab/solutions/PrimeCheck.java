public class PrimeCheck {

    // Appena trova un divisore restituisce false: non serve break
    static boolean isPrimo(int n) {
        if (n < 2) {
            return false;
        }
        for (int d = 2; d * d <= n; d++) {
            if (n % d == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int n = 2; n <= 50; n++) {
            if (isPrimo(n)) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
    }
}
