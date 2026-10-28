import java.util.Arrays;

public class Ex05ReverseArray {
    public static void main(String[] args) {
        int[] numeri = {1, 2, 3, 4, 5, 6};

        System.out.println("Array originale: " + Arrays.toString(numeri));

        // Si scambia il primo con l'ultimo, il secondo con il penultimo...
        // Basta arrivare a metà: oltre si rifarebbero gli scambi al contrario
        for (int i = 0; i < numeri.length / 2; i++) {
            int j = numeri.length - 1 - i;
            int temp = numeri[i];
            numeri[i] = numeri[j];
            numeri[j] = temp;
        }

        System.out.println("Array invertito: " + Arrays.toString(numeri)); // → [6, 5, 4, 3, 2, 1]
    }
}
