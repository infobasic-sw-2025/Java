// Metodi void e con ritorno
public class Methods {
    public static void main(String[] args) {
        // Stampiamo un separatore tre volte senza ripetere il codice
        stampaLinea();
        System.out.println("Capitolo 1");
        stampaLinea();
        System.out.println("Capitolo 2");
        stampaLinea();

        // Salutiamo persone diverse con lo stesso metodo
        saluta("Alice");
        saluta("Bob");

        // Calcoliamo l'area di un cerchio e usiamo il valore restituito
        double area = areaCerchio(5);
        System.out.println("Area: " + area);
        System.out.println("Area doppia: " + areaCerchio(5) * 2);

        // Verifichiamo se un numero è pari
        System.out.println("4 pari? " + isPari(4));
        System.out.println("7 pari? " + isPari(7));

        // Il passaggio per valore: il metodo non modifica la variabile originale
        int n = 10;
        raddoppia(n);
        System.out.println("n dopo raddoppia: " + n);   // ancora 10
    }

    // Stampa una riga di trattini
    static void stampaLinea() {
        System.out.println("--------------------");
    }

    // Stampa un saluto con il nome ricevuto
    static void saluta(String nome) {
        System.out.println("Ciao, " + nome + "!");
    }

    // Calcola l'area di un cerchio dato il raggio
    static double areaCerchio(double raggio) {
        return Math.PI * raggio * raggio;
    }

    // Restituisce true se il numero è pari
    static boolean isPari(int n) {
        return n % 2 == 0;
    }

    // Prova a raddoppiare il parametro: non ha effetto sulla variabile del chiamante
    static void raddoppia(int x) {
        x = x * 2;
        System.out.println("Dentro raddoppia: " + x);
    }
}
