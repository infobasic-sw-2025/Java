# 30.40 Eccezioni e logging — Esercizi di laboratorio

Gli esercizi vanno in ordine: ognuno usa quello che si è visto nei precedenti. Per ogni esercizio creare una cartella con i file indicati, poi compilare ed eseguire dal terminale, stando dentro la cartella:

```
javac *.java
java Main
```

L'output deve essere uguale a quello atteso, riga per riga. Quando un esercizio chiede di provare un errore, scrivere prima che cosa ci si aspetta, poi provare e leggere il messaggio: imparare a leggere i messaggi di errore è metà del lavoro.

## Livello 1 — Leggere e catturare

### Esercizio 1: Leggere lo stack trace

Il programma calcola il tempo totale di un pilota di kart, sommando i tempi dei giri in secondi. Copiarlo così com'è in `Main.java`, compresa la riga di commento in alto: così i numeri di riga sono gli stessi dell'output.

```java
// Esercizio 1 · Leggere lo stack trace
public class Main {

    static int tempoTotale(int[] giri) {
        int totale = 0;
        for (int i = 0; i <= giri.length; i++) {
            totale += giri[i];
        }
        return totale;
    }

    static void stampaRiepilogo(String pilota, int[] giri) {
        System.out.println(pilota + ": " + tempoTotale(giri) + " secondi");
    }

    public static void main(String[] args) {
        System.out.println("Gara di kart");
        stampaRiepilogo("Bianchi", new int[] {62, 59, 61});
        System.out.println("Fine della gara");
    }
}
```

Eseguendolo, il programma si ferma così:

```
Gara di kart
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
	at Main.tempoTotale(Main.java:7)
	at Main.stampaRiepilogo(Main.java:13)
	at Main.main(Main.java:18)
```

Rispondere guardando solo l'output, senza leggere il codice:
1. Qual è il tipo dell'eccezione? E il messaggio?
2. In quale metodo e in quale riga si è verificato l'errore?
3. Chi ha chiamato quel metodo, e da quale riga? Scrivere la catena delle chiamate, dal `main` al punto dell'errore.
4. Perché `Fine della gara` non viene stampato?
5. L'eccezione è checked o unchecked?

Poi correggere l'errore cambiando un solo carattere nella riga 6.

Output atteso dopo la correzione:

```
Gara di kart
Bianchi: 182 secondi
Fine della gara
```

---

### Esercizio 2: Quale eccezione?

Ognuno di questi sei casi, eseguito, lancia un'eccezione. Nel caso 1, `soprannome` è un campo della classe senza valore: `static String soprannome;`, quindi vale `null`.

```java
// Caso 1
System.out.println(soprannome.length());

// Caso 2
int[] posti = new int[4];
posti[4] = 1;

// Caso 3
int fette = 8;
int persone = 0;
System.out.println(fette / persone);

// Caso 4
int quantita = Integer.parseInt("12.5");

// Caso 5
Object valore = "42";
Integer numero = (Integer) valore;

// Caso 6
System.out.println("ab".repeat(-2));
```

Prima di scrivere il codice, segnare su un foglio quale eccezione ci si aspetta per ogni caso. Poi scrivere un `Main` con un `try`/`catch` per ogni caso:
- nel `catch` va il tipo **preciso** dell'eccezione, non `Exception`
- nel `catch` si stampa `"Caso <n>: " + e`
- per il caso 4 si stampano anche `e.getMessage()` e `e.getClass().getName()`, per vedere la differenza tra le tre forme

Output atteso:

```
Caso 1: java.lang.NullPointerException: Cannot invoke "String.length()" because "Main.soprannome" is null
Caso 2: java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
Caso 3: java.lang.ArithmeticException: / by zero
Caso 4: java.lang.NumberFormatException: For input string: "12.5"
  messaggio: For input string: "12.5"
  classe: java.lang.NumberFormatException
Caso 5: java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
Caso 6: java.lang.IllegalArgumentException: count is negative: -2
```

Poi rispondere:
- Queste sei eccezioni sono checked o unchecked? Da quale classe discendono tutte?
- Nel caso 3, che cosa succede se nel `catch` si scrive `NumberFormatException` invece di `ArithmeticException`? Provare.

---

### Esercizio 3: Il contapassi

