import forma_geometrica.Cerchio;
import forma_geometrica.Forma;
import forma_geometrica.Rettangolo;
import veicolo.Motore;
import veicolo.impl.Elettrico;
import veicolo.impl.Termico;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Main{

    public static void main(String[] args){

        Forma f1 = new Cerchio("Blu", 5.8);
        Forma f2 = new Rettangolo("Rosso", 20, 1.0 );

        Forma[] formeGeometriche = new Forma[2];
        formeGeometriche[0] = f1;
        formeGeometriche[1] = f2;

        for(Forma fg : formeGeometriche){

            fg = null;

            //System.out.println(fg.descrizione());
            System.out.println(fg);
            //fg.setColore(null);

            formeGeometriche[0] = fg;
            fg = new Cerchio("Blu", 5.8);
            System.out.println(fg);
            formeGeometriche[0] = fg;
        }

        // System.out.println(fg);
        System.out.println(formeGeometriche[0].descrizione());

        /* - - - - - - - - - - - - - - - - - */
        Motore mE = new Elettrico();
        Motore mT = new Termico();

        mE.accendi();
        mT.accendi();

        List motori = new ArrayList();
        motori = new LinkedList();
    }
}