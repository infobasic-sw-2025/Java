import java.util.Objects;

public class LampadinaEnum {

    // int potrebbe essere troppo grande ma per ora
    // va bene così
    private int maxAzionamenti;
    private int azionamenti;
    private StatoLampadina stato; // Var di istanza

    public LampadinaEnum(int maxAzionamenti) {
        this.maxAzionamenti = maxAzionamenti; // ricordate il this e cosa significa
        this.azionamenti = 0; // this è superfluo perché non ho nessuna var ambigua
        this.stato = StatoLampadina.SPENTA;
    }

    // Tecnicamente potrei avere aziona boolean che torna se la lampadina è rotta o spenta
    // public StatoLampadina aziona(){...} dove StatoLampadina è una Enum
    public void aziona(){

        // Se la lampadina è rotta, rimane rotta
        if (stato == StatoLampadina.ROTTA){

            // Uso System.out come log, idealmente dovrei usare un framework di logging
            System.out.println("Lampadina già in stato: " + StatoLampadina.ROTTA);
            return;
        }

        // Se arrivo qui, la lampadina non è rotta e aumento di 1
        // il contatore
        azionamenti++;

        // L'azionamento che raggiunge il massimo rompe la lampadina
        // Mettere >= non è tecnicamente errore, ma è possibile andare oltre il maxAzionamenti?
        if(azionamenti == maxAzionamenti){

            System.out.println("Nuovo stato lampadina: " + StatoLampadina.ROTTA);
            stato = StatoLampadina.ROTTA;
        } else if (stato == StatoLampadina.ACCESA){

            System.out.println("Nuovo stato lampadina: " + StatoLampadina.SPENTA);
            stato = StatoLampadina.SPENTA;
        } else {

            System.out.println("Nuovo stato lampadina: " + StatoLampadina.ACCESA);
            stato = StatoLampadina.ACCESA;
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
    public StatoLampadina getStato() {
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

        LampadinaEnum lampadina = (LampadinaEnum) o;

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
        return "LampadinaEnum{" +
                "maxAzionamenti=" + maxAzionamenti +
                ", azionamenti=" + azionamenti +
                ", stato=" + stato +
                '}';
    }
}
