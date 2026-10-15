public class FixTheErrors {
    public static void main(String[] args) {
        long popolazione = 3000000000L;
        float prezzo = 19.99f;
        int metri = 1250;
        int chilometri = metri / 1000;
        byte livello = 100;
        livello = (byte) (livello + 1);
        final int MASSIMO = 50;
        int punteggio = MASSIMO + 10;
        double media = (7 + 8) / 2.0;
        boolean promosso = media >= 6;
        String messaggio = "Media: " + media;

        System.out.println(popolazione + " " + prezzo + " " + chilometri + " " + livello);
        System.out.println(punteggio + " " + messaggio + " " + promosso);
    }
}
