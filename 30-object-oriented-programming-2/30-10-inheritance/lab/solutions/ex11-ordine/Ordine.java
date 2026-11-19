public class Ordine {
    private Articolo[] articoli;
    private int quanti;

    public Ordine(int capienza) {
        articoli = new Articolo[capienza];
        quanti = 0;
    }

    public void aggiungiArticolo(Articolo a) {
        if (quanti < articoli.length) {
            articoli[quanti] = a;
            quanti++;
        }
    }

    public double calcolaTotale() {
        double totale = 0;
        for (int i = 0; i < quanti; i++) {
            totale += articoli[i].costoFinale();
        }
        return totale;
    }

    public void stampaRiepilogo() {
        for (int i = 0; i < quanti; i++) {
            System.out.println(articoli[i].getNome() + ": " + articoli[i].costoFinale() + " EUR");
        }
        System.out.println("Totale: " + calcolaTotale() + " EUR");
    }
}
