public class Ex04StackTrace {
    public static void main(String[] args) {
        int a = 50;
        int b = 0;
        if (b != 0) {
            int risultato = a / b;
            System.out.println("Risultato: " + risultato);
        } else {
            System.out.println("Impossibile dividere per zero");
        }
    }
}
