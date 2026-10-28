public class Ex08Somma {
    public static void main(String[] args) {
        int somma = 0;
        for (int i = 1; i <= 10; i++) {  // era i = 0; i < 10: sommava da 0 a 9
            somma += i;
        }
        System.out.println("Somma: " + somma);
    }
}
