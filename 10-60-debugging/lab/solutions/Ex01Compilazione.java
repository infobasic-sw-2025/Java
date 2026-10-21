public class Ex01Compilazione {
    public static void main(String[] args) {
        int numero = 10;                          // era "10": una String non va in un int
        System.out.println("Numero: " + numero);  // mancava il ;
        String messaggio = "Ciao";                // mancava il ;
        System.out.println(messaggio);
    }
}
