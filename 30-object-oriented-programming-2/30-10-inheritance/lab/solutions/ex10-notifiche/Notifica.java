public class Notifica {
    private String mittente;
    private String messaggio;

    public Notifica(String mittente, String messaggio) {
        this.mittente = mittente;
        this.messaggio = messaggio;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public String invia() {
        return "Da " + mittente + ": " + messaggio;
    }
}
