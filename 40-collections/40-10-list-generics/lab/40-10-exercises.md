# 40.10 List e generics — Esercizi di laboratorio

Per tutti gli esercizi: si dichiara l'interfaccia e si crea l'implementazione, `List<String> x = new ArrayList<>();`. Gli import servono: `java.util.List`, `java.util.ArrayList` e, quando si usano, `java.util.Collections` e `java.util.Iterator`.

## Livello 1 — Le prime liste

### Esercizio 1: Scaletta del concerto

Nel main creare una `List<String>` vuota, `scaletta`, e poi:
1. aggiungere in coda `Azzurro`, `Volare`, `Albachiara`, `Vita spericolata` e stampare la lista con `println`
2. inserire `Intro` in prima posizione con `add(0, ...)`
3. trovare con `indexOf` la posizione di `Volare` e sostituirlo con `Il cielo in una stanza` usando `set`
4. togliere `Albachiara` con `remove("Albachiara")` e stampare il valore restituito (un `boolean`)
5. togliere l'ultimo brano con `remove(scaletta.size() - 1)` e stampare il valore restituito (il brano tolto)
6. stampare il numero di brani e la scaletta numerata con un `for` classico (`size()` e `get(i)`)
7. controllare con `contains` se c'è ancora `Volare`
8. svuotare la lista con `clear()` e stampare la lista e `isEmpty()`

Output atteso:

```
Scaletta: [Azzurro, Volare, Albachiara, Vita spericolata]
Con l'intro: [Intro, Azzurro, Volare, Albachiara, Vita spericolata]
Volare era alla posizione 2, ora c'è Il cielo in una stanza
Tolta Albachiara? true
Tolta l'ultima: Vita spericolata
Brani: 3
1. Intro
2. Azzurro
3. Il cielo in una stanza
Contiene Volare? false
Dopo clear: [], vuota? true
```

Perché `Volare` è alla posizione 2 e non alla 1?

---

### Esercizio 2: Temperature della settimana

Creare una `List<Integer>` con le temperature massime della settimana, aggiunte una per volta con `add`, e un array con i nomi dei giorni:

```java
String[] giorni = { "lun", "mar", "mer", "gio", "ven", "sab", "dom" };
// temperature: 12, 15, 18, 21, 17, 14, 15
```

Poi:
- stampare giorno e temperatura con un `for` classico
- con un for-each (`for (int t : temperature)`) calcolare somma, massimo e minimo
- calcolare la media come `double` e stamparla
- trovare con `indexOf` il giorno più caldo e il più freddo
- contare i giorni sopra la media

Output atteso:

```
lun 12°
mar 15°
mer 18°
gio 21°
ven 17°
sab 14°
dom 15°
Media: 16.0°
Più caldo: gio (21°)
Più freddo: lun (12°)
Giorni sopra la media: 3
```

Perché si scrive `List<Integer>` e non `List<int>`? Che cosa fa Java quando si scrive `temperature.add(12)` e quando si scrive `int t : temperature`?

---

### Esercizio 3: Lista degli invitati

Scrivere un programma che legge con `Scanner` i nomi degli invitati a una festa, uno per riga, finché non si scrive `fine` (maiuscole o minuscole).
- Un nome vuoto non si aggiunge: si stampa `Nome vuoto, riprova`.
- Un nome già presente non si aggiunge una seconda volta: si stampa `<nome> è già in lista` (`contains`).

Alla fine:
- se la lista è vuota (`isEmpty`) si stampa `Nessun invitato`
- altrimenti si stampano numero e nomi, si chiede chi non viene e lo si toglie con `remove(nome)`. Il metodo restituisce `true` se il nome c'era: usarlo per scegliere il messaggio.

Esempio di esecuzione:

```
Nome (fine per terminare): Giulia
Nome (fine per terminare): Marco
Nome (fine per terminare): Giulia
Giulia è già in lista
Nome (fine per terminare): Sofia
Nome (fine per terminare): fine
Invitati (3): [Giulia, Marco, Sofia]
Chi non viene? Marco
Marco tolto: [Giulia, Sofia]
```

