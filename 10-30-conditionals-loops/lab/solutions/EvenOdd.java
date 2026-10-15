public class EvenOdd {
    public static void main(String[] args) {
        int numero = -7;

        if (numero > 0) {
            System.out.println(numero + " è positivo");
        } else if (numero < 0) {
            System.out.println(numero + " è negativo");
        } else {
            System.out.println(numero + " è zero");
        }

        // Con i negativi il resto può valere -1: per questo si confronta con 0
        if (numero % 2 == 0) {
            System.out.println(numero + " è pari");
        } else {
            System.out.println(numero + " è dispari");
        }
    }
}
