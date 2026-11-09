package servizio;

import modello.Prodotto;

public class Inventario {
    private Prodotto[] prodotti;
    private int contatore;

    public Inventario(int capienza) {
        prodotti = new Prodotto[capienza];
        contatore = 0;
    }

    public void aggiungi(Prodotto p) {
        if (contatore < prodotti.length) {
            prodotti[contatore] = p;
            contatore++;
        }
    }

    public void stampaListino() {
        System.out.println("=== Listino ===");
        for (int i = 0; i < contatore; i++) {
            System.out.println("  " + prodotti[i]);
        }
    }
}