Se chi non viene non è in lista:

```
Chi non viene? Luca
Luca non era in lista
```

Se si scrive subito `fine`:

```
Nome (fine per terminare): fine
Nessun invitato
```

---

## Livello 2 — Wrapper, List.of e i metodi di Java 21

### Esercizio 4: Tombola

I numeri estratti sono in un array: copiarli uno per uno in una `List<Integer>`.

```java
int[] uscite = { 27, 3, 90, 1, 45, 3, 12 };
```

Il 3 è stato chiamato due volte per sbaglio. Prima di correggere, una prova su due copie della lista (`new ArrayList<>(estratti)`):
- sulla prima chiamare `remove(1)`
- sulla seconda chiamare `remove(Integer.valueOf(1))`

Stampare le due copie e spiegare la differenza.

Poi:
- creare una nuova lista `unici` senza doppioni: si aggiunge un numero solo se non è già presente (`contains`)
- ordinarla con `Collections.sort` e stamparla
- invertirla con `Collections.reverse` e stamparla
- controllare se è uscito il 90 e calcolare la somma dei numeri

Output atteso:

```
Estratti: [27, 3, 90, 1, 45, 3, 12]
remove(1): [27, 90, 1, 45, 3, 12]
remove(Integer.valueOf(1)): [27, 3, 90, 45, 3, 12]
Senza doppioni: [27, 3, 90, 1, 45, 12]
In ordine: [1, 3, 12, 27, 45, 90]
Dal più alto: [90, 45, 27, 12, 3, 1]
È uscito il 90? true
Somma: 178
```

---

### Esercizio 5: Linea dell'autobus

Le fermate della linea sono fisse:

```java
List<String> fermate = List.of("Stazione", "Duomo", "Ospedale", "Università");
```

1. Stampare `fermate`, poi provare `fermate.add("Stadio")` e leggere l'errore. La prima riga è:
   ```
   Exception in thread "main" java.lang.UnsupportedOperationException
   ```
   Commentare la riga e andare avanti.
2. Creare una copia modificabile: `List<String> linea = new ArrayList<>(fermate);`
3. Con i metodi di Java 21 aggiungere `Deposito` all'inizio (`addFirst`) e `Stadio` alla fine (`addLast`), poi stampare i due capolinea con `getFirst` e `getLast`.
4. Scrivere un metodo statico `stampaPercorso(String titolo, List<String> percorso)` che stampa le fermate separate da ` > `. Usarlo per l'andata (`linea`) e per il ritorno (`linea.reversed()`), poi stampare `linea` per vedere che `reversed()` non l'ha cambiata.
5. La sera il bus non parte dal deposito e non arriva allo stadio: togliere la prima fermata con `removeFirst` e l'ultima con `removeLast`, stampando la fermata tolta.
6. Stampare di nuovo `fermate`.

Output atteso:

```
Fermate: [Stazione, Duomo, Ospedale, Università]
Linea: [Deposito, Stazione, Duomo, Ospedale, Università, Stadio]
Capolinea: Deposito e Stadio
Andata:  Deposito > Stazione > Duomo > Ospedale > Università > Stadio
Ritorno: Stadio > Università > Ospedale > Duomo > Stazione > Deposito
Linea dopo reversed(): [Deposito, Stazione, Duomo, Ospedale, Università, Stadio]
Senza il deposito: [Stazione, Duomo, Ospedale, Università, Stadio]
Tolta l'ultima: Stadio
Linea serale: [Stazione, Duomo, Ospedale, Università]
Fermate di List.of: [Stazione, Duomo, Ospedale, Università]
```

Perché le modifiche a `linea` non toccano `fermate`?

---

### Esercizio 6: Trova l'errore

