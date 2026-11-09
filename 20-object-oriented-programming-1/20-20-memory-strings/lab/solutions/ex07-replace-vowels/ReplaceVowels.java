// Esercizio 7 · Sostituisci le vocali
// Obiettivo: costruire una stringa nuova carattere per carattere con StringBuilder
public class ReplaceVowels {

    static String sostituisciVocali(String s, char sostituto) {
        String vocali = "aeiouAEIOU";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (vocali.indexOf(c) != -1) {
                sb.append(sostituto);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String originale = "Programmazione";
        String risultato = sostituisciVocali(originale, '*');
        System.out.println("Originale: " + originale);
        System.out.println("Risultato: " + risultato);
    }
}
