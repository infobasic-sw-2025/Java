public class Zoo {
    private Animale[] animali;
    private int quanti;

    public Zoo(int capienza) {
        animali = new Animale[capienza];
        quanti = 0;
    }

    public void aggiungiAnimale(Animale a) {
        if (quanti < animali.length) {
            animali[quanti] = a;
            quanti++;
        }
    }

    public void stampaAnimali() {
        for (int i = 0; i < quanti; i++) {
            System.out.println(animali[i] + " fa " + animali[i].verso());
        }
    }

    public int contaPerSpecie(String specie) {
        int conta = 0;
        for (int i = 0; i < quanti; i++) {
            if (animali[i].getSpecie().equals(specie)) {
                conta++;
            }
        }
        return conta;
    }

    public void concerto() {
        for (int i = 0; i < quanti; i++) {
            System.out.println(animali[i].getNome() + ": " + animali[i].verso());
        }
    }
}
