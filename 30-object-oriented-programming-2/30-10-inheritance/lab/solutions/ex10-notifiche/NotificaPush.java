public class NotificaPush extends Notifica {
    private String dispositivo;

    public NotificaPush(String mittente, String messaggio, String dispositivo) {
        super(mittente, messaggio);
        this.dispositivo = dispositivo;
    }

    @Override
    public String invia() {
        return "Push su " + dispositivo + ": " + getMessaggio();
    }
}