Un contapassi ha registrato i passi di una settimana, ma alcune letture sono rovinate. Le letture sono testi, da convertire con `Integer.parseInt`:

```java
String[] giorni = {"Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato", "Domenica"};
String[] letture = {"8500", "12000", "n/d", "10400", "", "7.300", "6100"};
```

1. Scrivere il metodo `static int leggiObiettivo(Scanner sc)`: chiede `Obiettivo di passi al giorno: ` (con `print`, non `println`) e legge la risposta con `sc.nextLine()`. Se la risposta non è un numero intero, stampa `Non è un numero intero, riprova.` e chiede di nuovo, finché il numero è valido. Suggerimento: un ciclo `while (true)` con dentro il `try`; nel `try`, `return Integer.parseInt(testo);`.
2. Nel `main` leggere l'obiettivo, poi scorrere le letture. Per ogni lettura valida stampare `<giorno>: <passi> passi`, con in più ` (obiettivo raggiunto)` se i passi sono almeno l'obiettivo. Per una lettura non valida stampare `<giorno>: lettura non valida (<messaggio dell'eccezione>)` e passare al giorno dopo.
3. Alla fine stampare i giorni validi, il totale e la media dei passi (divisione intera), poi in quanti giorni l'obiettivo è stato raggiunto.

Esempio di esecuzione: dopo i due punti, `diecimila` e `10000` li scrive l'utente.

```
Obiettivo di passi al giorno: diecimila
Non è un numero intero, riprova.
Obiettivo di passi al giorno: 10000
Lunedì: 8500 passi
Martedì: 12000 passi (obiettivo raggiunto)
Mercoledì: lettura non valida (For input string: "n/d")
Giovedì: 10400 passi (obiettivo raggiunto)
Venerdì: lettura non valida (For input string: "")
Sabato: lettura non valida (For input string: "7.300")
Domenica: 6100 passi
Giorni validi: 4, passi totali: 37000, media: 9250
Obiettivo raggiunto in 2 giorni su 4
```

Infine provare a lasciare **vuoto** il `catch` del ciclo (solo le graffe). Che cosa stampa il programma per mercoledì, venerdì e sabato? Perché è un problema, anche se i totali restano giusti?

---

## Livello 2 — try, catch, finally e propagazione

### Esercizio 4: Squadre per il torneo

A un torneo di calcetto ci sono 22 iscritti. Gli organizzatori propongono quanti giocatori mettere in ogni squadra, ma le proposte arrivano come testi e non tutte sono valide:

```java
int iscritti = 22;
String[] proposte = {"5", "sei", "0", "11"};
```

**Parte 1.** Scrivere il metodo `static void conDueCatch(int iscritti, String[] proposte)`. Per ogni proposta:
- convertirla in intero (`perSquadra`), calcolare `iscritti / perSquadra` (le squadre) e `iscritti % perSquadra` (chi resta fuori) e stampare `Squadre da <n>: <squadre> squadre, <fuori> iscritti restano fuori`
- con `NumberFormatException` stampare `Non è un numero: <proposta>`
- con `ArithmeticException` stampare `Una squadra non può avere 0 giocatori`
- nel `finally` stampare `-- proposta <numero della proposta, da 1> valutata`

**Parte 2.** Scrivere il metodo `static void conMultiCatch(int iscritti, String[] proposte)`, che stampa solo `Squadre da <n>: <squadre> squadre` e gestisce le due eccezioni con **un solo** `catch` (multi-catch, con `|`), stampando `Proposta scartata: ` seguito da `e.getMessage()`. Niente `finally`.

Nel `main` chiamare i due metodi, separati da una riga `---`.

Output atteso:

```
Squadre da 5: 4 squadre, 2 iscritti restano fuori
-- proposta 1 valutata
Non è un numero: sei
-- proposta 2 valutata
Una squadra non può avere 0 giocatori
-- proposta 3 valutata
Squadre da 11: 2 squadre, 0 iscritti restano fuori
-- proposta 4 valutata
---
Squadre da 5: 4 squadre
Proposta scartata: For input string: "sei"
Proposta scartata: / by zero
Squadre da 11: 2 squadre
```

Il `finally` viene eseguito anche per le proposte che vanno bene: perché?

