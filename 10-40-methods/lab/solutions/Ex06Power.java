public class Ex06Power {

    // long: le potenze crescono in fretta e superano presto il limite di int
    static long potenza(int base, int esponente) {
        long risultato = 1;
        for (int i = 0; i < esponente; i++) {
            risultato *= base;
        }
        return risultato;
    }

    public static void main(String[] args) {
        System.out.println("2^10 = " + potenza(2, 10));
        System.out.println("3^5 = " + potenza(3, 5));
    }
}
