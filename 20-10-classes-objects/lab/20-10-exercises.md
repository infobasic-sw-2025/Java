# 20.10 Laboratorio · Classi e oggetti

## Livello 1 · Base

### Esercizio 1 · Lampadina

Progettare una classe `Lampadina` che modella una lampadina classica.

La lampadina può essere in uno dei seguenti stati: `ACCESA`, `SPENTA` o `ROTTA`.

La classe deve contenere:
- i campi necessari a descriverne lo stato e il numero di azionamenti effettuati
- un costruttore che riceve il numero massimo di azionamenti prima che la lampadina si rompa
- un metodo `getStato()` che restituisce lo stato corrente come stringa
- un metodo `aziona()` che cambia lo stato della lampadina:
  - da accesa a spenta
  - da spenta ad accesa
  - se si raggiunge il limite massimo di azionamenti, lo stato diventa `ROTTA` e non cambia più

Scrivere una classe `Main` di test che crei una lampadina con massimo 4 azionamenti e la azioni ripetutamente, stampando lo stato a ogni passaggio.

### Esercizio 2 · Rettangolo

Creare una classe `Rettangolo` con:
- campi privati `base` e `altezza` (double)
- costruttore con parametri
- getter per entrambi i campi
- setter con validazione (i valori devono essere positivi)
- metodo `calcolaArea()` che restituisce l'area
- metodo `calcolaPerimetro()` che restituisce il perimetro
- metodo `isQuadrato()` che restituisce `true` se base e altezza sono uguali
- `toString()` che restituisce una rappresentazione leggibile

Nella classe `Main` creare tre rettangoli, stampare area e perimetro di ciascuno, e verificare quale è un quadrato.

### Esercizio 3 · Contatto

Creare una classe `Contatto` con:
- campi privati `nome`, `cognome` e `telefono` (tutti String)
- costruttore con i tre parametri
- getter e setter per tutti i campi
- `toString()` che restituisce il contatto in formato "Cognome Nome — telefono"

Nella classe `Main` creare un array di 5 contatti e stampare la rubrica completa.

### Esercizio 4 · Dado

Creare una classe `Dado` con:
- campo privato `facce` (int, il numero di facce del dado)
- campo privato `ultimoLancio` (int)
- costruttore che riceve il numero di facce
- metodo `lancia()` che genera un numero casuale tra 1 e il numero di facce (usare `Math.random()`)
- metodo `getUltimoLancio()` che restituisce l'ultimo valore generato
- `toString()` che restituisce "Dado[facce=N, ultimo=X]"

Nella classe `Main` creare un dado a 6 facce, lanciarlo 10 volte e stampare ogni risultato. Contare quante volte esce il 6.

---

## Livello 2 · Intermedio

### Esercizio 5 · Conto bancario

Creare una classe `ContoBancario` con:
- campi privati: `intestatario` (String), `numeroConto` (String), `saldo` (double)
- costruttore che riceve intestatario e numero di conto (il saldo iniziale è 0)
- metodo `versa(double importo)` — aggiunge l'importo al saldo (solo se positivo)
- metodo `preleva(double importo)` — sottrae l'importo dal saldo (solo se positivo e se il saldo è sufficiente); restituisce `true` se il prelievo va a buon fine, `false` altrimenti
- getter per tutti i campi (il saldo non ha setter)
- `toString()` che restituisce le informazioni del conto

Nella classe `Main` creare due conti, effettuare operazioni di versamento e prelievo, e stampare lo stato finale.

### Esercizio 6 · Biblioteca

Creare una classe `Libro` con:
- campi privati: `titolo` (String), `autore` (String), `disponibile` (boolean, inizialmente `true`)
- costruttore, getter, `toString()`
- metodo `presta()` — segna il libro come non disponibile (solo se era disponibile); restituisce `true` se il prestito va a buon fine
- metodo `restituisci()` — segna il libro come disponibile

Creare una classe `Biblioteca` con:
- campo privato: array di `Libro` (dimensione fissa)
- campo privato: `numLibri` (int, quanti libri sono stati aggiunti)
- costruttore che riceve la capienza massima
- metodo `aggiungi(Libro libro)` — aggiunge un libro se c'è spazio
- metodo `cercaPerTitolo(String titolo)` — restituisce il libro con quel titolo, o `null` se non trovato
- metodo `stampaDisponibili()` — stampa solo i libri disponibili

Nella classe `Main` creare una biblioteca con 10 posti, aggiungere 5 libri, prestarne 2, e stampare i libri disponibili.

### Esercizio 7 · Studente e voti

Creare una classe `StudenteVoti` con:
- campi privati: `nome` (String), `voti` (array di int), `numVoti` (int)
- costruttore che riceve il nome e il numero massimo di voti
- metodo `aggiungiVoto(int voto)` — aggiunge un voto (tra 18 e 30) se c'è spazio
- metodo `calcolaMedia()` — restituisce la media dei voti inseriti
- metodo `getVotoMassimo()` — restituisce il voto più alto
- metodo `getVotoMinimo()` — restituisce il voto più basso
- `toString()` che mostra nome, numero di voti e media