**Parte 3.** In `conDueCatch` aggiungere, come **primo** `catch`, un `catch (Exception e)` che stampa `Errore generico`. Compilare e leggere gli errori:

```
error: exception NumberFormatException has already been caught
error: exception ArithmeticException has already been caught
```

Spiegare perché, poi togliere il `catch (Exception e)`. Compilerebbe se fosse messo per ultimo?

---

### Esercizio 5: L'eccezione risale

Il programma calcola quanti pullman servono per tre gite scolastiche. Le righe `inizio` e `fine` servono a vedere quali parti dei metodi vengono eseguite. Copiarlo così com'è in `Main.java`:

```java
// Esercizio 5 · L'eccezione risale
public class Main {

    static int pullmanNecessari(int partecipanti, int postiPerPullman) {
        System.out.println("  inizio pullmanNecessari");
        int pullman = partecipanti / postiPerPullman;
        if (partecipanti % postiPerPullman != 0) {
            pullman++; // serve un pullman in più per chi avanza
        }
        System.out.println("  fine pullmanNecessari");
        return pullman;
    }

    static void stampaPreventivo(String meta, int partecipanti, int posti) {
        System.out.println("inizio stampaPreventivo: " + meta);
        int pullman = pullmanNecessari(partecipanti, posti);
        System.out.println(meta + ": " + pullman + " pullman per " + partecipanti + " partecipanti");
        System.out.println("fine stampaPreventivo: " + meta);
    }

    public static void main(String[] args) {
        String[] mete = {"Firenze", "Verona", "Torino"};
        int[] partecipanti = {95, 60, 40};
        int[] posti = {50, 0, 54};

        for (int i = 0; i < mete.length; i++) {
            stampaPreventivo(mete[i], partecipanti[i], posti[i]);
        }
        System.out.println("Preventivi finiti");
    }
}
```

Per Verona qualcuno ha scritto 0 posti per pullman. Output:

```
inizio stampaPreventivo: Firenze
  inizio pullmanNecessari
  fine pullmanNecessari
Firenze: 2 pullman per 95 partecipanti
fine stampaPreventivo: Firenze
inizio stampaPreventivo: Verona
  inizio pullmanNecessari
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Main.pullmanNecessari(Main.java:6)
	at Main.stampaPreventivo(Main.java:16)
	at Main.main(Main.java:27)
```

1. Per Verona, quali righe `fine` mancano? Perché?
2. Seguendo lo stack trace, scrivere il percorso dell'eccezione: da quale metodo parte, da quali passa, dove si ferma il programma.
3. Aggiungere nel `main` un `try`/`catch` attorno alla chiamata a `stampaPreventivo`. Nel `catch (ArithmeticException e)` stampare `Preventivo per <meta> non calcolato: ` seguito da `e.getMessage()`. I due metodi non vanno toccati.

Output atteso:

```
inizio stampaPreventivo: Firenze
  inizio pullmanNecessari
  fine pullmanNecessari
Firenze: 2 pullman per 95 partecipanti
fine stampaPreventivo: Firenze
inizio stampaPreventivo: Verona
  inizio pullmanNecessari
Preventivo per Verona non calcolato: / by zero
inizio stampaPreventivo: Torino
  inizio pullmanNecessari
  fine pullmanNecessari
Torino: 1 pullman per 40 partecipanti
fine stampaPreventivo: Torino
Preventivi finiti
```

4. Come prova, spostare il `try`/`catch` dentro `stampaPreventivo`, attorno alle due righe `int pullman = ...` e `System.out.println(meta + ...)`, con lo stesso messaggio nel `catch`. Per Verona compare una riga in più: quale, e perché?

---

### Esercizio 6: Trova l'errore

I frammenti stanno nel `main` di una classe `Main` che ha già gli import `java.io.File`, `java.io.FileNotFoundException` e `java.util.Scanner`. I frammenti 6 e 7 hanno anche un metodo statico. `TavoloPienoException` è una classe che estende `Exception`, con un costruttore che riceve il messaggio e lo passa a `super`.

Per ogni frammento dire:
- se **non compila** (errore del compilatore), se **compila ma si ferma** con un'eccezione a runtime oppure se **funziona**
- perché
- come si corregge

**Frammento 1**
```java
try {
    int pezzi = Integer.parseInt("12");
} catch (NumberFormatException e) {
    System.out.println("Non è un numero");
}
System.out.println(pezzi);
```

