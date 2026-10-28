public class Ex11DiagonalSum {
    public static void main(String[] args) {
        int[][] matrice = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        int n = matrice.length;

        System.out.println("Matrice:");
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.printf("%4d", matrice[r][c]);
            }
            System.out.println();
        }
        System.out.println();

        // Principale: riga e colonna coincidono, matrice[i][i]
        int principale = 0;
        String calcolo = "";
        for (int i = 0; i < n; i++) {
            principale += matrice[i][i];
            if (i > 0) {
                calcolo += " + ";
            }
            calcolo += matrice[i][i];
        }
        System.out.println("Diagonale principale: " + calcolo + " = " + principale);

        // Secondaria: la colonna scende da n - 1 a 0, matrice[i][n - 1 - i]
        int secondaria = 0;
        calcolo = "";
        for (int i = 0; i < n; i++) {
            secondaria += matrice[i][n - 1 - i];
            if (i > 0) {
                calcolo += " + ";
            }
            calcolo += matrice[i][n - 1 - i];
        }
        System.out.println("Diagonale secondaria: " + calcolo + " = " + secondaria);
    }
}
