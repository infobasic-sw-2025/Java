import java.util.Objects;

public class Lampadina {

    // Da specifiche, la lampadina può essere in uno stato ACCESA, SPENTA o ROTTA
    private static final String ACCESA = "ACCESA"; // TODO: Passare ad una Enumeration
    private static final String SPENTA = "SPENTA";
    private static final String ROTTA = "ROTTA"; // Var di classe

    // int potrebbe essere troppo grande ma per ora
    // va bene così
    private int maxAzionamenti;
    private int azionamenti;
    private String stato; // Var di istanza

    public Lampadina(int maxAzionamenti) {
        this.maxAzionamenti = maxAzionamenti; // ricordate il this e cosa significa
        this.azionamenti = 0; // this è superfluo perché non ho nessuna var ambigua
        this.stato = SPENTA;
    }

    // Tecnicamente potrei avere aziona boolean che torna se la lampadina è rotta o spenta
    // public StatoLampadina aziona(){...} dove StatoLampadina è una Enum
    public void aziona(){

        // Se la lampadina è rotta, rimane rotta
        if (stato.equals(ROTTA)){

            // Uso System.out come log, idealmente dovrei usare un framework di logging
            System.out.println("Lampadina già in stato: " + ROTTA);
            return;
        }

        // Se arrivo qui, la lampadina non è rotta e aumento di 1
        // il contatore
        azionamenti++;

        // L'azionamento che raggiunge il massimo rompe la lampadina
        // Mettere >= non è tecnicamente errore, ma è possibile andare oltre il maxAzionamenti?
        if(azionamenti == maxAzionamenti){

            System.out.println("Nuovo stato lampadina: " + ROTTA);
            stato = ROTTA;
        } else if (stato.equals(ACCESA)){

            System.out.println("Nuovo stato lampadina: " + SPENTA);
            stato = SPENTA;
        } else {

            System.out.println("Nuovo stato lampadina: " + ACCESA);
            stato = ACCESA;
        }
    }

    // getter
    public int getMaxAzionamenti() {
        return maxAzionamenti;
    }

    // setter
    public void setMaxAzionamenti(int maxAzionamenti) {
        this.maxAzionamenti = maxAzionamenti;
    }

    // Es: lo stato voglio solo leggerlo e non settarlo da fuori la classe Lampadina
    // quindi non prevedo il setter
    public String getStato() {
        return stato;
    }

    public int getAzionamenti() {
        return azionamenti;
    }

    public void setAzionamenti(int azionamenti) {
        this.azionamenti = azionamenti;
    }

    // equals() dice quando due oggetti diversi (indirizzi di memoria differenti) sono
    // equivalenti, cioè hanno gli stessi valori. Se sono lo stesso oggetto lo dice ==.
    // hashCode() restituisce un numero calcolato dai campi: lo usano HashMap e HashSet.
    // Regola: due oggetti uguali per equals() devono avere lo stesso hashCode(),
    // per questo i due metodi usano gli stessi campi
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;

        Lampadina lampadina = (Lampadina) o;

        // Qui è "didattico", dovrei fare l'equals solo su attributi
        // distintivi (code, id, matricola..)
        return maxAzionamenti == lampadina.maxAzionamenti
                && azionamenti == lampadina.azionamenti
                && Objects.equals(stato, lampadina.stato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxAzionamenti, azionamenti, stato);
    }

    // Senza toString() stamperei un hash dell'indirizzo di memoria
    @Override
    public String toString() {
        return "Lampadina{" +
                "maxAzionamenti=" + maxAzionamenti +
                ", azionamenti=" + azionamenti +
                ", stato='" + stato + '\'' +
                '}';
    }
}
