// Nome della classe uguale al nome del file
// no main
public class Studente extends Object {

    // private --> modificatore di visibilità: l'attributo si vede solo dentro la classe.
    // Non è il default: senza modificatore l'attributo è visibile a tutte le classi della stessa cartella (package).
    // Per convenzione gli attributi di istanza sono private
    private String nome; // attributo di istanza
    private int eta;
    private double media;
    public boolean attivo;

    // Costruttore vuoto
    public Studente() {
        this.nome = "Sconosciuto"; // this in questo caso potrei ometterlo perchè non ho parametri con lo stesso nome
        this.eta = 39;
        this.media = 0.0;
        this.attivo = true;
    }

    public Studente(String nome, int eta, double media, boolean attivo) {
        this.nome = nome;
        this.eta = eta;
        this.media = media;
        this.attivo = attivo;
    }

    public PrenotazioneEsame prenotaEsame(){
        return new PrenotazioneEsame();
    }

    public void rinunciaStudi(){
        this.attivo = false;
    }

    private String metodoPrivato(){
        return "Privato";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "nome='" + nome + '\'' +
                ", eta=" + eta +
                ", media=" + media +
                '}';
    }


}
