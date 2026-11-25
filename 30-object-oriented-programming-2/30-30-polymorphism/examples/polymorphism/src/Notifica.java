public abstract class Notifica {

    protected String destinatario;

    public Notifica(String destinatario) {
        this.destinatario = destinatario;
    }

    // ogni canale invia a modo suo
    public abstract void invia(String testo);
}
