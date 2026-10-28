public class Ex02Grades {
    public static void main(String[] args) {
        int voto = 7;

        if (voto < 0 || voto > 10) {
            System.out.println("Voto non valido");
        } else if (voto >= 9) {
            System.out.println("Giudizio: ottimo");
        } else if (voto >= 7) {
            System.out.println("Giudizio: buono");
        } else if (voto >= 6) {
            System.out.println("Giudizio: sufficiente");
        } else {
            System.out.println("Giudizio: insufficiente");
        }

        String esito = voto >= 6 ? "promosso" : "bocciato";
        System.out.println("Esito: " + esito);
    }
}