Ogni frammento sta dentro un `main`, con gli import di `List`, `ArrayList` e `Iterator`. Per ogni frammento dire:
- se **non compila** (errore del compilatore), se **compila ma si ferma** a runtime (eccezione) oppure se **funziona ma fa un'altra cosa**
- perché
- come si corregge

**Frammento 1**
```java
List<int> punti = new ArrayList<>();
punti.add(10);
```

**Frammento 2**
```java
List<String> citta = new List<>();
citta.add("Bari");
```

**Frammento 3**
```java
List<String> colori = new ArrayList<>();
colori.add(7);
```

**Frammento 4**
```java
List<String> semaforo = new ArrayList<>(List.of("rosso", "giallo", "verde"));
for (int i = 0; i <= semaforo.size(); i++) {
    System.out.println(semaforo.get(i));
}
```

**Frammento 5**
```java
List lista = new ArrayList();
lista.add("rosso");
lista.add(3);
String s = (String) lista.get(1);
System.out.println(s);
```

**Frammento 6** (togliere i colori che iniziano per `v`)
```java
List<String> tinte = new ArrayList<>(List.of("rosso", "verde", "blu", "viola"));
for (String t : tinte) {
    if (t.startsWith("v")) {
        tinte.remove(t);
    }
}
```

**Frammento 7** (togliere il numero 1)
```java
List<Integer> numeri = new ArrayList<>(List.of(1, 5, 8));
numeri.remove(1);
System.out.println(numeri);
```

Dopo aver risposto, verificare ogni frammento. La prima riga dei messaggi che si ottengono è una di queste:

```
error: unexpected type
error: List is abstract; cannot be instantiated
error: incompatible types: int cannot be converted to String
Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 3 out of bounds for length 3
Exception in thread "main" java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String (java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')
Exception in thread "main" java.util.ConcurrentModificationException
```

Uno dei frammenti compila con un avviso:

```
Note: Main.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
```

Quale? Che cosa vuol dire?

---

## Livello 3 — Generics

### Esercizio 7: Armadietto generico

Creare la classe generica `Armadietto<T>`, che contiene al massimo un oggetto di tipo `T`:
- campi `numero` (int) e `contenuto` (T, `null` quando è vuoto)
- costruttore con il numero, getter `getNumero()`
- `isVuoto()`
- `deposita(T oggetto)`: se l'armadietto è occupato restituisce `false`, altrimenti mette l'oggetto e restituisce `true`
- `ritira()`: restituisce il contenuto e svuota l'armadietto
- `toString()`: `Armadietto <numero>: vuoto` oppure `Armadietto <numero>: <contenuto>`

Creare anche la classe `Valigia` (colore, kg) con `getKg()` e `toString()` nel formato `valigia <colore> da <kg> kg`.

Nel main:
- usare un `Armadietto<String>` numero 12: depositare `giacca`, provare a depositare `casco`, ritirare. Il valore ritirato è già una `String`: stamparne la lunghezza senza nessun cast.
- usare un `Armadietto<Valigia>` numero 7 con una valigia blu da 18 kg

Output atteso:

```
Armadietto 12: vuoto
Armadietto 12: giacca
Armadietto 12 occupato: casco non depositato
Ritirato: giacca (6 lettere)
Armadietto 12: vuoto
---
Armadietto 7: valigia blu da 18 kg
Ritirata: valigia blu da 18 kg, peso 18
Armadietto 7: vuoto
```

Infine provare a mettere una valigia nell'armadietto delle stringhe, `a12.deposita(new Valigia("rossa", 10));`, e leggere l'errore:

```
error: incompatible types: Valigia cannot be converted to String
```

Che cosa sarebbe successo se `contenuto` fosse stato un `Object`?

---

### Esercizio 8: Pila generica

