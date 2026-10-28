public class Ex11Shapes {
    public static void main(String[] args) {
        int lato = 4;

        // 1. Rettangolo pieno, lato x (lato * 2)
        for (int r = 1; r <= lato; r++) {
            for (int c = 1; c <= lato * 2; c++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        // 2. Triangolo rettangolo
        for (int r = 1; r <= lato; r++) {
            for (int c = 1; c <= r; c++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        // 3. Quadrato vuoto: asterisco solo sul bordo
        for (int r = 1; r <= lato; r++) {
            for (int c = 1; c <= lato; c++) {
                boolean bordo = r == 1 || r == lato || c == 1 || c == lato;
                System.out.print(bordo ? "*" : " ");
            }
            System.out.println();
        }
        System.out.println();

        // 4. Piramide centrata: prima gli spazi, poi gli asterischi
        for (int r = 1; r <= lato; r++) {
            for (int s = 1; s <= lato - r; s++) {
                System.out.print(" ");
            }
            for (int c = 1; c <= 2 * r - 1; c++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
