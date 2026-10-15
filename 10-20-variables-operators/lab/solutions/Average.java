public class Average {
    public static void main(String[] args) {
        int voto1 = 7;
        int voto2 = 8;
        int voto3 = 8;

        double sbagliata = (voto1 + voto2 + voto3) / 3;
        double corretta = (voto1 + voto2 + voto3) / 3.0;
        double unDecimale = Math.round(corretta * 10) / 10.0;

        System.out.println("Media tra interi: " + sbagliata);
        System.out.println("Media: " + corretta);
        System.out.println("Media arrotondata: " + unDecimale);
    }
}
