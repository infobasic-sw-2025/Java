public class DistributoreDiBevande {
    private Prodotto[] prodotti;
    private int quanti;
    private double saldo;

    public DistributoreDiBevande(int n) {
        prodotti = new Prodotto[n];
        quanti = 0;
        saldo = 0;
    }

    public void caricaProdotto(Prodotto p) {
        if (quanti < prodotti.length) {
            prodotti[quanti] = p;
            quanti++;
        }
    }

    public void inserisciImporto(double importo) {
        saldo += importo;
    }

    public Prodotto scegliProdotto(String codice) {
        for (int i = 0; i < quanti; i++) {
            Prodotto p = prodotti[i];
            if (p.getCodice().equals(codice) && p.getPrezzo() <= saldo) {
                saldo -= p.getPrezzo();
                // Il prodotto esce: si chiude il buco spostando gli altri
                for (int j = i; j < quanti - 1; j++) {
                    prodotti[j] = prodotti[j + 1];
                }
                quanti--;
                prodotti[quanti] = null;
                return p;
            }
        }
        return null;
    }

    public double saldoAttuale() {
        return saldo;
    }

    public double getResto() {
        double resto = saldo;
        saldo = 0;
        return resto;
    }
}
