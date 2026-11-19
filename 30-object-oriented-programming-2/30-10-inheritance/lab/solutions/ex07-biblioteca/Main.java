public class Main {
    public static void main(String[] args) {
        Biblioteca bib = new Biblioteca(100);
        bib.aggiungi(new Libro("Il nome della rosa", 1980, "Eco"));
        bib.aggiungi(new Rivista("Nature", 2024, 612));
        bib.stampaAll();

        System.out.println("Del 2024:");
        for (Pubblicazione p : bib.cercaPerAnno(2024)) {
            System.out.println(p);
        }
    }
}
