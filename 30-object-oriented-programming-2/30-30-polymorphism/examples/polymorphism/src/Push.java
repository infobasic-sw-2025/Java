public class Push extends Notifica {

    public Push(String utente) {
        super(utente);
    }

    @Override
    public void invia(String testo) {
        System.out.println("Push per " + destinatario + ": " + testo);
    }
}
