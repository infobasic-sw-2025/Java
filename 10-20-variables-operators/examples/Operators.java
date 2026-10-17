// 3/4 · Operatori: aritmetici, concatenazione, relazionali e logici
public class Operators {
    public static void main(String[] args) {
        // Dividiamo 17 per 5: quoziente intero e resto
        int a = 17, b = 5;
        System.out.println("17 / 5 = " + (a / b));     // 3, divisione intera
        System.out.println("17 % 5 = " + (a % b));     // 2, resto

        // Calcoliamo la media di 7 e 2: perché dà 3.0 e come si ottiene 3.5
        double media = 7 / 2;              // 3.0, non 3.5
        double esatta = (double) 7 / 2;    // 3.5
        System.out.println(media + " vs " + esatta);

        // Incrementiamo un contatore: prima stampa poi incrementa, o viceversa?
        int n = 5;
        System.out.println(n++);   // stampa 5, poi n diventa 6
        System.out.println(++n);   // n diventa 7, poi stampa 7

        // Aggiorniamo un punteggio con le scorciatoie += e *=
        int punti = 10;
        punti += 5;
        punti *= 2;
        System.out.println("Punti: " + punti);   // 30

        // Aggiungiamo 1 al massimo intero: il valore riparte da negativo
        int max = Integer.MAX_VALUE;
        System.out.println(max + 1);    // -2147483648
        System.out.println(max + 1L);   // 2147483648, con L il calcolo è tra long

        // Calcoliamo una potenza, una radice e un dado casuale con Math
        System.out.println(Math.pow(2, 10));
        System.out.println(Math.sqrt(25));
        System.out.println((int) (Math.random() * 6) + 1);   // dado

        // Uniamo numeri e testo con +: il risultato cambia in base all'ordine
        System.out.println(1 + 2 + "Hello");      // 3Hello
        System.out.println("Hello" + 1 + 2);      // Hello12
        System.out.println("Hello" + (1 + 2));     // Hello3

        // Confrontiamo due stringhe con lo stesso testo: == e equals danno risultati diversi
        String s1 = "Java";
        String s2 = "Ja" + "va";       // stessa stringa nel pool
        String s3 = "Ja";
        s3 = s3 + "va";                // nuova stringa
        System.out.println(s1 == s2);          // true (pool)
        System.out.println(s1 == s3);          // false (riferimenti diversi)
        System.out.println(s1.equals(s3));     // true (stesso testo)

        // Verifichiamo se un'età rientra in un intervallo, e cosa cambia con le parentesi
        int eta = 20;
        boolean adulto = eta >= 18 && eta <= 65;
        System.out.println("Adulto: " + adulto);
        System.out.println(true || false && false);      // true: && prima di ||
        System.out.println((true || false) && false);    // false

        // Proteggiamo una divisione per zero: && salta il secondo controllo se il primo è false
        int zero = 0;
        boolean ok = zero != 0 && 10 / zero > 1;   // la divisione non avviene
        System.out.println("ok: " + ok);
    }
}
