// Esercizio 2 · Null safe
// Obiettivo: controllare null prima di chiamare un metodo
public class NullSafe {

    static void stampaLunghezza(String s) {
        if (s == null) {
            System.out.println("La stringa è null");
        } else {
            System.out.println("Lunghezza di '" + s + "': " + s.length());
        }
    }

    public static void main(String[] args) {
        stampaLunghezza("Ciao");
        stampaLunghezza("");
        stampaLunghezza(null);
    }
}
