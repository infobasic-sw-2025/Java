public class TicketPrice {
    public static void main(String[] args) {
        int eta = 22;
        boolean studente = true;
        double prezzo;

        if (eta < 6) {
            prezzo = 0;
        } else if (eta < 18 || eta >= 65) {
            prezzo = 6;
        } else if (studente && eta <= 25) {
            prezzo = 8;
        } else {
            prezzo = 12;
        }
        System.out.println("Prezzo: " + prezzo + " euro");

        // Bonus: il ternario sceglie solo la parola, la frase resta una
        String tipo = prezzo == 0 ? "gratuito" : "a pagamento";
        System.out.println("Biglietto " + tipo);
    }
}
