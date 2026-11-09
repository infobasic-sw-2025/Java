// Esercizio 12 · Cifrario di Cesare
// Obiettivo: indexOf per la posizione nell'alfabeto, % per ripartire dalla a dopo la z
public class CaesarCipher {

    static final String MINUSCOLE = "abcdefghijklmnopqrstuvwxyz";
    static final String MAIUSCOLE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    static String cifra(String testo, int spostamento) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testo.length(); i++) {
            char c = testo.charAt(i);
            int posMin = MINUSCOLE.indexOf(c);
            int posMai = MAIUSCOLE.indexOf(c);
            if (posMin != -1) {
                sb.append(MINUSCOLE.charAt((posMin + spostamento) % 26));
            } else if (posMai != -1) {
                sb.append(MAIUSCOLE.charAt((posMai + spostamento) % 26));
            } else {
                sb.append(c);       // spazi e punteggiatura restano uguali
            }
        }
        return sb.toString();
    }

    // Spostarsi indietro di n equivale a spostarsi avanti di 26 - n
    static String decifra(String testo, int spostamento) {
        return cifra(testo, 26 - spostamento % 26);
    }

    public static void main(String[] args) {
        String originale = "Ciao Mondo";
        int spostamento = 3;

        String cifrato = cifra(originale, spostamento);
        String decifrato = decifra(cifrato, spostamento);

        System.out.println("Originale: " + originale);
        System.out.println("Cifrato:   " + cifrato);
        System.out.println("Decifrato: " + decifrato);
    }
}
