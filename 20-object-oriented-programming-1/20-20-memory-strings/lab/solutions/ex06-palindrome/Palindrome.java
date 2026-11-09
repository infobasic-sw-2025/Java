// Esercizio 6 · Palindromo
// Obiettivo: pulire la stringa, invertirla con StringBuilder e confrontarla con equals
public class Palindrome {

    static boolean isPalindromo(String s) {
        String pulita = s.toLowerCase().replace(" ", "");
        String inversa = new StringBuilder(pulita).reverse().toString();
        return pulita.equals(inversa);
    }

    public static void main(String[] args) {
        String[] prove = {"anna", "Java", "i topi non avevano nipoti"};
        for (String p : prove) {
            System.out.println("'" + p + "' è palindromo? " + isPalindromo(p));
        }
    }
}
