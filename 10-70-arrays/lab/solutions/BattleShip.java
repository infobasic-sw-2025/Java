import java.util.Scanner;

// Battaglia navale: versione finale, con tutte e 6 le funzionalità.
// Parte dalla soluzione scritta in aula (https://github.com/dfellaib/battaglia-navale-java)
// e la completa. I commenti "Funzionalità N" indicano dove entra ciascuna
public class BattleShip {

    // costanti sempre in upper case
    static final int COLPI_MAX = 15; // 15 da specifiche, Funzionalità 6
    static final char SIMBOLO_ACQUA = '~';
    static final char SIMBOLO_COLPITO = 'X';
    static final char SIMBOLO_MANCATO = 'O';
    static final char SIMBOLO_NAVE = 'N';

    // TODO: rendere 5 e 3 parametrici (o da configurazione o da terminale con lo Scanner)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int colpi = 0; // Contatore che cresce solo con colpi validi
        int colpite = 0; // Contatore di quante caselle sono state colpite, la nave è affondata se questo vale 3

        System.out.println("BattleShip v 1.0");

        // Funzionalità 1-2 · campo: ciò che vede il giocatore. navi: dove si trova la nave
        char[][] campo = new char[5][5];
        char[][] navi = new char[5][5];

        // Devo inizializzare il campo da gioco
        for (int r = 0; r < campo.length; r++) {
            for (int c = 0; c < campo[r].length; c++) {
                campo[r][c] = SIMBOLO_ACQUA;
                navi[r][c] = SIMBOLO_ACQUA;
            }
        }

        // Funzionalità 5 · Creo e posiziono la nave da 3 caselle casualmente

        // Come tirare una monetina 50:50, in alternativa pari o dispari
        boolean orizzontale = Math.random() < 0.5;
        if (orizzontale) {
            int riga = (int) (Math.random() * 5); // Non sarà mai 5 perché arrotondo per difetto, 0-4
            int colonna = (int) (Math.random() * 3); // 0-2: con 3 la nave uscirebbe dalla griglia

            // Questo loop è per posizionare la mia nave nella mappa
            // Perché la mia nave, da specifica, è lunga 3
            for (int i = 0; i < 3; i++) {
                navi[riga][colonna + i] = SIMBOLO_NAVE;
            }
        } else {
            int riga = (int) (Math.random() * 3);
            int colonna = (int) (Math.random() * 5);

            for (int i = 0; i < 3; i++) {
                navi[riga + i][colonna] = SIMBOLO_NAVE;
            }
        }

        // Durante le prove si può stampare anche navi per vedere dov'è la nave
        //stampaCampo(navi);
        stampaCampo(campo);

        // Funzionalità 3 e 6 · Continuo a giocare finché non ho colpito la nave 3 volte o non ho finito i 15 colpi
        while (colpite < 3 && colpi < COLPI_MAX) {
            // Chiedo le coordinate di attacco
            // TODO: Validare il numero anche se metto una stringa (es: "Ciao")
            System.out.println("Inserisci riga (0-4):");
            int riga = scanner.nextInt();
            System.out.println("Inserisci colonna (0-4):");
            int colonna = scanner.nextInt();

            // Funzionalità 4 · Valido la coordinata: se non è valida il colpo non si conta
            if (!coordinataValida(campo, riga, colonna))
                continue;

            // Funzionalità 2 · Applico il colpo
            colpi++;
            if (navi[riga][colonna] == SIMBOLO_NAVE) {
                campo[riga][colonna] = SIMBOLO_COLPITO;
                colpite++;
                System.out.println("Colpito! Colpi rimasti: " + (COLPI_MAX - colpi));
            } else {
                campo[riga][colonna] = SIMBOLO_MANCATO;
                System.out.println("Mancato! Colpi rimasti: " + (COLPI_MAX - colpi));
            }
            System.out.println();
            stampaCampo(campo);
        }

        // Funzionalità 6 · Il ciclo finisce per due motivi: si capisce quale guardando colpite
        if (colpite == 3) {
            System.out.println("Nave affondata in " + colpi + " colpi!");
        } else {
            System.out.println("Hai perso! La nave era qui:");
            stampaCampo(navi);
        }

        scanner.close();
    }

    // Funzionalità 1 · Stampa la griglia, celle separate da uno spazio
    private static void stampaCampo(char[][] campo) {

        // TODO: Riconvertire con un for-each
        // r sta per riga, c sta per colonna (andava bene anche "i" e "j")
        for (int r = 0; r < campo.length; r++) {
            for (int c = 0; c < campo[r].length; c++) {
                System.out.print(campo[r][c]);

                if (c < campo[r].length - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Funzionalità 4 · metodo "ausiliario" o di "appoggio" che ha il compito di verificare la coordinata
    private static boolean coordinataValida(char[][] campo, int riga, int colonna) {
        // Prima controllo che la coordinata sia dentro la griglia: altrimenti campo[riga][colonna]
        // darebbe ArrayIndexOutOfBoundsException
        if (riga < 0 || riga >= 5 || colonna < 0 || colonna >= 5) {
            System.out.println("Coordinate fuori dalla griglia, riprova");
            System.out.println();

            return false;
        }

        // Se giocatore spara due volte nello stesso punto? Non lo considero valido
        if (campo[riga][colonna] != SIMBOLO_ACQUA) {
            System.out.println("Hai già sparato qui, riprova");
            System.out.println();

            return false;
        }

        return true;
    }
}