Una pila è una struttura in cui l'ultimo elemento entrato è il primo a uscire, come una pila di piatti. Creare la classe generica `Pila<T>` che tiene gli elementi in una `List<T>`; la cima della pila è l'ultimo elemento della lista. Metodi:
- `push(T elemento)`: mette l'elemento in cima (`addLast`)
- `pop()`: toglie e restituisce l'elemento in cima (`removeLast`); se la pila è vuota restituisce `null`
- `cima()`: restituisce l'elemento in cima senza toglierlo (`getLast`); se la pila è vuota restituisce `null`
- `isEmpty()` e `size()`
- `toString()`: `fondo <lista> cima`

Nel main usare la pila in due modi.

1. Il tasto Annulla di un editor: una `Pila<String>` con le azioni `scrivi "Ciao"`, `grassetto`, `colore rosso`. Scrivere un metodo statico `annulla(Pila<String> azioni)` che toglie l'ultima azione e la stampa, oppure stampa `Niente da annullare`.
2. Il controllo delle parentesi: un metodo statico `bilanciata(String testo)` che usa una `Pila<Character>`. Ogni parentesi aperta (`(`, `[`, `{`) va in pila; ogni parentesi chiusa deve corrispondere a quella in cima, che si toglie. Il testo è bilanciato se alla fine la pila è vuota.

```java
String[] espressioni = { "(a + b) * [c - d]", "{[()]}", "(a + b]", "((x)", "x)(" };
```

Output atteso:

```
fondo [scrivi "Ciao", grassetto, colore rosso] cima, 3 azioni
Annullo: colore rosso
Annullo: grassetto
fondo [scrivi "Ciao"] cima
Prossima da annullare: scrivi "Ciao"
Annullo: scrivi "Ciao"
Niente da annullare
---
(a + b) * [c - d] bilanciata
{[()]} bilanciata
(a + b] non bilanciata
((x) non bilanciata
x)( non bilanciata
```

Perché si scrive `Pila<Character>` e non `Pila<char>`?

---

### Esercizio 9: Metodi generici

Scrivere nel `Main` quattro metodi statici generici, che funzionano con liste di qualsiasi tipo:
- `static <T> void stampaNumerata(List<T> lista)`: stampa gli elementi numerati da 1
- `static <T> int conta(List<T> lista, T cercato)`: quante volte compare `cercato` (con `equals`)
- `static <T> List<T> senzaDoppioni(List<T> lista)`: restituisce una lista nuova senza doppioni, nell'ordine in cui compaiono
- `static <T> T piuFrequente(List<T> lista)`: l'elemento che compare più volte; a parità vince il primo (usare `conta`)

Provarli con due liste diverse:

```java
List<Integer> dadi = List.of(3, 6, 2, 6, 1, 6, 3);
List<String> risposte = List.of("sì", "no", "sì", "forse", "sì", "no");
```

Output atteso:

```
1. 3
2. 6
3. 2
4. 6
5. 1
6. 6
7. 3
Il 6 è uscito 3 volte
Senza doppioni: [3, 6, 2, 1]
Più frequente: 6
---
1. sì
2. no
3. sì
4. forse
5. sì
6. no
"no" compare 2 volte
Senza doppioni: [sì, no, forse]
Più frequente: sì
```

`dadi` e `risposte` sono create con `List.of`: perché `senzaDoppioni` funziona lo stesso?

---

## Livello 4 — Liste di oggetti

### Esercizio 10: Vivaio

Creare la classe `Pianta` con `nome` (String), `prezzo` (int, in euro) e `quantita` (int), costruttore, getter e `toString()` nel formato `<nome> x<quantita> (<prezzo> EUR)`.

```java
List<Pianta> piante = new ArrayList<>();
piante.add(new Pianta("Basilico", 3, 12));
piante.add(new Pianta("Lavanda", 6, 0));
piante.add(new Pianta("Rosmarino", 4, 5));
piante.add(new Pianta("Ortensia", 15, 0));
piante.add(new Pianta("Limone", 25, 2));
piante.add(new Pianta("Geranio", 5, 0));
```

Scrivere nel `Main` i metodi statici:
- `cerca(List<Pianta> piante, String nome)`: restituisce la pianta (senza badare a maiuscole e minuscole) oppure `null`
- `valore(List<Pianta> piante)`: la somma di prezzo per quantità
- `esaurite(List<Pianta> piante)`: restituisce una **nuova** lista con le piante a quantità 0

