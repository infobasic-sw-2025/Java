// Esercizio 10 · StringBuilder: una tabella
// Obiettivo: costruire un testo su più righe con StringBuilder e String.format
public class StudentTable {
    public static void main(String[] args) {
        String[] nomi = {"Alice", "Bob", "Carol"};
        int[] eta = {20, 22, 21};
        double[] medie = {8.5, 7.3, 9.0};

        String separatore = "+-----------------+-----+-------+";
        StringBuilder sb = new StringBuilder();

        sb.append(separatore).append("\n");
        sb.append(String.format("| %-15s | %3s | %5s |%n", "Nome", "Età", "Media"));
        sb.append(separatore).append("\n");
        for (int i = 0; i < nomi.length; i++) {
            sb.append(String.format("| %-15s | %3d | %5.1f |%n", nomi[i], eta[i], medie[i]));
        }
        sb.append(separatore);

        System.out.println(sb.toString());
    }
}
