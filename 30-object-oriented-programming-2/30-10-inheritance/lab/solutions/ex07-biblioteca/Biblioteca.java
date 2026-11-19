public class Biblioteca {
    private Pubblicazione[] pubblicazioni;
    private int quante;

    public Biblioteca(int capienza) {
        pubblicazioni = new Pubblicazione[capienza];
        quante = 0;
    }

    public void aggiungi(Pubblicazione p) {
        if (quante == pubblicazioni.length) {
            System.out.println("Biblioteca piena");
            return;
        }
        pubblicazioni[quante] = p;
        quante++;
    }

    public Pubblicazione[] cercaPerAnno(int anno) {
        // Prima si contano, per creare un array della misura giusta
        int trovate = 0;
        for (int i = 0; i < quante; i++) {
            if (pubblicazioni[i].getAnno() == anno) {
                trovate++;
            }
        }

        Pubblicazione[] risultato = new Pubblicazione[trovate];
        int pos = 0;
        for (int i = 0; i < quante; i++) {
            if (pubblicazioni[i].getAnno() == anno) {
                risultato[pos] = pubblicazioni[i];
                pos++;
            }
        }
        return risultato;
    }

    public void stampaAll() {
        for (int i = 0; i < quante; i++) {
            System.out.println(pubblicazioni[i]);
        }
    }
}
