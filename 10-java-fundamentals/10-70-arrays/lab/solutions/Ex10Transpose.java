public class Ex10Transpose {
    public static void main(String[] args) {
        int[][] matrice = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        int righe = matrice.length;       // 3
        int colonne = matrice[0].length;  // 4

        // La trasposta ha righe e colonne scambiate: 4x3
        int[][] trasposta = new int[colonne][righe];
        for (int r = 0; r < righe; r++) {
            for (int c = 0; c < colonne; c++) {
                trasposta[c][r] = matrice[r][c];
            }
        }

        System.out.println("Matrice originale (" + righe + "x" + colonne + "):");
        for (int r = 0; r < righe; r++) {
            for (int c = 0; c < colonne; c++) {
                System.out.printf("%4d", matrice[r][c]); // 4 caratteri, allineato a destra
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Matrice trasposta (" + colonne + "x" + righe + "):");
        for (int r = 0; r < trasposta.length; r++) {
            for (int c = 0; c < trasposta[r].length; c++) {
                System.out.printf("%4d", trasposta[r][c]);
            }
            System.out.println();
        }
    }
}
