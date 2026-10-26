public class Ex08Duplicates {
    public static void main(String[] args) {
        int[] numeri = {1, 2, 3, 4, 5, 6, 3, 8, 9, 1};

        System.out.print("Elementi duplicati:");
        for (int i = 0; i < numeri.length; i++) {
            // È già comparso prima? Allora è già stato stampato
            boolean giaVisto = false;
            for (int j = 0; j < i; j++) {
                if (numeri[j] == numeri[i]) {
                    giaVisto = true;
                }
            }

            // Compare anche dopo? Allora è un duplicato
            boolean ripetuto = false;
            for (int j = i + 1; j < numeri.length; j++) {
                if (numeri[j] == numeri[i]) {
                    ripetuto = true;
                }
            }

            if (!giaVisto && ripetuto) {
                System.out.print(" " + numeri[i]);
            }
        }
        System.out.println(); // → Elementi duplicati: 1 3
    }
}