**Frammento 2**
```java
Scanner sc = new Scanner(new File("orari.txt"));
System.out.println(sc.nextLine());
```

**Frammento 3**
```java
try {
    int[] voli = new int[3];
    voli[3] = 1;
} catch (NumberFormatException e) {
    System.out.println("Errore");
}
```

**Frammento 4**
```java
try {
    int posti = 4;
    System.out.println("Posti: " + posti);
} catch (FileNotFoundException e) {
    System.out.println("File non trovato");
}
```

**Frammento 5**
```java
String codice = "";
if (codice.isEmpty()) {
    throw IllegalArgumentException("Codice vuoto");
}
```

**Frammento 6**
```java
static void impostaVelocita(int kmh) {
    if (kmh < 0) {
        throw new IllegalArgumentException("Velocità non valida: " + kmh);
    }
    System.out.println("Velocità: " + kmh + " km/h");
}

// nel main
try {
    impostaVelocita(-3);
} catch (IllegalArgumentException e) {
    System.out.println("Errore: " + e.getMessage());
}
```

**Frammento 7**
```java
static void prenota(int posti) {
    if (posti > 4) {
        throw new TavoloPienoException("Massimo 4 posti, richiesti " + posti);
    }
    System.out.println("Tavolo per " + posti + " prenotato");
}

// nel main
prenota(2);
```

Dopo aver risposto, verificare ogni frammento. La prima riga dei messaggi che si ottengono è una di queste (alcune compaiono due volte):

```
error: cannot find symbol
error: unreported exception FileNotFoundException; must be caught or declared to be thrown
error: exception FileNotFoundException is never thrown in body of corresponding try statement
error: unreported exception TavoloPienoException; must be caught or declared to be thrown
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
```

---

## Livello 3 — throw, throws ed eccezioni nuove

### Esercizio 7: La sveglia

Creare la classe `Sveglia` con i campi `ore`, `minuti`, `etichetta` (String) e `attiva` (boolean). Il costruttore `Sveglia(int ore, int minuti, String etichetta)` controlla i dati e, se uno non va bene, lancia una `IllegalArgumentException`, controllando in quest'ordine:
- ore da 0 a 23, altrimenti `Ora non valida: <ore>`
- minuti da 0 a 59, altrimenti `Minuti non validi: <minuti>`
- etichetta non `null` e non vuota (`isBlank()`), altrimenti `Etichetta mancante`

Una sveglia appena creata è attiva. Metodi:
- `posticipa(int quanti)`: sposta la sveglia in avanti di `quanti` minuti. Se la sveglia è spenta lancia `IllegalStateException` con `La sveglia <etichetta> è spenta`; se `quanti` non è tra 1 e 30 lancia `IllegalArgumentException` con `Posticipo non valido: <quanti> minuti`. Dopo le 23:59 si torna a 00:00: conviene calcolare i minuti totali `ore * 60 + minuti + quanti`, poi ricavare ore (`% 24`) e minuti.
- `spegni()`: se la sveglia è già spenta lancia `IllegalStateException` con `La sveglia <etichetta> è già spenta`
- `toString()`: `String.format("%02d:%02d %s (%s)", ...)`, per esempio `07:30 Scuola (attiva)`

Nel main:
1. Creare quattro sveglie dentro un ciclo, con un `try`/`catch` per ognuna: se va bene stampare `Creata: <sveglia>`, altrimenti `Sveglia non creata: <messaggio>`.
2. Stampare `---`, creare la sveglia `23:50 Partita` e fare, in ordine: posticipa di 15 minuti, posticipa di 45, spegni, spegni ancora, posticipa di 5. Mettere in un `try`/`catch` solo le chiamate che falliscono, e stampare `Errore: <messaggio>`.

```java
int[] ore = {7, 24, 6, 13};
int[] minuti = {30, 0, 75, 15};
String[] etichette = {"Scuola", "Allenamento", "Treno", " "};
```

Output atteso:

```
Creata: 07:30 Scuola (attiva)
Sveglia non creata: Ora non valida: 24
Sveglia non creata: Minuti non validi: 75
Sveglia non creata: Etichetta mancante
---
Posticipata: 00:05 Partita (attiva)
Errore: Posticipo non valido: 45 minuti
Spenta: 00:05 Partita (spenta)
Errore: La sveglia Partita è già spenta
Errore: La sveglia Partita è spenta
```

