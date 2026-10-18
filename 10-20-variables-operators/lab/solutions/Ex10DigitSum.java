public class Ex10DigitSum {
    public static void main(String[] args) {
        int numero = 4827;

        int unita = numero % 10;
        int decine = numero / 10 % 10;
        int centinaia = numero / 100 % 10;
        int migliaia = numero / 1000;

        System.out.println("Cifre: " + migliaia + " " + centinaia + " " + decine + " " + unita);
        System.out.println("Somma delle cifre: " + (migliaia + centinaia + decine + unita));
    }
}
