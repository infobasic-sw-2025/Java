public class FixMethods {

    // Errore 1: "n * 2;" non è un'istruzione, manca il return
    static int doppio(int n) {
        return n * 2;
    }

    // Errore 3: se n <= 0 il metodo non restituiva nulla
    static boolean isPositivo(int n) {
        if (n > 0) {
            return true;
        }
        return false;
    }

    // Errore 2: un metodo void non può restituire un valore, quindi stampa
    static void saluta(String nome) {
        System.out.println("Ciao, " + nome);
    }

    public static void main(String[] args) {
        System.out.println(doppio(5));
        System.out.println(isPositivo(-3));
        saluta("Anna");
    }
}