Poi rispondere:
- Perché `posticipa` e `spegni` non hanno bisogno di `throws` nella firma?
- Che differenza c'è tra `IllegalArgumentException` e `IllegalStateException`? Perché `posticipa(45)` lancia la prima e `spegni()` la seconda?
- Provare `new Sveglia(25, 0, "Prova")` fuori da un `try`. Con la soluzione, la prima riga `at` dello stack trace è `at Sveglia.<init>(Sveglia.java:11)`: che cosa sarà `<init>`?

---

### Esercizio 8: Il parcheggio

Creare l'eccezione **checked** `ParcheggioPienoException`, che estende `Exception`. Ha il campo `targa` con il suo getter; il costruttore riceve la targa e passa a `super` il messaggio `Parcheggio pieno, <targa> non può entrare`.

Creare la classe `Parcheggio`, con un array di `String` per i posti (`null` vuol dire posto libero) e il costruttore che riceve il numero di posti. Metodi:
- `postiLiberi()`: conta i posti liberi
- `entra(String targa) throws ParcheggioPienoException`: se la targa è `null` o vuota lancia `IllegalArgumentException` con `Targa mancante`; poi mette la targa nel primo posto libero e stampa `<targa> entra al posto <n>` (i posti si contano da 1); se non c'è posto lancia `ParcheggioPienoException`
- `esci(String targa)`: libera il posto e stampa `<targa> esce dal posto <n>`; se l'auto non c'è lancia `IllegalArgumentException` con `Auto non presente: <targa>`

Nel main, con un parcheggio da 3 posti:
1. Far entrare le quattro auto dell'array. Nel `catch` di `ParcheggioPienoException` stampare `Attesa: <messaggio>` e salvare `e.getTarga()` in una variabile `inAttesa`.
2. Stampare i posti liberi.
3. Far uscire `BB222BB` e far entrare l'auto in attesa.
4. Provare a far uscire `ZZ999ZZ` e stampare `Errore: <messaggio>`.

```java
String[] arrivi = {"AA111AA", "BB222BB", "CC333CC", "DD444DD"};
```

Output atteso:

```
AA111AA entra al posto 1
BB222BB entra al posto 2
CC333CC entra al posto 3
Attesa: Parcheggio pieno, DD444DD non può entrare
Posti liberi: 0
BB222BB esce dal posto 2
DD444DD entra al posto 2
Errore: Auto non presente: ZZ999ZZ
```

Poi togliere il `try`/`catch` attorno a `p.entra(inAttesa)` e leggere l'errore:

```
error: unreported exception ParcheggioPienoException; must be caught or declared to be thrown
```

Perché il compilatore obbliga a gestire il parcheggio pieno, ma non l'auto che non c'è? In quale dei due casi lo sbaglio è di chi usa la classe?

---

### Esercizio 9: Il menu della pizzeria

Il menu di una pizzeria è in un file di testo, una pizza per riga, con il nome e il prezzo in euro separati da `;`. Creare il file `menu.txt` nella cartella dell'esercizio, accanto a `Main.java`, con questo contenuto:

```
Margherita;6
Marinara;5
Diavola;sette
Quattro formaggi;8
Capricciosa;9
```

Scrivere il metodo `static int stampaMenu(String percorso) throws FileNotFoundException`, che:
- apre il file con `Scanner` in un **try-with-resources**: `try (Scanner sc = new Scanner(new File(percorso))) { ... }`
- legge una riga alla volta (`while (sc.hasNextLine())` e `sc.nextLine()`) e la divide con `split(";")`
- converte il prezzo con `Integer.parseInt` e stampa la riga con `String.format("%-18s %2d EUR", nome, prezzo)`
- se il prezzo non è un numero stampa `Riga <n> scartata: <messaggio>` (le righe si contano da 1) e passa alla riga dopo
- restituisce il numero di pizze stampate

`stampaMenu` non gestisce `FileNotFoundException`: la dichiara con `throws` e se ne occupa chi chiama. Nel main, in un solo `try`:
1. stampare il menu di `menu.txt` e poi `Pizze nel menu: <n>`
2. stampare il menu di `bevande.txt`, che non esiste, e poi `Non eseguita`

