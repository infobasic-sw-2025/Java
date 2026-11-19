public class NotificaEmail extends Notifica {
    private String emailDestinatario;

    public NotificaEmail(String mittente, String messaggio, String emailDestinatario) {
        super(mittente, messaggio);
        this.emailDestinatario = emailDestinatario;
    }

    @Override
    public String invia() {
        return "Email a " + emailDestinatario + ": " + getMessaggio();
    }
}
