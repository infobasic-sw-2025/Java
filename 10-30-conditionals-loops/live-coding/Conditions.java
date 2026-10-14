// 1/3 · Condizioni

// public     --> modificatore di visibilità
// class      --> stiamo definendo una classe
// Conditions --> nome della classe: il file deve chiamarsi come la classe pubblica (Conditions.java)

// Come si esegue una classe?
// Metodo 1) da terminale: javac Conditions.java e poi java Conditions
// Metodo 2) Run dall'IDE (IntelliJ o VS Code)
public class Conditions {

    // static   --> non serve un'istanza della classe per eseguirlo
    // void     --> il metodo non restituisce nulla (nessun return)
    // main     --> nome del metodo da cui parte il programma
    // String[] --> array di stringhe
    // args     --> arguments, gli argomenti passati da riga di comando
    public static void main(String[] args) {
        // Dall'età stabiliamo se una persona è maggiorenne, quasi maggiorenne o minorenne
        int eta = 18;   // un int è molto più grande di quanto serve per un'età, ma è il tipo intero più usato

        if (eta >= 18) {
            System.out.println("Sono maggiorenne");
        } else if (eta == 17 || eta == 16) {   // si può riscrivere? Esercizio :)
            System.out.println("Sono quasi maggiorenne");
        } else {
            System.out.println("Non sono maggiorenne");
        }

        // Dato un voto, stampiamo il giudizio corrispondente
        int voto = 8;
        if (voto >= 9) {
            System.out.println("Ottimo");
        } else if (voto >= 7) {
            System.out.println("Buono");
        } else if (voto >= 6) {
            System.out.println("Sufficiente");
        } else {
            System.out.println("Insufficiente");
        }

        // Verifichiamo se un'età rientra nella fascia biglietto intero
        eta = 20;
        if (eta >= 18 && eta <= 65) {
            System.out.println("Biglietto intero");
        }

        // Scegliamo tra "maggiorenne" e "minorenne" in una sola riga
        String fascia = eta >= 18 ? "maggiorenne" : "minorenne";
        System.out.println(fascia);

        // Due bug silenziosi: il ; dopo if e il confronto di stringhe con ==
        int x = 3;
        if (x > 10);
        {
            System.out.println("Stampato comunque");
        }

        String parte = "Ja";
        String linguaggio = parte + "va";
        System.out.println(linguaggio == "Java");        // false
        System.out.println(linguaggio.equals("Java"));   // true
    }
}
