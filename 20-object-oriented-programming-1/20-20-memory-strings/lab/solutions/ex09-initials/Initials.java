// Esercizio 9 · Iniziali
// Obiettivo: split in parole, substring per la prima lettera, StringBuilder per il risultato
public class Initials {

    static String iniziali(String nomeCompleto) {
        String[] parti = nomeCompleto.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String parte : parti) {
            // Con due spazi di fila split produce una parte vuota: si salta
            if (!parte.isEmpty()) {
                sb.append(parte.substring(0, 1).toUpperCase());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] prove = {"Mario Rossi", "anna maria verdi", "Leonardo"};
        for (String p : prove) {
            System.out.println(p + " → " + iniziali(p));
        }
    }
}
