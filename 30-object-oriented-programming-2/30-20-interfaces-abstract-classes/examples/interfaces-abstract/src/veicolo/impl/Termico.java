package veicolo.impl;

import veicolo.Motore;

public class Termico implements Motore {

    @Override
    public void accendi() {
        System.out.println("Motore termico acceso");
    }

    @Override
    public void spegni() {
        System.out.println("Motore termico spento");
    }
}
