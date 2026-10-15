public class DayOfWeek {
    public static void main(String[] args) {
        int giorno = 6;

        // 1. switch classico: i casi raggruppati usano il fall-through
        switch (giorno) {
            case 1: case 2: case 3: case 4: case 5:
                System.out.println("Classico: feriale");
                break;
            case 6: case 7:
                System.out.println("Classico: weekend");
                break;
            default:
                System.out.println("Classico: non valido");
        }

        // 2. Forma con la freccia
        switch (giorno) {
            case 1, 2, 3, 4, 5 -> System.out.println("Freccia: feriale");
            case 6, 7 -> System.out.println("Freccia: weekend");
            default -> System.out.println("Freccia: non valido");
        }

        // 3. switch come espressione
        String tipo = switch (giorno) {
            case 1, 2, 3, 4, 5 -> "feriale";
            case 6, 7 -> "weekend";
            default -> "non valido";
        };
        System.out.println("Espressione: " + tipo);

        // Bonus: il nome del giorno
        String nome = switch (giorno) {
            case 1 -> "lunedì";
            case 2 -> "martedì";
            case 3 -> "mercoledì";
            case 4 -> "giovedì";
            case 5 -> "venerdì";
            case 6 -> "sabato";
            case 7 -> "domenica";
            default -> "?";
        };
        System.out.println("Il giorno " + giorno + " è " + nome);
    }
}
