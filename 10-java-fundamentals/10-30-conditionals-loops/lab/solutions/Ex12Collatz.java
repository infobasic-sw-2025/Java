public class Ex12Collatz {
    public static void main(String[] args) {
        int n = 27;

        int valore = n;
        int passi = 0;
        int massimo = n;
        while (valore != 1) {
            valore = valore % 2 == 0 ? valore / 2 : 3 * valore + 1;
            passi++;
            if (valore > massimo) {
                massimo = valore;
            }
        }
        System.out.println(n + " arriva a 1 in " + passi + " passi, valore massimo " + massimo);

        // Bonus: il numero tra 1 e 100 con più passi
        int record = 1;
        int passiRecord = 0;
        for (int i = 1; i <= 100; i++) {
            int v = i;
            int p = 0;
            while (v != 1) {
                v = v % 2 == 0 ? v / 2 : 3 * v + 1;
                p++;
            }
            if (p > passiRecord) {
                record = i;
                passiRecord = p;
            }
        }
        System.out.println("Tra 1 e 100 il più lungo è " + record + ", con " + passiRecord + " passi");
    }
}
