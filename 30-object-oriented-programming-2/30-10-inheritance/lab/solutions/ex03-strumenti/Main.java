public class Main {
    public static void main(String[] args) {
        Strumento[] strumenti = { new Chitarra("Chitarra"), new Tamburo("Tamburo") };

        for (Strumento s : strumenti) {
            System.out.println(s.getNome() + ": " + s.suona());
        }
    }
}
