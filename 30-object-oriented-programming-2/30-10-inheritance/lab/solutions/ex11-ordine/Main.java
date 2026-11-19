public class Main {
    public static void main(String[] args) {
        Ordine ordine = new Ordine(10);
        ordine.aggiungiArticolo(new ArticoloFisico("Libro Java", 30.0, 0.8));
        ordine.aggiungiArticolo(new ArticoloDigitale("E-book Java", 20.0));
        ordine.stampaRiepilogo();
    }
}
