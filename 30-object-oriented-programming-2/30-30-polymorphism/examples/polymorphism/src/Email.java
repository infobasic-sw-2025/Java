public class Email extends Notifica {

    public Email(String indirizzo) {
        super(indirizzo);
    }

    @Override
    public void invia(String testo) {
        System.out.println("Email a " + destinatario + ": " + testo);
    }
}
