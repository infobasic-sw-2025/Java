public class Ex06MediaVoti {
    public static void main(String[] args) {
        int voto1 = 28;
        int voto2 = 30;
        int voto3 = 25;
        // Stampe di debug usate per trovare il bug:
        // System.out.println("DEBUG somma = " + (voto1 + voto2 + voto3));
        // System.out.println("DEBUG somma / 3 = " + (voto1 + voto2 + voto3) / 3);
        double media = (voto1 + voto2 + voto3) / 3.0;  // era / 3: divisione intera
        System.out.println("Media: " + media);
    }
}
