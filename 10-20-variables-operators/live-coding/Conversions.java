// 2/4 · Conversioni di tipo
public class Conversions {
    public static void main(String[] args) {
        // Allargamento: automatico
        int i = 100;
        double d = i;
        System.out.println("int -> double: " + d);

        // Allargamento con perdita di precisione
        int grande = 123456789;
        float f = grande;
        System.out.println("int -> float: " + f);   // le ultime cifre cambiano

        // Restringimento: serve il cast
        double prezzo = 9.99;
        // int intero = prezzo;            // errore: possible lossy conversion
        int troncato = (int) prezzo;       // 9, non arrotonda
        System.out.println("(int) 9.99 = " + troncato);
        System.out.println("(byte) 200 = " + (byte) 200);   // -56: overflow nel byte

        // Promozione numerica: byte + byte diventa int
        byte a = 10, b = 20;
        // byte c = a + b;   // errore: il risultato è un int
        int somma = a + b;
        System.out.println("a + b = " + somma);
    }
}
