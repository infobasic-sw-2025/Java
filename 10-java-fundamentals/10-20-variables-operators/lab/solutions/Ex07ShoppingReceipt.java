public class Ex07ShoppingReceipt {
    public static void main(String[] args) {
        final double IVA = 0.22;
        final double SCONTO = 0.10;

        double prezzoPane = 2.50;
        int quantitaPane = 2;
        double prezzoLatte = 1.29;
        int quantitaLatte = 3;
        double prezzoCaffe = 4.99;
        int quantitaCaffe = 1;

        double imponibile = prezzoPane * quantitaPane
                + prezzoLatte * quantitaLatte
                + prezzoCaffe * quantitaCaffe;
        double scontato = imponibile * (1 - SCONTO);
        double totale = scontato * (1 + IVA);
        double arrotondato = Math.round(totale * 100) / 100.0;
        int articoli = quantitaPane + quantitaLatte + quantitaCaffe;

        System.out.println("Articoli: " + articoli);
        System.out.println("Imponibile: " + imponibile);
        System.out.println("Scontato: " + scontato);
        System.out.println("Totale con IVA: " + totale);
        System.out.println("Da pagare: " + arrotondato + " euro");
    }
}
