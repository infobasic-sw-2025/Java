public class Ex05NumeriPari {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            // Stampa di debug usata per trovare il bug, poi tolta:
            // System.out.println("DEBUG i = " + i + ", i % 2 = " + (i % 2));
            if (i % 2 == 0) {  // era i % 2 == 1, che seleziona i dispari
                System.out.println(i);
            }
        }
    }
}
