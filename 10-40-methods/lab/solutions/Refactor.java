public class Refactor {

    static boolean isPari(int n) {
        return n % 2 == 0;
    }

    // La logica ripetuta ora è scritta una volta sola
    static void stampaParita(int n) {
        if (isPari(n)) {
            System.out.println(n + " è pari");
        } else {
            System.out.println(n + " è dispari");
        }
    }

    public static void main(String[] args) {
        int a = 7, b = 3, c = 12;

        stampaParita(a);
        stampaParita(b);
        stampaParita(c);
    }
}