Nel main stampare le piante, cercare `Rosmarino` e `Menta`, stampare il valore e le piante da riordinare.

Poi togliere dal vivaio le piante esaurite. Prima provare con un for-each e `piante.remove(p)`, e leggere l'errore:

```
Exception in thread "main" java.util.ConcurrentModificationException
```

Poi fare una copia della lista (`new ArrayList<>(piante)`) e togliere le esaurite in due modi:
- da `piante` con un `Iterator` (`hasNext`, `next`, `remove`), contando quante se ne tolgono
- dalla copia con un `for` con indice che va all'indietro, da `size() - 1` a 0

Output atteso:

```
Piante in vivaio:
  Basilico x12 (3 EUR)
  Lavanda x0 (6 EUR)
  Rosmarino x5 (4 EUR)
  Ortensia x0 (15 EUR)
  Limone x2 (25 EUR)
  Geranio x0 (5 EUR)
Rosmarino: Rosmarino x5 (4 EUR)
Menta: non trovata
Valore della merce: 106 EUR
Da riordinare: [Lavanda x0 (6 EUR), Ortensia x0 (15 EUR), Geranio x0 (5 EUR)]
Con l'Iterator: tolte 3, restano [Basilico x12 (3 EUR), Rosmarino x5 (4 EUR), Limone x2 (25 EUR)]
All'indietro: restano [Basilico x12 (3 EUR), Rosmarino x5 (4 EUR), Limone x2 (25 EUR)]
```

Perché all'indietro funziona e in avanti, con `remove(i)`, si rischia di saltare un elemento?

---

### Esercizio 11: Parco divertimenti

Creare la classe astratta `Attrazione` con:
- campi `nome` (String) e `gettoni` (int), costruttore e getter
- i metodi astratti `adatta(int altezzaCm)` (boolean) e `descrizione()` (String)
- `toString()` che restituisce il nome

Le sottoclassi:
- `Giostra`: adatta a tutti; descrizione `giostra per tutti`
- `Ottovolante` (campo `altezzaMinima`, con getter): adatta da `altezzaMinima` in su; descrizione `ottovolante, da <altezzaMinima> cm`
- `Autoscontro`: si guida da 130 cm (costante `ALTEZZA_GUIDA`); descrizione `autoscontro, si guida da 130 cm`

```java
List<Attrazione> parco = new ArrayList<>();
parco.add(new Giostra("Cavalli", 2));
parco.add(new Ottovolante("Drago", 5, 140));
parco.add(new Autoscontro("Scontri", 3));
parco.add(new Ottovolante("Bruco", 3, 100));
parco.add(new Giostra("Tazze", 2));
parco.add(new Ottovolante("Tornado", 6, 150));
```

Scrivere nel `Main` i metodi statici:
- `adatte(List<Attrazione> parco, int altezzaCm)`: una nuova lista con le attrazioni adatte a quell'altezza
- `gettoniTotali(List<Attrazione> giro)`: i gettoni che servono per fare tutto il giro
- `soloOttovolanti(List<Attrazione> parco)`: una `List<Ottovolante>` con i soli ottovolanti (pattern matching con `instanceof`)

Nel main stampare il parco con `String.format("  %-8s %d gettoni  %s", ...)`, le attrazioni e i gettoni per un bambino di 110 cm e per un ragazzo di 145 cm, gli ottovolanti e quello con l'altezza minima più alta.

Output atteso:

```
Parco:
  Cavalli  2 gettoni  giostra per tutti
  Drago    5 gettoni  ottovolante, da 140 cm
  Scontri  3 gettoni  autoscontro, si guida da 130 cm
  Bruco    3 gettoni  ottovolante, da 100 cm
  Tazze    2 gettoni  giostra per tutti
  Tornado  6 gettoni  ottovolante, da 150 cm
Per 110 cm: [Cavalli, Bruco, Tazze], 7 gettoni
Per 145 cm: [Cavalli, Drago, Scontri, Bruco, Tazze], 15 gettoni
Ottovolanti: [Drago, Bruco, Tornado]
Il più impegnativo: Tornado (150 cm)
```

