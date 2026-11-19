package veicolo.impl;

import veicolo.Motore;

public class Elettrico implements Motore {

    @Override
    public void accendi() {
        System.out.println("Motore elettrico avviato");
    }

    @Override
    public void spegni() {
        System.out.println("Motore elettrico spento");
    }
}
