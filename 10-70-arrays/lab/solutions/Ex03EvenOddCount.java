public class Ex03EvenOddCount {
    public static void main(String[] args) {
        int[] numeri = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Due contatori: ogni numero ne incrementa esattamente uno
        int pari = 0;
        int dispari = 0;
        for (int n : numeri) {
            if (n % 2 == 0) {
                pari++;
            } else {
                dispari++;
            }
        }

        System.out.println("Numeri pari: " + pari);       // → 5
        System.out.println("Numeri dispari: " + dispari); // → 5
    }
}
