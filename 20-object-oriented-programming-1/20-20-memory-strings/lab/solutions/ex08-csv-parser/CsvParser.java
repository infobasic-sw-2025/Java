// Esercizio 8 · Parser CSV
// Obiettivo: split, conversioni con parseInt e parseDouble, output con printf
public class CsvParser {
    public static void main(String[] args) {
        String riga = "Mario Rossi,25,Roma,8.5";
        String[] campi = riga.split(",");

        String nome = campi[0];
        int eta = Integer.parseInt(campi[1]);
        String citta = campi[2];
        double media = Double.parseDouble(campi[3]);

        System.out.printf("Nome:  %s%n", nome);
        System.out.printf("Età:   %d%n", eta);
        System.out.printf("Città: %s%n", citta);
        System.out.printf("Media: %.2f%n", media);
    }
}
