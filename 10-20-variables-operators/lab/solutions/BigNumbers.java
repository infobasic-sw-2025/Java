public class BigNumbers {
    public static void main(String[] args) {
        int secondiInCentoAnni = 100 * 365 * 24 * 3600;
        System.out.println("Secondi in 100 anni (int): " + secondiInCentoAnni);

        long secondiLong = 100L * 365 * 24 * 3600;
        System.out.println("Secondi in 100 anni (long): " + secondiLong);

        long msSbagliati = 365 * 24 * 3600 * 1000;
        long msCorretti = 365 * 24 * 3600 * 1000L;
        System.out.println("Millisecondi in un anno: " + msSbagliati);
        System.out.println("Millisecondi in un anno: " + msCorretti);
    }
}