Nel `catch` stampare `File non trovato: ` seguito da `e.getMessage()`.

Il programma cerca il file nella cartella da cui si lancia `java Main`: eseguirlo dal terminale stando nella cartella dell'esercizio.

Output atteso:

```
Margherita          6 EUR
Marinara            5 EUR
Riga 3 scartata: For input string: "sette"
Quattro formaggi    8 EUR
Capricciosa         9 EUR
Pizze nel menu: 4
File non trovato: bevande.txt (No such file or directory)
```

Su Windows il testo tra parentesi nell'ultima riga è diverso, perché lo scrive il sistema operativo.

Poi rispondere:
- Perché `Non eseguita` non compare?
- In `stampaMenu` non c'è nessun `close()`: quando si chiude lo `Scanner`? Si chiude anche quando il metodo esce con `return`?
- Togliere `throws FileNotFoundException` dalla firma: quale errore si ottiene?

---

## Livello 4 — Logging e progetto

Negli esercizi di questo livello si usa `java.util.logging`. Ogni messaggio del log occupa due righe: la prima ha data, ora, classe e metodo, la seconda il livello e il testo. La data e l'ora cambiano a ogni esecuzione, e il loro formato dipende dalla lingua del computer: negli output attesi vanno confrontate le altre parti. I messaggi del log escono sul canale degli errori: in IntelliJ sono rossi, e a volte l'ordine tra le righe rosse e quelle normali si mescola. Dal terminale l'ordine è quello giusto.

### Esercizio 10: L'irrigatore del giardino

Creare la classe `Irrigatore` con un logger, i campi `zona` (String) e `minutiTotali` (int), il costruttore che riceve la zona e il getter di `minutiTotali`.

```java
private static final Logger logger = Logger.getLogger(Irrigatore.class.getName());
```

Il metodo `avvia(int minuti)`:
- per prima cosa scrive con `logger.fine` il messaggio `Richiesta per <zona>: <minuti> minuti`
- se `minuti` è 0 o meno, scrive con `logger.severe` il messaggio `Durata non valida per <zona>: <minuti> minuti` ed esce dal metodo
- se `minuti` è più di 60, scrive con `logger.warning` il messaggio `Irrigazione lunga per <zona>: <minuti> minuti`, ma l'irrigazione parte lo stesso
- aggiunge i minuti a `minutiTotali` e scrive con `logger.info` il messaggio `Irrigazione <zona> per <minuti> minuti`

Nel main creare l'irrigatore dell'`orto`, avviarlo per 20, 90 e 0 minuti e stampare con `println` i minuti totali.

Output atteso:

```
nov 25, 2026 10:37:29 AM Irrigatore avvia
INFO: Irrigazione orto per 20 minuti
nov 25, 2026 10:37:29 AM Irrigatore avvia
WARNING: Irrigazione lunga per orto: 90 minuti
nov 25, 2026 10:37:29 AM Irrigatore avvia
INFO: Irrigazione orto per 90 minuti
nov 25, 2026 10:37:29 AM Irrigatore avvia
SEVERE: Durata non valida per orto: 0 minuti
Minuti totali: 110
```

Le righe con la data cambiano a ogni esecuzione.

Poi rispondere:
- Perché il messaggio scritto con `logger.fine` non compare?
- Chi ha scritto `Irrigatore avvia` nella prima riga di ogni messaggio?

---

### Esercizio 11: Il robot aspirapolvere

Un robot aspirapolvere esegue un programma di pulizie, una stanza alla volta. La batteria è in percentuale e ogni minuto di pulizia consuma l'1%.

Creare l'eccezione **unchecked** `BatteriaScaricaException`, che estende `RuntimeException`. Il costruttore riceve stanza, minuti e batteria e passa a `super` il messaggio `Batteria al <batteria>%, non basta per <stanza> (<minuti> minuti)`.

Creare la classe `Robot` con un logger, il campo `batteria` (int), il costruttore che la riceve e il getter. Il metodo `pulisci(String stanza, int minuti)`:
- se `minuti` è 0 o meno lancia `IllegalArgumentException` con `Minuti non validi: <minuti>`
- se i minuti sono più della batteria lancia `BatteriaScaricaException`
- altrimenti scala i minuti dalla batteria e scrive con `logger.info` il messaggio `Pulizia <stanza>: <minuti> minuti, batteria al <batteria>%`