Nella classe `Main` creare 3 studenti, aggiungere voti a ciascuno, e determinare chi ha la media più alta.

### Esercizio 8 · Cronometro

Creare una classe `Cronometro` con:
- campi privati: `tempoInizio` (long), `tempoFine` (long), `inCorso` (boolean)
- metodo `avvia()` — registra il tempo di inizio con `System.currentTimeMillis()`
- metodo `ferma()` — registra il tempo di fine
- metodo `getDurataMillis()` — restituisce la durata in millisecondi
- metodo `getDurataSecondi()` — restituisce la durata in secondi (double)
- `toString()` che mostra la durata in formato leggibile

Nella classe `Main` avviare il cronometro, eseguire un ciclo con molte iterazioni, fermare il cronometro e stampare il tempo trascorso.

---

## Livello 3 · Avanzato

### Esercizio 9 · Interruttore e Lampadina

Partendo dalla classe `Lampadina` dell'esercizio 1, creare una classe `Interruttore`:
- campo privato: `lampadina` (riferimento a un oggetto Lampadina)
- costruttore che riceve la lampadina da controllare
- metodo `premi()` — aziona la lampadina collegata

Nella classe `Main`:
- creare una lampadina con massimo 6 azionamenti
- creare **due interruttori** collegati alla **stessa lampadina**
- premere alternativamente i due interruttori e osservare che entrambi agiscono sulla stessa lampadina
- i due interruttori contengono un riferimento alla stessa lampadina: qualunque dei due si prema, cambia lo stesso oggetto

### Esercizio 10 · Registro scolastico

Creare una classe `Registro` che gestisca un elenco di studenti (riutilizzare la classe `StudenteVoti` dell'esercizio 7):
- campo privato: array di `StudenteVoti`, `numStudenti`
- costruttore che riceve la capienza massima
- metodo `iscrivi(StudenteVoti studente)` — aggiunge uno studente se c'è spazio
- metodo `cercaPerNome(String nome)` — restituisce lo studente con quel nome, o `null`
- metodo `getMediaClasse()` — restituisce la media delle medie di tutti gli studenti
- metodo `getMigliore()` — restituisce lo studente con la media più alta
- metodo `stampaPagella()` — stampa nome e media di ogni studente

Nella classe `Main` creare un registro con 5 posti, iscrivere 4 studenti con voti diversi, e stampare la pagella con la media della classe.

### Esercizio 11 · Distributore automatico

Creare una classe `Prodotto` con:
- campi privati: `nome` (String), `prezzo` (double), `quantita` (int)
- costruttore, getter, `toString()`
- metodo `isDisponibile()` — restituisce `true` se la quantità è maggiore di 0
- metodo `vendi()` — decrementa la quantità di 1 (solo se disponibile)

Creare una classe `Distributore` con:
- campo privato: array di `Prodotto` (dimensione fissa)
- metodo `carica(int posizione, Prodotto prodotto)` — inserisce un prodotto nella posizione indicata
- metodo `mostraProdotti()` — stampa tutti i prodotti con la loro posizione
- metodo `acquista(int posizione, double denaro)` — vende il prodotto alla posizione indicata se disponibile e se il denaro è sufficiente; restituisce il resto

Nella classe `Main` creare un distributore con 5 posizioni, caricare prodotti, simulare alcuni acquisti.

### Esercizio 12 · Playlist musicale

Creare una classe `Canzone` con:
- campi privati: `titolo` (String), `artista` (String), `durataSecondi` (int)
- costruttore, getter, `toString()`

Creare una classe `Playlist` con:
- campi privati: `nome` (String), array di `Canzone`, `numCanzoni` (int)
- costruttore che riceve il nome e la capienza massima
- metodo `aggiungi(Canzone canzone)` — aggiunge una canzone se c'è spazio
- metodo `rimuovi(String titolo)` — rimuove la canzone con quel titolo (spostando le successive)
- metodo `getDurataTotale()` — restituisce la durata totale in secondi
- metodo `getDurataTotaleFormattata()` — restituisce la durata in formato "Xm Ys"
- metodo `cerca(String parola)` — restituisce un array con le canzoni il cui titolo contiene la parola
- `toString()` che mostra nome della playlist, numero di canzoni e durata totale

Nella classe `Main` creare una playlist, aggiungere canzoni, cercare per parola chiave, rimuoverne una e stampare la durata totale.

---

## Livello 4 · Overloading e ricorsione

### Esercizio 13 · Overloading: la somma

Creare `SumOverload.java` con tre versioni del metodo `somma`:
- `static int somma(int a, int b)`
- `static int somma(int a, int b, int c)`
- `static double somma(double a, double b)`

Chiamarle tutte dal `main` e verificare che il compilatore scelga quella giusta.

### Esercizio 14 · Il fattoriale ricorsivo

Creare `Factorial.java` con due versioni del fattoriale:
- `static long fattorialeIterativo(int n)` — con un ciclo
- `static long fattorialeRicorsivo(int n)` — il metodo chiama se stesso

Confrontare i risultati per n da 1 a 25: le due versioni danno sempre lo stesso valore? Per quale n il risultato diventa negativo per la prima volta, e perché?
