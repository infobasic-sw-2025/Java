public class Main {
    public static void main(String[] args) {
        Notifica[] notifiche = {
            new NotificaEmail("Scuola", "Lezione spostata", "anna@email.it"),
            new NotificaSMS("Banca", "Codice 1234", "3331234567"),
            new NotificaPush("Meteo", "Pioggia in arrivo", "Telefono di Marco")
        };

        for (Notifica n : notifiche) {
            System.out.println(n.invia());
        }
    }
}