Anche il `Main` ha il suo logger. Nel main creare un robot con la batteria al 50% e scorrere il programma. Ogni comando si divide con `split(" ")` in stanza e minuti; poi si convertono i minuti e si chiama `pulisci`, gestendo le eccezioni con tre `catch`, in quest'ordine:
- `NumberFormatException`: `logger.warning` con `Comando ignorato, minuti non numerici: <comando>`
- `IllegalArgumentException`: `logger.warning` con `Comando ignorato: <messaggio>`
- `BatteriaScaricaException`: `logger.log(Level.SEVERE, "Programma interrotto", e)`, poi `break` per fermare il ciclo

Alla fine stampare con `println` la batteria rimasta.

```java
String[] programma = {"cucina 20", "bagno dieci", "ingresso 0", "salotto 25", "camera 15", "studio 10"};
```

Output atteso:

```
nov 25, 2026 10:37:29 AM Robot pulisci
INFO: Pulizia cucina: 20 minuti, batteria al 30%
nov 25, 2026 10:37:29 AM Main main
WARNING: Comando ignorato, minuti non numerici: bagno dieci
nov 25, 2026 10:37:29 AM Main main
WARNING: Comando ignorato: Minuti non validi: 0
nov 25, 2026 10:37:29 AM Robot pulisci
INFO: Pulizia salotto: 25 minuti, batteria al 5%
nov 25, 2026 10:37:29 AM Main main
SEVERE: Programma interrotto
BatteriaScaricaException: Batteria al 5%, non basta per camera (15 minuti)
	at Robot.pulisci(Robot.java:22)
	at Main.main(Main.java:16)

Batteria finale: 5%
```

Le righe con la data cambiano a ogni esecuzione; i numeri di riga dello stack trace sono quelli della soluzione e dipendono da come è scritto il codice.

Poi rispondere:
- `logger.log(Level.SEVERE, ..., e)` scrive anche lo stack trace: che cosa dice in più rispetto a `e.getMessage()`?
- Scambiare i primi due `catch`, mettendo `IllegalArgumentException` prima di `NumberFormatException`. Quale errore dà il compilatore, e perché? (Suggerimento: `NumberFormatException` è una sottoclasse di `IllegalArgumentException`.)
- Perché lo studio non viene pulito?

---

### Esercizio 12: Il centro padel

