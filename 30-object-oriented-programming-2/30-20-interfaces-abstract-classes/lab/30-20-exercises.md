# 30.20 Interfacce e classi astratte — Esercizi di laboratorio

## Livello 1 — Classi astratte

### Esercizio 1: Animale astratto

Creare una classe astratta `Animale` con:
- un campo `nome` (String) e un costruttore che lo inizializza
- un metodo astratto `verso()` che restituisce una String
- un metodo concreto `presenta()` che stampa `Sono <nome> e faccio: <verso>`

Creare le sottoclassi `Cane` e `Gatto` che implementano `verso()`.

Creare un array di `Animale` con due cani e un gatto e chiamare `presenta()` su ciascuno. Provare poi a scrivere `new Animale("Boh")` e leggere l'errore del compilatore.

```java
Animale a = new Cane("Rex");
a.presenta();
// Sono Rex e faccio: Bau!
```

---

### Esercizio 2: Elettrodomestici

Creare una classe astratta `Elettrodomestico` con:
- campi `marca` (String) e `potenzaWatt` (int), un costruttore che li inizializza e i getter
- un metodo astratto `consumoOrario()` che restituisce il consumo in kWh per ogni ora (double)
- un metodo concreto `costoGiornaliero(double prezzoKWh)` che restituisce `consumoOrario() * 24 * prezzoKWh`

Creare le sottoclassi `Lavatrice`, che consuma il 70% della sua potenza, e `Frigorifero`, che ne consuma il 30%. Per passare da watt a kWh si divide per 1000.

Le sottoclassi non hanno campi propri: il costruttore passa tutto a `super(...)`.

```java
Elettrodomestico e = new Lavatrice("Bosch", 2500);
System.out.println(e.consumoOrario());          // 1.75
System.out.println(e.costoGiornaliero(0.25));   // 10.5
```

---

### Esercizio 3: Figure geometriche

Creare una classe astratta `Figura` con:
- due metodi astratti: `area()` (double) e `nome()` (String)
- un metodo concreto `stampaArea()` che stampa `<nome>: area = <area>`

Creare le sottoclassi `Quadrato` (lato), `Rettangolo` (base, altezza) e `Triangolo` (base, altezza).

Creare un array di `Figura` con una figura per tipo e chiamare `stampaArea()` su tutte. Scrivere poi un metodo statico `trovaMassima(Figura[] figure)` che restituisce la figura con l'area più grande.

```java
Figura[] figure = { new Quadrato(4), new Rettangolo(6, 5), new Triangolo(10, 3) };
Figura max = trovaMassima(figure);
System.out.println(max.nome()); // Rettangolo
```

---

## Livello 2 — Interfacce

### Esercizio 4: Oggetti volanti

Definire un'interfaccia `Volante` con i metodi `vola()` e `atterra()`.

Creare tre classi che la implementano, ognuna con un campo proprio e messaggi diversi:
- `Aereo` (compagnia): `L'aereo <compagnia> decolla dalla pista`
- `Uccello` (specie): `Il <specie> sbatte le ali`
- `Drone` (codice): `Il drone <codice> accende le eliche`

Scrivere un metodo statico `faiVolare(Volante[] flotta)` che fa volare e atterrare ogni elemento.

Attenzione: nell'interfaccia i metodi sono `public`, quindi anche le implementazioni devono esserlo.

```java
Volante v = new Drone("DR-01");
v.vola();     // Il drone DR-01 accende le eliche
v.atterra();  // Il drone DR-01 scende in verticale
```

---

### Esercizio 5: Stampare e inviare

Definire due interfacce:
- `Stampabile` con il metodo `stampa()`
- `Inviabile` con il metodo `invia(String destinatario)`

Creare le classi:
- `Fattura` (numero, importo), che implementa **entrambe** le interfacce
- `Foto` (nomeFile), che implementa solo `Stampabile`
- `Messaggio` (testo), che implementa solo `Inviabile`

Scrivere due metodi statici, `stampaTutti(Stampabile[] elenco)` e `inviaTutti(Inviabile[] elenco, String destinatario)`. Nel main mettere **la stessa fattura** in tutti e due gli array.

```java
Fattura fattura = new Fattura(42, 150.0);
Stampabile[] daStampare = { fattura, new Foto("vacanze.jpg") };
Inviabile[] daInviare = { fattura, new Messaggio("Ci vediamo alle 9") };
```

