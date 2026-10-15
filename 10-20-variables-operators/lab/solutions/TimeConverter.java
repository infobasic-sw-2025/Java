public class TimeConverter {
    public static void main(String[] args) {
        int totaleSecondi = 10000;

        int ore = totaleSecondi / 3600;
        int minuti = totaleSecondi % 3600 / 60;
        int secondi = totaleSecondi % 60;

        System.out.println(totaleSecondi + " secondi = " + ore + " ore, " + minuti + " minuti e " + secondi + " secondi");
    }
}
