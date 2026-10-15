public class PrimeNumber {
    public static void main(String[] args) {
        int numero = 97;

        boolean primo = numero >= 2;
        for (int d = 2; d * d <= numero; d++) {
            if (numero % d == 0) {
                primo = false;
                break;
            }
        }
        System.out.println(numero + (primo ? " è primo" : " non è primo"));

        // Bonus: i primi fino a 50, con due cicli annidati
        for (int n = 2; n <= 50; n++) {
            boolean ePrimo = true;
            for (int d = 2; d * d <= n; d++) {
                if (n % d == 0) {
                    ePrimo = false;
                    break;
                }
            }
            if (ePrimo) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
    }
}
