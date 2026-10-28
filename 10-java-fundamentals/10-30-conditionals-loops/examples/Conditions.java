// 1/3 · Condizioni
public class Conditions {
    public static void main(String[] args) {
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
        int eta = 20;
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
