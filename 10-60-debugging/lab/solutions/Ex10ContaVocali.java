public class Ex10ContaVocali {
    public static void main(String[] args) {
        String testo = "Buongiorno Italia";
        int contatore = 0;

        // Era i <= testo.length(): charAt(17) su 17 caratteri lancia
        // StringIndexOutOfBoundsException (le posizioni vanno da 0 a 16)
        for (int i = 0; i < testo.length(); i++) {
            char c = testo.charAt(i);
            // Mancavano le vocali maiuscole: la I di Italia non veniva contata
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                    || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                contatore++;
            }
        }

        System.out.println("Vocali: " + contatore);
    }
}