---

### Esercizio 6: Log con metodi default e static

Definire un'interfaccia `Loggabile` con:
- una costante `PREFISSO` uguale a `"[LOG] "`
- un metodo astratto `getInfo()` che restituisce una String
- un metodo default `log()` che stampa `PREFISSO + getInfo()`
- un metodo static `logTutti(Loggabile[] elementi)` che chiama `log()` su ogni elemento

Creare le classi `Utente` (nome, email) e `Ordine` (codice, importo), che implementano solo `getInfo()`, ed `Errore` (messaggio), che ridefinisce anche `log()` per evidenziare la riga.

```java
Loggabile[] eventi = {
    new Utente("Anna", "anna@email.it"),
    new Ordine("A12", 49.9),
    new Errore("pagamento rifiutato")
};
Loggabile.logTutti(eventi);
// [LOG] Utente Anna <anna@email.it>
// [LOG] Ordine A12: 49.9 EUR
// [LOG] !!! Errore: pagamento rifiutato !!!
```

---

## Livello 3 — Classi astratte e interfacce insieme

### Esercizio 7: Parco veicoli

Creare:
- una classe astratta `Veicolo` con campi `targa` (String) e `kmPercorsi` (int), un metodo astratto `consumo()` (litri ogni 100 km) e un metodo concreto `litriConsumati()` che restituisce `kmPercorsi * consumo() / 100`
- un'interfaccia `Elettrico` con il metodo `autonomia()`, che restituisce i km percorribili (int)
- `Auto extends Veicolo`, consumo 6.5
- `Moto extends Veicolo`, consumo 4.0
- `AutoElettrica extends Veicolo implements Elettrico`, consumo 0, con un campo `batteriaKWh` (int): l'autonomia è 6 km per ogni kWh

Creare un array di `Veicolo`, stampare consumo e litri di ciascuno e, con `instanceof`, stampare l'autonomia dei soli veicoli elettrici. Alla fine stampare quanti sono.

```java
Veicolo v = new AutoElettrica("IL789MN", 300, 60);
if (v instanceof Elettrico e) {
    System.out.println(e.autonomia()); // 360
}
```

---

### Esercizio 8: Classifica con Comparable

Creare una classe `Studente` con campi `nome` (String) e `voto` (int) e un `toString()` nel formato `Anna (9)`.

`Studente` implementa `Comparable<Studente>`. Il metodo `compareTo(Studente altro)` mette prima il voto più alto; a parità di voto, ordina per nome in ordine alfabetico (le stringhe hanno già il loro `compareTo`).

Nel main creare un array di 5 studenti, ordinarlo con `Arrays.sort` e stampare la classifica numerata.

```java
Studente[] classe = {
    new Studente("Marco", 7), new Studente("Anna", 9), new Studente("Luca", 6),
    new Studente("Giulia", 9), new Studente("Paolo", 7)
};
Arrays.sort(classe);
// 1. Anna (9)
// 2. Giulia (9)
// 3. Marco (7)
// ...
```

---

### Esercizio 9: Coda di stampa

Definire un'interfaccia `Stampabile` con il metodo `stampa()`.

Creare una classe astratta `Documento` che implementa `Stampabile` **senza** implementare `stampa()`. Ha i campi `titolo` e `autore` e un metodo concreto `intestazione()` che restituisce `<titolo> di <autore>`.

Creare:
- `Report` (extends `Documento`) con il campo `pagine`: stampa `Report: <intestazione>, <pagine> pagine`
- `Lettera` (extends `Documento`) con il campo `destinatario`: stampa `Lettera: <intestazione>, per <destinatario>`
- `Etichetta`, che **non** è un documento ma implementa direttamente `Stampabile`: stampa `Etichetta: [<testo>]`

Scrivere un metodo statico `stampaElenco(Stampabile[] elenco)` che stampa ogni elemento seguito da `---`. Contare poi con `instanceof` quanti elementi della coda sono documenti.

---

## Livello 4 — Progetto

### Esercizio 10: Pagamenti con sealed

