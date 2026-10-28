public class Ex09Factorial {

    static long fattoriale(int n) {
        long risultato = 1;
        for (int i = 2; i <= n; i++) {
            risultato *= i;
        }
        return risultato;
    }

    public static void main(String[] args) {
        // Oltre 20! il risultato supera Long.MAX_VALUE: overflow senza errori
        for (int n = 1; n <= 25; n++) {
            System.out.println(n + "! = " + fattoriale(n));
        }
    }
}
