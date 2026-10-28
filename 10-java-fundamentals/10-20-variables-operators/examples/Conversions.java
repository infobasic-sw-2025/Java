// 2/4 · Conversioni di tipo
public class Conversions {
    public static void main(String[] args) {
        // Passiamo un intero in un double: la conversione è automatica
        int i = 100;
        double d = i;
        System.out.println("int -> double: " + d);

        // Mettiamo un numero a 9 cifre in un float e vediamo che le ultime cifre cambiano
        int grande = 123456789;
        float f = grande;
        System.out.println("int -> float: " + f);   // le ultime cifre cambiano

        // Tronchiamo un prezzo decimale a intero con un cast, e vediamo cosa succede con byte
        double prezzo = 9.99;
        // int intero = prezzo;            // errore: possible lossy conversion
        int troncato = (int) prezzo;       // 9, non arrotonda
        System.out.println("(int) 9.99 = " + troncato);
        System.out.println("(byte) 200 = " + (byte) 200);   // -56: overflow nel byte

        // Sommiamo due byte e proviamo a salvare il risultato in un byte
        byte a = 10, b = 20;
        // byte c = a + b;   // errore: il risultato è un int
        int somma = a + b;
        System.out.println("a + b = " + somma);
    }
}