Un centro padel ha 2 campi, prenotabili a ore dalle 9 alle 21 (l'ultima ora che inizia è quella delle 21). Un'ora costa 20 EUR, 25 EUR dalle 18 in poi. Le richieste arrivano come righe di testo da controllare.

Creare l'eccezione **checked** `CampoOccupatoException`. Il costruttore riceve campo, ora e nome di chi l'ha già prenotato, e passa a `super` il messaggio `Il campo <campo> alle <ora> è già prenotato da <giocatore>`.

Creare la classe `CentroPadel`, con un logger e una matrice `String[][] prenotazioni = new String[campi][24]`: in `prenotazioni[campo - 1][ora]` c'è il nome di chi ha prenotato, `null` se è libero. Metodi:
- un metodo privato `controlla(int campo, int ora)`, usato da `prenota` e `disdici`: se il campo non esiste lancia `IllegalArgumentException` con `Campo inesistente: <campo>`; se l'ora non è tra 9 e 21 lancia `IllegalArgumentException` con `Orario non valido: <ora>`
- `static int prezzo(int ora)`: 20 o 25
- `prenota(int campo, int ora, String giocatore) throws CampoOccupatoException`: chiama `controlla`; se il nome è `null` o vuoto lancia `IllegalArgumentException` con `Nome del giocatore mancante`; se il campo è già prenotato lancia `CampoOccupatoException`; altrimenti salva la prenotazione e scrive con `logger.info` `Campo <campo> alle <ora> prenotato da <giocatore> (<prezzo> EUR)`
- `disdici(int campo, int ora)`: chiama `controlla`; se il campo a quell'ora non è prenotato lancia `IllegalStateException` con `Il campo <campo> alle <ora> non è prenotato`; altrimenti libera il campo e scrive con `logger.info` `Disdetta di <giocatore>: campo <campo> alle <ora> di nuovo libero`
- `stampaPrenotazioni()`: stampa con `println` le prenotazioni, campo per campo e in ordine di ora, con `String.format("  campo %d ore %d  %-6s %d EUR", ...)`, e l'incasso previsto

Nel `Main`, che ha il suo logger, scrivere il metodo `static void esegui(CentroPadel centro, String richiesta) throws CampoOccupatoException`. Divide la richiesta con `split(" ")`:
- `prenota <campo> <ora> <giocatore>` (4 parti): converte campo e ora con `Integer.parseInt` e chiama `prenota`
- `disdici <campo> <ora>` (3 parti): chiama `disdici`
- qualsiasi altra cosa: lancia `IllegalArgumentException` con `Comando sconosciuto: <richiesta>`

Nel main creare un centro con 2 campi ed eseguire tutte le richieste, contando quelle riuscite. Ogni errore si scrive con `logger.warning` e si passa alla richiesta successiva:
- `CampoOccupatoException`: il messaggio dell'eccezione
- `NumberFormatException`: `Numero non valido in "<richiesta>": <messaggio>`
- `IllegalArgumentException` e `IllegalStateException`, in un multi-catch: `Richiesta rifiutata: <messaggio>`

Alla fine stampare con `println` il riepilogo delle richieste e chiamare `stampaPrenotazioni()`.

```java
String[] richieste = {
    "prenota 1 18 Rossi",
    "prenota 2 18 Verdi",
    "prenota 1 18 Neri",
    "prenota 3 10 Gallo",
    "prenota 2 23 Neri",
    "prenota 1 19 Neri",
    "disdici 2 10",
    "prenota 2 diciotto Neri",
    "disdici 2 18",
    "prenota 2 10 Gallo",
    "sposta 1 18 1 20"
};
```

Output atteso:

```
nov 25, 2026 10:37:29 AM CentroPadel prenota
INFO: Campo 1 alle 18 prenotato da Rossi (25 EUR)
nov 25, 2026 10:37:29 AM CentroPadel prenota
INFO: Campo 2 alle 18 prenotato da Verdi (25 EUR)
nov 25, 2026 10:37:29 AM Main main
WARNING: Il campo 1 alle 18 è già prenotato da Rossi
nov 25, 2026 10:37:29 AM Main main
WARNING: Richiesta rifiutata: Campo inesistente: 3
nov 25, 2026 10:37:29 AM Main main
WARNING: Richiesta rifiutata: Orario non valido: 23
nov 25, 2026 10:37:29 AM CentroPadel prenota
INFO: Campo 1 alle 19 prenotato da Neri (25 EUR)
nov 25, 2026 10:37:29 AM Main main
WARNING: Richiesta rifiutata: Il campo 2 alle 10 non è prenotato
nov 25, 2026 10:37:29 AM Main main
WARNING: Numero non valido in "prenota 2 diciotto Neri": For input string: "diciotto"
nov 25, 2026 10:37:29 AM CentroPadel disdici
INFO: Disdetta di Verdi: campo 2 alle 18 di nuovo libero
nov 25, 2026 10:37:29 AM CentroPadel prenota
INFO: Campo 2 alle 10 prenotato da Gallo (20 EUR)
nov 25, 2026 10:37:29 AM Main main
WARNING: Richiesta rifiutata: Comando sconosciuto: sposta 1 18 1 20
Richieste: 11, riuscite: 5, rifiutate: 6
Prenotazioni:
  campo 1 ore 18  Rossi  25 EUR
  campo 1 ore 19  Neri   25 EUR
  campo 2 ore 10  Gallo  20 EUR
Incasso previsto: 70 EUR
```

Le righe con la data cambiano a ogni esecuzione.

Poi rispondere:
- Perché `CampoOccupatoException` è checked, mentre un orario sbagliato è una `IllegalArgumentException`?
- `esegui` non gestisce nessuna eccezione: dove vengono gestite? Perché ha `throws CampoOccupatoException` ma non `throws IllegalArgumentException`?
- Perché i messaggi di successo sono `INFO` e quelli delle richieste rifiutate `WARNING`? In quale caso useresti `SEVERE`?
