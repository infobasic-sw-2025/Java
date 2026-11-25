public class Sms extends Notifica {

    public Sms(String numero) {
        super(numero);
    }

    @Override
    public void invia(String testo) {
        System.out.println("SMS al " + destinatario + ": " + testo);
    }
}
