class Main{

    public static void main(String[] args){

        /*
        le {} creano uno scope a parte di visibilità, quindi se dichiaro due volte s1 ho errore e
        se dichiaro s1 dentro le parentesi ma lo uso anche fuori, ho errore
        {
            Studente s1 = new Studente("Davide", 39, 0.00, true);
        }
        */

        // s1 oggetto di tipo Studente
        Studente s1 = new Studente("S1", 39, 0.00, true);

        // Non valido perchè abbiamo solo due costruttori di Studente,
        // uno che non prende parametri e l'altro che li prende tutti
        //Studente s2 = new Studente("Anna");
        // Studente s2 = new studente(..); studente con s minuscola è errore (case-sensitive)


        // Cosa posso fare con s1?
        System.out.println(s1); // stampare
        s1.setNome("Test S1");
        System.out.println(s1); // stampare
        // System.out.println(s1.setNome("S1")); --> Errore: setNome restituisce void, non c'è niente da stampare
        System.out.println(s1.getNome());

        Studente s2 = new Studente("S2", 99, 30.0, true);
        System.out.println(s1 == s1); // true
        System.out.println(s1 == s2); // false


        //  s1.metodoPrivato(); errore: il metodo è private
        boolean isAttivo = s1.attivo; // non un errore per Java ma va contro i pattern OOP
        // String nome = s1.nome; errore



    }
}
