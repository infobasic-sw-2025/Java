import java.util.Arrays;

public class Ex09SplitEvenOdd {
    public static void main(String[] args) {
        int[] numeri = {1, 2, 3, 4, 5, 6, 8, 8, 7, 10};

        // Primo passaggio: contare, per conoscere le dimensioni
        int quantiPari = 0;
        for (int n : numeri) {
            if (n % 2 == 0) {
                quantiPari++;
            }
        }
        int[] pari = new int[quantiPari];
        int[] dispari = new int[numeri.length - quantiPari];

        // Secondo passaggio: riempire. Ogni array ha il suo indice di scrittura
        int iPari = 0;
        int iDispari = 0;
        for (int n : numeri) {
            if (n % 2 == 0) {
                pari[iPari] = n;
                iPari++;
            } else {
                dispari[iDispari] = n;
                iDispari++;
            }
        }

        System.out.println("Pari:    " + Arrays.toString(pari));    // → [2, 4, 6, 8, 8, 10]
        System.out.println("Dispari: " + Arrays.toString(dispari)); // → [1, 3, 5, 7]
    }
}
