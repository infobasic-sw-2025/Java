public class NotificaSMS extends Notifica {
    private String numeroTelefono;

    public NotificaSMS(String mittente, String messaggio, String numeroTelefono) {
        super(mittente, messaggio);
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public String invia() {
        return "SMS a " + numeroTelefono + ": " + getMessaggio();
    }
}
