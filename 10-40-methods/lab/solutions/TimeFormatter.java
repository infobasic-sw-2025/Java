public class TimeFormatter {

    static String formattaTempo(int totaleSecondi) {
        int ore = totaleSecondi / 3600;
        int minuti = totaleSecondi % 3600 / 60;
        int secondi = totaleSecondi % 60;
        return ore + "h " + minuti + "m " + secondi + "s";
    }

    static int tempoInSecondi(int ore, int minuti, int secondi) {
        return ore * 3600 + minuti * 60 + secondi;
    }

    public static void main(String[] args) {
        System.out.println("10000 secondi = " + formattaTempo(10000));
        System.out.println("1h 30m 0s = " + tempoInSecondi(1, 30, 0) + " secondi");

        // Verifica: andata e ritorno danno lo stesso valore
        System.out.println(formattaTempo(tempoInSecondi(2, 46, 40)));
    }
}
