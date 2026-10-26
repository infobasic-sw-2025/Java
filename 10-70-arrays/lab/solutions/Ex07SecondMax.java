public class Ex07SecondMax {
    public static void main(String[] args) {
        int[] numeri = {5, 1, 9, 2, 6, 8, 3, 7, 4, 10};

        // I primi due elementi fanno da punto di partenza
        int max;
        int secondoMax;
        if (numeri[0] > numeri[1]) {
            max = numeri[0];
            secondoMax = numeri[1];
        } else {
            max = numeri[1];
            secondoMax = numeri[0];
        }

        for (int i = 2; i < numeri.length; i++) {
            if (numeri[i] > max) {
                // nuovo massimo: il vecchio scala al secondo posto
                secondoMax = max;
                max = numeri[i];
            } else if (numeri[i] > secondoMax) {
                secondoMax = numeri[i];
            }
        }

        System.out.println("Il valore massimo è: " + max);                // → 10
        System.out.println("Il secondo valore massimo è: " + secondoMax); // → 9
    }
}
