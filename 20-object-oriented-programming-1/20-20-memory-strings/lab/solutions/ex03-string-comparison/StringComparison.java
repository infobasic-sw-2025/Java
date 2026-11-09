// Esercizio 3 · Confronto tra stringhe
// Obiettivo: == confronta i riferimenti, equals confronta il contenuto
public class StringComparison {
    public static void main(String[] args) {
        String a = "Java";
        String b = "Java";
        String c = new String("Java");

        // a e b: lo stesso letterale è un solo oggetto nel pool
        System.out.println("a == b:      " + (a == b));        // true
        System.out.println("a.equals(b): " + a.equals(b));     // true

        // a e c: new crea un oggetto nuovo, fuori dal pool; il contenuto è lo stesso
        System.out.println("a == c:      " + (a == c));        // false
        System.out.println("a.equals(c): " + a.equals(c));     // true

        // b e c: come a e c, perché b punta allo stesso oggetto di a
        System.out.println("b == c:      " + (b == c));        // false
        System.out.println("b.equals(c): " + b.equals(c));     // true
    }
}
