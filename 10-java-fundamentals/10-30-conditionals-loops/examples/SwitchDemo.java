// 2/3 · Switch
public class SwitchDemo {
    public static void main(String[] args) {
        // Dato un numero del giorno, stampiamo il nome della settimana
        int giorno = 3;
        switch (giorno) {
            case 1:
                System.out.println("Lunedì");
                break;
            case 3:
                System.out.println("Mercoledì");
                break;
            default:
                System.out.println("Altro giorno");
        }

        // Dato un livello, stampiamo i livelli dal suo in su (togliamo break e vediamo)
        int livello = 2;
        switch (livello) {
            case 1: System.out.println("Base");
            case 2: System.out.println("Intermedio");
            case 3: System.out.println("Avanzato"); break;
        }

        // Classifichiamo un giorno come feriale o weekend, con la freccia
        giorno = 6;
        switch (giorno) {
            case 1, 2, 3, 4, 5 -> System.out.println("Feriale");
            case 6, 7 -> System.out.println("Weekend");
            default -> System.out.println("Non valido");
        }

        // Salviamo "feriale" o "weekend" in una variabile, direttamente dallo switch
        String tipo = switch (giorno) {
            case 1, 2, 3, 4, 5 -> "feriale";
            case 6, 7 -> "weekend";
            default -> "non valido";
        };
        System.out.println(tipo);

        // Dato un punteggio, calcoliamo un giudizio con più istruzioni in un caso
        int punti = 75;
        String giudizio = switch (punti / 10) {
            case 10, 9 -> "ottimo";
            case 8, 7 -> {
                System.out.println("Buon risultato");
                yield "buono";
            }
            default -> "da migliorare";
        };
        System.out.println(giudizio);

        // Descriviamo un valore sconosciuto in base al suo tipo e al suo contenuto
        Object valore = 42;
        String desc = switch (valore) {
            case Integer n when n > 10 -> "numero grande";
            case Integer n -> "numero piccolo";
            case String t -> "testo";
            default -> "altro";
        };
        System.out.println(desc);
    }
}
