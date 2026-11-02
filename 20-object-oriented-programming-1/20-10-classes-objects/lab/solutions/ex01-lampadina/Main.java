class Main {

    public static void main(String[] args) {
        int maxTentativi = 4;

        // La classe lampadina non ha il costruttore di default, quindi deve passare i parametri
        // se metto "private Lampadina.."?
        Lampadina l1 = new Lampadina(maxTentativi);
        System.out.println(l1);

        for (int i = 0; i < maxTentativi + 1; i++) {
            System.out.println("Click numero: " + (i + 1));
            l1.aziona();
            System.out.println(l1);
            // System.out.println(l1.getStato());
        }

        // Due new = due oggetti distinti nello heap (A e B), con gli stessi valori:
        // maxAzionamenti=10, azionamenti=0, stato=SPENTA.
        // lampadina3 non ha new: copia il riferimento, quindi punta allo stesso oggetto B.
        //   lampadina1 -> A    lampadina2 -> B    lampadina3 -> B
        // == confronta i riferimenti (stesso oggetto?), equals() il nostro confronta i valori dei campi.
        Lampadina lampadina1 = new Lampadina(10);
        Lampadina lampadina2 = new Lampadina(10);
        Lampadina lampadina3 = lampadina2;

        // true: A e B hanno gli stessi valori nei tre campi confrontati da equals()
        System.out.println(lampadina1.equals(lampadina2));
        // true: stesso confronto a parti invertite, equals() è simmetrico
        System.out.println(lampadina2.equals(lampadina1));
        // false: A e B sono due oggetti diversi, i riferimenti sono diversi
        System.out.println(lampadina1 == lampadina2);

        // true: lampadina3 punta a B, che ha gli stessi valori di A
        System.out.println(lampadina1.equals(lampadina3));
        // false: A contro B, oggetti diversi
        System.out.println(lampadina1 == lampadina3);
        // false: la prima riga di equals() restituisce false se o == null
        // (se fosse lampadina1 a valere null, la chiamata darebbe NullPointerException)
        System.out.println(lampadina1.equals(null));

        // Si copia il riferimento: adesso lampadina2 punta ad A.
        // B non è perso, perché lampadina3 lo tiene ancora.
        //   lampadina1 -> A    lampadina2 -> A    lampadina3 -> B
        lampadina2 = lampadina1;

        // true: è lo stesso oggetto A, che ha sempre gli stessi valori di sé stesso
        System.out.println(lampadina1.equals(lampadina2));
        // true: le due variabili puntano allo stesso oggetto
        System.out.println(lampadina1 == lampadina2);

        // true: per lampadina3 non è cambiato nulla, A e B hanno ancora gli stessi valori
        System.out.println(lampadina1.equals(lampadina3));
        // false: A contro B, oggetti diversi
        System.out.println(lampadina1 == lampadina3);

        // true: B contro A, i valori sono uguali
        System.out.println(lampadina3.equals(lampadina2));
        // false: B contro A. Prima di lampadina2 = lampadina1 sarebbe stato true (B contro B)
        System.out.println(lampadina3 == lampadina2);

        // PARTE 2
        // I setter modificano l'oggetto a cui punta la variabile, non la variabile:
        // lampadina3 cambia B, lampadina2 cambia A. Ora A e B hanno entrambi maxAzionamenti=8.
        lampadina3.setMaxAzionamenti(8);
        lampadina2.setMaxAzionamenti(8);

        // true: A e B hanno di nuovo gli stessi valori (8, 0, SPENTA)
        System.out.println(lampadina3.equals(lampadina2));
        // false: restano due oggetti diversi
        System.out.println(lampadina3 == lampadina2);

        // lampadina2 punta ad A: maxAzionamenti di A diventa 9, B resta a 8
        lampadina2.setMaxAzionamenti(9);
        // false: maxAzionamenti diverso (8 in B, 9 in A)
        System.out.println(lampadina3.equals(lampadina2));
        // false: oggetti diversi
        System.out.println(lampadina3 == lampadina2);

        // 9: lampadina1 e lampadina2 puntano allo stesso oggetto A,
        // quindi la modifica fatta con lampadina2 si vede anche da lampadina1
        System.out.println(lampadina1.getMaxAzionamenti());

        // Una variabile esiste solo dentro il blocco { } in cui è dichiarata
        {
            Lampadina test = new Lampadina(10);
        }

        // Togliendo il commento non compila: error: cannot find symbol (test non esiste qui)
        // System.out.println(test);

    }

}