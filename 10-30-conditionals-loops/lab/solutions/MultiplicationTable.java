public class MultiplicationTable {
    public static void main(String[] args) {
        int n = 7;

        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + n * i);
        }
        System.out.println();

        // Bonus: la tavola pitagorica, con un tab tra le colonne
        for (int riga = 1; riga <= 10; riga++) {
            for (int col = 1; col <= 10; col++) {
                System.out.print(riga * col + "\t");
            }
            System.out.println();
        }
    }
}
