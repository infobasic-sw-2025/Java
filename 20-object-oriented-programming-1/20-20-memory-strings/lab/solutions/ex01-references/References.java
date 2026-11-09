// Esercizio 1 · Riferimenti e copie
// Obiettivo: assegnare un array copia il riferimento, Arrays.copyOf crea un array nuovo
import java.util.Arrays;

public class References {
    public static void main(String[] args) {
        int[] originale = {10, 20, 30, 40, 50};
        int[] b = originale;        // stesso array, due nomi

        b[0] = 99;
        System.out.println("Dopo la modifica tramite b: " + Arrays.toString(originale));

        int[] copia = Arrays.copyOf(originale, originale.length);   // array nuovo nello heap
        copia[0] = 0;
        System.out.println("Dopo la modifica della copia: " + Arrays.toString(originale));
        System.out.println("Copia modificata: " + Arrays.toString(copia));
    }
}
