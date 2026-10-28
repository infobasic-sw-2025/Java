import java.util.Arrays;

// 10.70 · Array
// javac ArrayExamples.java && java ArrayExamples
public class ArrayExamples {
    public static void main(String[] args) {

        // ===== 1 · Creare, leggere, scrivere =====
        // Un array ha un tipo unico e una lunghezza fissa, decisa alla creazione.
        // Gli indici vanno da 0 a length - 1
        int[] voti = {7, 8, 6, 9, 5};
        int[] vuoto = new int[3];          // con new ogni cella ha il valore predefinito: 0, 0.0, false, null
        voti[2] = 10;                      // scrittura
        System.out.println(voti[0] + " " + voti[voti.length - 1] + " " + vuoto[1]); // → 7 5 0
        // voti[5]  → ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
        // length è una proprietà, senza parentesi (String invece ha il metodo length())

        // ===== 2 · Iterare =====
        // for classico quando serve l'indice (o si vuole modificare), for-each quando servono solo i valori
        for (int i = 0; i < voti.length; i++) {     // < e non <=, altrimenti si sfora
            System.out.print(i + ":" + voti[i] + " ");
        }
        System.out.println();                       // → 0:7 1:8 2:10 3:9 4:5

        // Accumulatore, contatore, massimo: tre schemi da sapere a memoria
        int somma = 0, sufficienti = 0, max = voti[0];  // max parte dal primo elemento, non da 0
        for (int v : voti) {                        // v è una copia: assegnarle un valore non cambia l'array
            somma += v;
            if (v >= 6) sufficienti++;
            if (v > max) max = v;
        }
        double media = (double) somma / voti.length; // cast: altrimenti divisione intera
        System.out.println("Somma " + somma + ", media " + media + ", sufficienti " + sufficienti + ", max " + max);
        // → Somma 39, media 7.8, sufficienti 4, max 10

        // println(voti) stampa tipo e hash ([I@...), non i valori: si usa Arrays.toString
        System.out.println(Arrays.toString(voti));  // → [7, 8, 10, 9, 5]

        // ===== 3 · Array e metodi =====
        // Il metodo riceve una copia del riferimento: lavora sullo stesso array
        raddoppia(voti);
        System.out.println(Arrays.toString(voti));  // → [14, 16, 20, 18, 10]
        System.out.println(Arrays.toString(sequenza(4))); // un metodo può anche restituire un array → [1, 2, 3, 4]

        // java.util.Arrays: sort modifica l'array, copyOf ne crea uno nuovo
        int[] numeri = {5, 3, 8, 1};
        int[] copia = Arrays.copyOf(numeri, 6);     // celle in più: valore predefinito
        Arrays.sort(numeri);
        System.out.println(Arrays.toString(numeri) + " " + Arrays.toString(copia)); // → [1, 3, 5, 8] [5, 3, 8, 1, 0, 0]

        // = copia il riferimento, == confronta i riferimenti (come per le stringhe)
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};                        // array diverso, stessi valori
        System.out.println((a == b) + " " + Arrays.equals(a, b)); // → false true
        int[] stesso = a;                           // stesso array, due nomi
        stesso[0] = 99;
        System.out.println(a[0]);                   // → 99: anche a è cambiato

        // ===== 4 · Array bidimensionali =====
        // Un array di array: il primo indice è la riga, il secondo la colonna
        int[][] matrice = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println(matrice.length + " righe, " + matrice[0].length + " colonne, [1][2] = " + matrice[1][2]);
        // → 2 righe, 3 colonne, [1][2] = 6
        for (int r = 0; r < matrice.length; r++) {
            for (int c = 0; c < matrice[r].length; c++) {
                System.out.print(matrice[r][c] + "  ");
            }
            System.out.println();
        }
        // → 1  2  3
        //   4  5  6
    }

    // Modifica l'array ricevuto: le modifiche si vedono anche nel main
    static void raddoppia(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
    }

    // Crea e restituisce un nuovo array {1, 2, ..., n}
    static int[] sequenza(int n) {
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = i + 1;
        }
        return seq;
    }
}
