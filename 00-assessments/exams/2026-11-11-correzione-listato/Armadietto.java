class Armadietto {
    private static int creati = 0;
    private int numero;
    private int codice;
    private int tentativi;
    private boolean bloccato;
    private Studente proprietario;

    Armadietto(int numero, int codice) {
        this.numero = numero;
        this.codice = codice;
        creati++;
    }

    void assegna(Studente s) {
        if (!bloccato) {
            proprietario = s;
        }
    }

    boolean apri(int tentativo) {
        if (bloccato) {
            return false;
        }
        if (tentativo == codice) {
            tentativi = 0;
            return true;
        }
        tentativi++;
        if (tentativi == 3) {
            bloccato = true;
        }
        return false;
    }

    static int getCreati() {
        return creati;
    }

    boolean stessoProprietario(Armadietto altro) {
        if (altro == null || proprietario == null) {
            return false;
        }

        return proprietario == altro.proprietario;
    }
}