Creare una classe astratta **sealed** `Pagamento` che permette solo le sottoclassi `Contanti`, `Carta` e `Bonifico`. Ha:
- un campo `importo` (double), costruttore e getter
- due metodi astratti: `tipo()` (String) e `commissione()` (double)
- un metodo concreto `totale()` che restituisce importo + commissione
- un `toString()` nel formato `<tipo>: <importo> + <commissione> = <totale> EUR`

Le tre sottoclassi sono `final`:
- `Contanti`: nessuna commissione
- `Carta` (campo `circuito`): commissione del 2% dell'importo, tipo `Carta <circuito>`
- `Bonifico`: commissione fissa di 1.5 EUR

Nel main stampare un pagamento per tipo, il totale incassato e il totale delle commissioni. Provare poi a creare una classe `Assegno extends Pagamento` e leggere l'errore del compilatore.

```java
Pagamento p = new Carta(50.0, "Visa");
System.out.println(p); // Carta Visa: 50.0 + 1.0 = 51.0 EUR
```

---

### Esercizio 11: Pila con due implementazioni

Una pila (stack) è una struttura in cui l'ultimo elemento inserito è il primo a uscire.

Definire un'interfaccia `Pila` per stringhe con i metodi:
- `boolean push(String elemento)`: mette l'elemento in cima; restituisce `false` se non c'è posto
- `String pop()`: toglie e restituisce l'elemento in cima; restituisce `null` se la pila è vuota
- `boolean vuota()`
- `int dimensione()`

Creare due classi che la implementano usando un array interno (composizione: la pila **ha** un array, non **è** un array):
- `PilaFissa(int capienza)`: quando è piena rifiuta gli elementi
- `PilaEstendibile(int capienzaIniziale)`: quando è piena crea un array grande il doppio, ci copia gli elementi e continua

Scrivere un metodo statico `prova(Pila p)` che inserisce le lettere da `A` a `E`, segnala quelle rifiutate, stampa la dimensione e poi svuota la pila stampando gli elementi estratti. Chiamarlo su tutte e due le pile: cambia solo il `new`.

```java
Pila p1 = new PilaFissa(3);
Pila p2 = new PilaEstendibile(3);
prova(p1); // accetta A, B, C; estrae C B A
prova(p2); // accetta tutto; estrae E D C B A
```

---

### Esercizio 12: Gestore prenotazioni del ristorante

Un ristorante ha `m` posti all'interno e `n` all'esterno e riceve due tipi di prenotazione.

Definire un'interfaccia `Sala` con due costanti String, `INTERNO` ed `ESTERNO` (gli enum li vedremo più avanti).

Creare una classe astratta `Prenotazione` con un campo `codice` (String), un metodo astratto `getNumeroPosti()` e un `toString()` nel formato `<codice>, posti: <n>`. Le sottoclassi:
- `PrenotazioneSingola`: ha una `preferenza` (`Sala.INTERNO` o `Sala.ESTERNO`) e occupa 1 posto
- `PrenotazioneGruppo`: ha il campo `numeroPosti`

Creare la classe `GestorePrenotazioni`, costruita con i posti interni e quelli esterni, che tiene le prenotazioni di ciascuna sala in un array. Metodi:
- `prenota(Prenotazione p)`: accetta la prenotazione se c'è posto e restituisce `true`, altrimenti `false`. Una singola va prima nella sala che preferisce, poi nell'altra; un gruppo va prima all'interno, poi all'esterno. Un gruppo non si divide tra le due sale.
- `terminaPrenotazione(Prenotazione p)`: toglie la prenotazione e libera i posti; restituisce `false` se non la trova
- `prenotazioniInterno()` e `prenotazioniEsterno()`: restituiscono un array, della misura giusta, con le prenotazioni di quella sala
- `getLiberiInterno()` e `getLiberiEsterno()`

```java
GestorePrenotazioni gestore = new GestorePrenotazioni(3, 5);
gestore.prenota(new PrenotazioneSingola("S1", Sala.ESTERNO));   // true, esterno
gestore.prenota(new PrenotazioneSingola("S2", Sala.ESTERNO));   // true, esterno
gestore.prenota(new PrenotazioneSingola("S3", Sala.INTERNO));   // true, interno
gestore.prenota(new PrenotazioneGruppo("G1", 2));               // true, interno
gestore.prenota(new PrenotazioneGruppo("G2", 4));               // false: non c'è una sala con 4 posti liberi
```
