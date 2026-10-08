// 1/4 · Variabili e tipi primitivi
public class Variables {
    public static void main(String[] args) {
        // Salviamo il nome e l'età di una persona, poi vediamo che copiare una variabile crea una copia indipendente
        int eta = 30;
        String nome = "Anna";
        System.out.println(nome + " ha " + eta + " anni");

        int a = 5;
        int b = a;
        a = 3;
        System.out.println("a = " + a + ", b = " + b);   // b resta 5: la copia è indipendente

        // Calcoliamo un prezzo con IVA fissa, poi descriviamo una città lasciando che il compilatore deduca il tipo
        final double IVA = 0.22;
        System.out.println("Con IVA: " + 100 * (1 + IVA));
        // IVA = 0.10;   // errore: cannot assign a value to final variable IVA

        var citta = "Torino";       // String, dedotto dal compilatore
        var abitanti = 850_000;     // int
        System.out.println(citta + ": " + abitanti);

        // Stampiamo il valore massimo di un int e salviamo la popolazione mondiale in un long
        System.out.println("int max: " + Integer.MAX_VALUE);
        long abitantiTerra = 8_100_000_000L;   // senza L non compila
        System.out.println(abitantiTerra);

        // Dividiamo 1 per 3 con double e con float per vedere quante cifre conservano
        double d = 1.0 / 3;
        float f = 1.0f / 3;
        System.out.println("double: " + d);
        System.out.println("float:  " + f);

        // Sommiamo 1 alla lettera 'A' per vedere che char è un numero; proviamo un boolean
        char iniziale = 'A';
        System.out.println(iniziale + 1);   // 66

        boolean ok = true;
        System.out.println("ok: " + ok);
    }
}