Per trovare il più impegnativo si può usare `getAltezzaMinima()` sugli elementi di `soloOttovolanti(parco)`, ma non sugli elementi di `parco`: perché?

---

### Esercizio 12: Agenda dei compiti

Creare la classe `Compito` con `materia`, `descrizione`, `giorni` (giorni alla consegna) e `fatto` (boolean, all'inizio `false`), costruttore con i primi tre campi, getter, `isFatto()` e `segnaFatto()`. Il `toString()` usa `String.format("[%s] %-12s %-22s %s", ...)`: nella prima parentesi `x` se il compito è fatto, uno spazio se no; in fondo `per domani` se manca un giorno, altrimenti `tra <giorni> giorni`.

Creare la classe `AgendaCompiti`, che tiene i compiti in una `List<Compito>` privata. Metodi:
- `aggiungi(Compito c)`
- `segnaFatto(String descrizione)`: segna fatto il compito con quella descrizione; restituisce `false` se non c'è
- `daFare()`: una nuova lista con i compiti non fatti
- `perMateria(String materia)`: una nuova lista con i compiti di quella materia
- `piuUrgente()`: il compito non fatto con meno giorni alla consegna, `null` se non c'è niente da fare
- `rimuoviFatti()`: toglie i compiti fatti con un `Iterator` e restituisce quanti ne ha tolti
- `stampa()`: stampa `Agenda (<numero>):` e i compiti, oppure `  nessun compito`

```java
AgendaCompiti agenda = new AgendaCompiti();
agenda.aggiungi(new Compito("Matematica", "esercizi pag. 52", 2));
agenda.aggiungi(new Compito("Storia", "riassunto cap. 4", 5));
agenda.aggiungi(new Compito("Informatica", "lab sulle liste", 1));
agenda.aggiungi(new Compito("Matematica", "ripasso equazioni", 6));
agenda.aggiungi(new Compito("Inglese", "tema sulle vacanze", 3));
```

Nel main stampare l'agenda, segnare fatti `lab sulle liste`, `riassunto cap. 4` e `ricerca di scienze` (che non c'è), ristampare, poi stampare quanti compiti restano da fare, i compiti di matematica e il più urgente. Infine togliere i compiti fatti e stampare l'agenda.

Output atteso:

```
Agenda (5):
  [ ] Matematica   esercizi pag. 52       tra 2 giorni
  [ ] Storia       riassunto cap. 4       tra 5 giorni
  [ ] Informatica  lab sulle liste        per domani
  [ ] Matematica   ripasso equazioni      tra 6 giorni
  [ ] Inglese      tema sulle vacanze     tra 3 giorni
---
Non trovato: ricerca di scienze
Agenda (5):
  [ ] Matematica   esercizi pag. 52       tra 2 giorni
  [x] Storia       riassunto cap. 4       tra 5 giorni
  [x] Informatica  lab sulle liste        per domani
  [ ] Matematica   ripasso equazioni      tra 6 giorni
  [ ] Inglese      tema sulle vacanze     tra 3 giorni
---
Da fare: 3
Matematica:
  [ ] Matematica   esercizi pag. 52       tra 2 giorni
  [ ] Matematica   ripasso equazioni      tra 6 giorni
Più urgente: esercizi pag. 52
---
Tolti i compiti fatti: 2
Agenda (3):
  [ ] Matematica   esercizi pag. 52       tra 2 giorni
  [ ] Matematica   ripasso equazioni      tra 6 giorni
  [ ] Inglese      tema sulle vacanze     tra 3 giorni
```

Il compito `lab sulle liste` ha meno giorni di tutti: perché non è il più urgente?
