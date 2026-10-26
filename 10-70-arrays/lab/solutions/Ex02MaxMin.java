public class Ex02MaxMin {
    public static void main(String[] args) {
        int[] numeri = {8, 6, 4, 2, 10, 12, 14, 16};

        // Si parte dal primo elemento, non da 0
        int max = numeri[0];
        int min = numeri[0];
        for (int i = 1; i < numeri.length; i++) {
            if (numeri[i] > max) {
                max = numeri[i];
            }
            if (numeri[i] < min) {
                min = numeri[i];
            }
        }

        System.out.println("Il valore massimo è: " + max); // → 16
        System.out.println("Il valore minimo è: " + min);  // → 2
    }
}
