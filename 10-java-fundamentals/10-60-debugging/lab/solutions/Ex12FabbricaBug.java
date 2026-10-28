public class Ex12FabbricaBug {
    public static void main(String[] args) {
        int n = 5;

        int somma = 0;
        for (int i = 1; i <= n; i++) {
            somma += i;
        }

        double media = (double) somma / n;

        System.out.println("Somma: " + somma);
        System.out.println("Media: " + media);

        // Esempi di bug da introdurre, uno alla volta:
        // - compilazione: togliere il ; dopo somma += i
        //   -> Ex12FabbricaBug.java:7: error: ';' expected
        // - runtime: int n = 0; e media = somma / n (divisione intera)
        //   -> java.lang.ArithmeticException: / by zero
        // - logico: for (int i = 1; i < n; i++)
        //   -> Somma: 10, Media: 2.0
    }
}
