public class Main {
    public static void main(String[] args) {
        // 1. Classe astratta
        // Forma f = new Forma("verde");   // errore: Forma is abstract; cannot be instantiated
        Forma[] forme = { new Cerchio("rosso", 5), new Rettangolo("blu", 4, 3) };
        for (Forma f : forme) {
            System.out.println(f.descrizione());
        }

        // 2. Interfaccia come tipo
        Volante[] flotta = { new Aereo(), new Anatra() };
        for (Volante v : flotta) {
            v.vola();
        }

        // 3. Implementazione multipla
        Anatra paperella = new Anatra();
        paperella.vola();
        paperella.nuota();
    }
}
