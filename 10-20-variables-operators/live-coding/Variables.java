// 1/4 · Variabili e tipi primitivi
public class Variables {
    public static void main(String[] args) {
        // Dichiarazione, inizializzazione, assegnazione
        int eta = 30;
        String nome = "Anna";
        System.out.println(nome + " ha " + eta + " anni");

        int a = 5;
        int b = a;
        a = 3;
        System.out.println("a = " + a + ", b = " + b);   // b resta 5: la copia è indipendente

        // Costanti e var
        final double IVA = 0.22;
        System.out.println("Con IVA: " + 100 * (1 + IVA));
        // IVA = 0.10;   // errore: cannot assign a value to final variable IVA

        var citta = "Torino";       // String, dedotto dal compilatore
        var abitanti = 850_000;     // int
        System.out.println(citta + ": " + abitanti);

        // Tipi primitivi: interi
        System.out.println("int max: " + Integer.MAX_VALUE);
        long abitantiTerra = 8_100_000_000L;   // senza L non compila
        System.out.println(abitantiTerra);

        // Decimali: double è la scelta predefinita
        double d = 1.0 / 3;
        float f = 1.0f / 3;
        System.out.println("double: " + d);
        System.out.println("float:  " + f);

        // char: un numero a 16 bit
        char iniziale = 'A';
        System.out.println(iniziale + 1);   // 66

        // boolean: solo true o false, mai 0 o 1
        boolean ok = true;
        System.out.println("ok: " + ok);
    }
}
