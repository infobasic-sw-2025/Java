public class Digits {
    public static void main(String[] args) {
        int numero = 708351;

        int resto = numero;
        int cifre = 0;
        int somma = 0;
        int massimo = 0;
        int minimo = 9;
        int rovesciato = 0;
        do {
            int cifra = resto % 10;
            cifre++;
            somma += cifra;
            if (cifra > massimo) {
                massimo = cifra;
            }
            if (cifra < minimo) {
                minimo = cifra;
            }
            rovesciato = rovesciato * 10 + cifra;
            resto /= 10;
        } while (resto > 0);

        System.out.println("Numero: " + numero);
        System.out.println("Cifre: " + cifre);
        System.out.println("Somma delle cifre: " + somma);
        System.out.println("Cifra massima: " + massimo + ", minima: " + minimo);
        System.out.println("Rovesciato: " + rovesciato);
    }
}
