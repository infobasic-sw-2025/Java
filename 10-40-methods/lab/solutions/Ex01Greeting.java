public class Ex01Greeting {

    // void: il metodo stampa e non restituisce nulla
    static void saluta(String nome) {
        System.out.println("Ciao, " + nome + "!");
    }

    public static void main(String[] args) {
        saluta("Alice");
        saluta("Bob");
        saluta("Carlo");
    }
}
