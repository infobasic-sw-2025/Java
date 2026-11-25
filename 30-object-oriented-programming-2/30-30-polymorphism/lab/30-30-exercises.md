# 30.30 Polimorfismo — Esercizi di laboratorio

## Livello 1 — Polimorfismo

### Esercizio 1: Strumenti musicali

Creare una classe astratta `Strumento` con:
- un campo `nome` (String), un costruttore che lo inizializza e il getter
- un metodo astratto `suona()` che restituisce una String

Creare le sottoclassi `Chitarra`, `Pianoforte` e `Batteria`. Il costruttore passa il nome a `super(...)`: `new Pianoforte()` si chiama `Pianoforte`. La chitarra ha anche un campo `corde` (int), che si vede nel suono.

Nel main:
- assegnare una `Chitarra` a una variabile di tipo `Strumento` e chiamare `suona()`
- scrivere un metodo statico `provaStrumento(Strumento s)` che stampa `<nome>: <suono>`
- creare un array di `Strumento` e chiamare `provaStrumento` su ciascuno

Aggiungere infine la classe `Violino` e metterla nell'array: `provaStrumento` e il ciclo non vanno toccati.

```java
Strumento s = new Chitarra(6);
System.out.println(s.suona()); // Dlen dlen (6 corde)
```

Output atteso:

```
Dlen dlen (6 corde)
---
Chitarra: Dlen dlen (12 corde)
Pianoforte: Plin plon
Batteria: Tum tum tss!
Violino: Iii iii
```

---

### Esercizio 2: Buste paga

Creare una classe astratta `Dipendente` con:
- campi `nome` (String) e `stipendioBase` (double), costruttore e getter
- due metodi astratti: `ruolo()` (String) e `calcolaStipendio()` (double)

Creare le sottoclassi:
- `Manager`: stipendio base più un bonus fisso di 500 EUR
- `Programmatore` (campo `oreStraordinario`): stipendio base più 25 EUR per ogni ora di straordinario
- `Stagista`: solo lo stipendio base

Scrivere due metodi statici:
- `stampaBusta(Dipendente d)`, che stampa nome, ruolo e stipendio con `String.format("%-6s %-14s %8.2f EUR", ...)`
- `totaleStipendi(Dipendente[] personale)`, che restituisce la somma degli stipendi

Nessuno dei due metodi sa quale dipendente ha davanti: il calcolo giusto lo sceglie Java a runtime.

```java
Dipendente[] personale = {
    new Manager("Laura", 2800),
    new Programmatore("Marco", 2000, 10),
    new Programmatore("Sara", 2100, 0),
    new Stagista("Luca", 800)
};
```

Output atteso:

```
Laura  Manager         3300,00 EUR
Marco  Programmatore   2250,00 EUR
Sara   Programmatore   2100,00 EUR
Luca   Stagista         800,00 EUR
Totale stipendi: 8450,00 EUR
```

Con `String.format` i decimali escono con la virgola, perché il computer è impostato in italiano.

---

### Esercizio 3: Biglietti del cinema e @Override

Creare una classe **concreta** `Biglietto` con:
- campi `film` (String) e `prezzoBase` (double), costruttore e getter
- un metodo `tipo()` che restituisce `"Intero"`
- un metodo `prezzo()` che restituisce `prezzoBase`
- un metodo `stampa()` che stampa una riga con `String.format("%-8s %-10s %5.2f EUR", film, tipo(), prezzo())`

Creare le sottoclassi, che ridefiniscono `tipo()` e `prezzo()`:
- `BigliettoRidotto`: tipo `Ridotto`, costa il 70% del prezzo base
- `BigliettoStudente`: tipo `Studente`, costa 2 EUR in meno

Nel main creare un array con quattro biglietti, stamparli e calcolare l'incasso.

```java
Biglietto[] venduti = {
    new Biglietto("Dune", 9.0),
    new BigliettoRidotto("Dune", 9.0),
    new BigliettoStudente("Dune", 9.0),
    new BigliettoRidotto("Wicked", 8.0)
};
```

Output atteso:

```
Dune     Intero      9,00 EUR
Dune     Ridotto     6,30 EUR
Dune     Studente    7,00 EUR
Wicked   Ridotto     5,60 EUR
Incasso: 27,90 EUR
```

Poi fare una prova: in `BigliettoRidotto` togliere `@Override` e rinominare il metodo in `Prezzo()`, con la P maiuscola. Il programma compila, ma i ridotti costano come gli interi:

```
Dune     Intero      9,00 EUR
Dune     Ridotto     9,00 EUR
Dune     Studente    7,00 EUR
Wicked   Ridotto     8,00 EUR
Incasso: 33,00 EUR
```

Rimettere `@Override` sopra `Prezzo()` e leggere l'errore del compilatore:

```
error: method does not override or implement a method from a supertype
```

Spiegare perché, poi correggere.

---

## Livello 2 — Upcasting, downcasting e instanceof

### Esercizio 4: Dispositivi

Creare:
- un'interfaccia `Ricaricabile` con il metodo `ricarica()`
- una classe `Dispositivo` con il campo `nome` e il metodo `accendi()`, che stampa `<nome> si accende`
- `Smartphone extends Dispositivo implements Ricaricabile`, con in più il metodo `scattaFoto()`
- `Stampante extends Dispositivo`, con in più il metodo `stampa(String documento)`
- `Cuffie extends Dispositivo implements Ricaricabile`

Nel main:
1. Scrivere `Dispositivo d = new Smartphone("Pixel");` e chiamare `d.accendi()`. Provare `d.scattaFoto()` e leggere l'errore (`cannot find symbol`). Poi fare il downcast a `Smartphone` e scattare la foto.
2. Creare un array di `Dispositivo` con uno smartphone, una stampante e delle cuffie. Per ognuno stampare il risultato di `instanceof` con `Dispositivo`, `Smartphone`, `Stampante` e `Ricaricabile`.
```java
Dispositivo[] scrivania = {
    new Smartphone("Pixel"),
    new Stampante("Epson"),
    new Cuffie("AirPods")
};
```

3. Con un secondo ciclo accendere ogni dispositivo e, con il pattern matching (`if (x instanceof Smartphone tel)`), chiamare i metodi che ha solo lui: foto, stampa di `orario.pdf`, ricarica.

Output atteso:

```
Pixel si accende
Pixel scatta una foto
---
Pixel: Dispositivo true, Smartphone true, Stampante false, Ricaricabile true
Epson: Dispositivo true, Smartphone false, Stampante true, Ricaricabile false
AirPods: Dispositivo true, Smartphone false, Stampante false, Ricaricabile true
---
Pixel si accende
Pixel scatta una foto
Pixel in carica con USB-C
Epson si accende
Epson stampa orario.pdf
AirPods si accende
AirPods in carica nella custodia
```

---

### Esercizio 5: Feed di un social

Creare una classe astratta `Post` con il campo `autore` e il metodo astratto `anteprima()` (String). Le sottoclassi:
- `PostTesto` (testo)
- `PostFoto` (file, miPiace)
- `PostVideo` (titolo, durataSecondi)

Nel main creare un feed di sei post e stampare l'anteprima di ognuno. Poi, con un solo ciclo e il pattern matching, calcolare:
- quante foto ci sono e quanti mi piace hanno in tutto
- la durata totale dei video, nel formato `minuti:secondi` (`String.format("%d:%02d", ...)`)
- il post di testo più lungo (`getTesto().length()`)

```java
Post[] feed = {
    new PostTesto("anna", "Domani verifica di Java!"),
    new PostFoto("marco", "tramonto.jpg", 120),
    new PostVideo("giulia", "Tutorial Git", 754),
    new PostTesto("luca", "Qualcuno ha gli appunti sul polimorfismo?"),
    new PostFoto("anna", "classe.jpg", 45),
    new PostVideo("marco", "Gol di sabato", 38)
};
```

Output atteso:

```
anna scrive: Domani verifica di Java!
marco pubblica la foto tramonto.jpg (120 mi piace)
giulia pubblica il video "Tutorial Git"
luca scrive: Qualcuno ha gli appunti sul polimorfismo?
anna pubblica la foto classe.jpg (45 mi piace)
marco pubblica il video "Gol di sabato"
---
Foto: 2, mi piace in totale: 165
Durata dei video: 13:12
Testo più lungo: luca (41 caratteri)
```

---

### Esercizio 6: Trova l'errore

Le classi sono queste: `Animale` (campo `nome`, metodo `verso()` che restituisce `"..."`), `Cane extends Animale` con il metodo in più `riporta()` e `Gatto extends Animale` con il metodo in più `faiLeFusa()`. `Cane` e `Gatto` ridefiniscono `verso()`.

Per ogni frammento dire:
- se **non compila** (errore del compilatore), se **compila ma si ferma** a runtime (`ClassCastException`) oppure se **funziona**
- perché
- come si corregge

**Frammento 1**
```java
Animale a = new Cane("Rex");
a.riporta();
```

**Frammento 2**
```java
Animale a = new Gatto("Tom");
Cane c = (Cane) a;
c.riporta();
```

**Frammento 3**
```java
Cane c = new Gatto("Tom");
```

**Frammento 4**
```java
Cane rex = new Cane("Rex");
if (rex instanceof Gatto) {
    System.out.println("Strano...");
}
```

**Frammento 5** (dentro `Gatto`)
```java
@Override
public String verso(String umore) {
    return "Miao!";
}
```

**Frammento 6**
```java
Animale a = new Cane("Fido");
if (a instanceof Cane c) {
    System.out.println("È un cane");
}
c.riporta();
```

**Frammento 7**
```java
Animale a = null;
System.out.println(a instanceof Cane);
```

Dopo aver risposto, verificare ogni frammento con il compilatore. La prima riga dei messaggi che si ottengono è una di queste:

```
error: cannot find symbol
error: incompatible types: Gatto cannot be converted to Cane
error: incompatible types: Cane cannot be converted to Gatto
error: method does not override or implement a method from a supertype
Exception in thread "main" java.lang.ClassCastException: class Gatto cannot be cast to class Cane (Gatto and Cane are in unnamed module of loader 'app')
```

---

### Esercizio 7: Via la catena di instanceof

In un gioco ci sono una classe `Personaggio` (campo `nome`) e tre sottoclassi, ognuna con un campo e il suo getter: `Guerriero` (`forza`), `Mago` (`mana`) e `Arciere` (`frecce`). Il turno di gioco è scritto così:

```java
public static void turno(Personaggio p) {
    if (p instanceof Guerriero g) {
        System.out.println(g.getNome() + " colpisce con la spada: " + g.getForza() + " danni");
    } else if (p instanceof Mago m) {
        System.out.println(m.getNome() + " lancia una palla di fuoco: " + (m.getMana() / 2) + " danni");
    } else if (p instanceof Arciere a) {
        System.out.println(a.getNome() + " scocca " + a.getFrecce() + " frecce: " + (a.getFrecce() * 4) + " danni");
    }
}
```

Il main stampa `Turno <n>. ` con `System.out.print` e poi chiama `turno(p)` per ogni personaggio.

1. Scrivere le classi così come sono e aggiungere un quarto personaggio, `Ladro`, senza toccare `turno`. Cosa succede al turno 4?

```
Turno 1. Brakka colpisce con la spada: 12 danni
Turno 2. Elandra lancia una palla di fuoco: 15 danni
Turno 3. Tirion scocca 3 frecce: 12 danni
Turno 4. 
```

2. Riscrivere il codice: `Personaggio` diventa astratta con il metodo astratto `azione()` (String) e ogni sottoclasse scrive la sua. `turno` diventa una riga sola e i getter `getForza()`, `getMana()` e `getFrecce()` non servono più. Il ladro `si nasconde nell'ombra`.

```java
Personaggio[] squadra = {
    new Guerriero("Brakka", 12),
    new Mago("Elandra", 30),
    new Arciere("Tirion", 3),
    new Ladro("Vex")
};
```

Output atteso:

```
Turno 1. Brakka colpisce con la spada: 12 danni
Turno 2. Elandra lancia una palla di fuoco: 15 danni
Turno 3. Tirion scocca 3 frecce: 12 danni
Turno 4. Vex si nasconde nell'ombra
```

Adesso, per aggiungere un personaggio, che cosa bisogna modificare?

---

## Livello 3 — Switch sui tipi e sealed

### Esercizio 8: Spedizioni

Creare una classe astratta `Spedizione` (codice, pesoKg) e le sottoclassi `Standard`, `Express` e `Internazionale`, che ha in più il campo `paese`.

Nel main scrivere due metodi statici con uno **switch sui tipi** che restituisce un valore:
- `costo(Spedizione s)`: Standard 5 EUR + 1 EUR al kg, Express 10 EUR + 2 EUR al kg, Internazionale 20 EUR + 3 EUR al kg
- `consegna(Spedizione s)`: `3-5 giorni`, `24 ore`, `7-10 giorni, <paese>`

```java
return switch (s) {
    case Standard st -> 5 + st.getPesoKg() * 1;
    // ...
    default -> 0;
};
```

Provare a togliere il `default` e leggere l'errore:

```
error: the switch expression does not cover all possible input values
```

Aggiungere poi una sottoclasse `RitiroInNegozio` senza scrivere nuovi `case`: dove finisce? (Nel `default` di `consegna` restituire `nessuna consegna`.)

Stampare ogni spedizione con `String.format("%-5s %5.1f kg %7.2f EUR  %s", ...)` e il totale.

```java
Spedizione[] ordini = {
    new Standard("S-01", 2.0),
    new Express("E-01", 1.5),
    new Internazionale("I-01", 3.0, "Francia"),
    new Standard("S-02", 10.0),
    new RitiroInNegozio("R-01", 4.0)
};
```

Output atteso:

```
S-01    2,0 kg    7,00 EUR  3-5 giorni
E-01    1,5 kg   13,00 EUR  24 ore
I-01    3,0 kg   29,00 EUR  7-10 giorni, Francia
S-02   10,0 kg   15,00 EUR  3-5 giorni
R-01    4,0 kg    0,00 EUR  nessuna consegna
Totale spedizioni: 64,00 EUR
```

---

### Esercizio 9: Casello autostradale

Creare un'interfaccia **sealed** `Veicolo` con il metodo `getTarga()`, che permette solo `Auto`, `Moto` e `Camion`. Le tre classi sono `final`; il camion ha in più il campo `assi` (int).

Nel main scrivere, **senza `default`**:
- `pedaggio(Veicolo v, int km)`: auto 0.07 EUR al km, moto 0.05 EUR al km, camion 0.04 EUR al km per ogni asse
- `categoria(Veicolo v)`: `auto`, `moto`, `camion`

Poi aggiungere la classe `final` `Furgone` (0.09 EUR al km):
1. scrivere la classe senza aggiungerla a `permits` e leggere l'errore
2. aggiungerla a `permits` ma non agli switch e leggere l'errore
3. completare gli switch

```
error: class is not allowed to extend sealed class: Veicolo (as it is not listed in its 'permits' clause)
error: the switch expression does not cover all possible input values
```

Stampare ogni veicolo con `String.format("%-8s %-8s %6.2f EUR", ...)` e l'incasso, per un tratto di 120 km.

```java
Veicolo[] coda = {
    new Auto("AB123CD"),
    new Moto("EF456GH"),
    new Camion("IL789MN", 3),
    new Furgone("OP012QR"),
    new Camion("ST345UV", 5)
};
```

Output atteso:

```
AB123CD  auto       8,40 EUR
EF456GH  moto       6,00 EUR
IL789MN  camion    14,40 EUR
OP012QR  furgone   10,80 EUR
ST345UV  camion    24,00 EUR
Incasso per 120 km: 63,60 EUR
```

---

### Esercizio 10: Abbonamenti della palestra, metodo o switch?

Lo stesso calcolo si può scrivere in due modi: con un metodo ridefinito in ogni sottoclasse o con uno switch sui tipi fuori dalle classi. Questo esercizio li mette a confronto.

Creare una classe astratta **sealed** `Abbonamento` (intestatario) con il metodo astratto `prezzo()`. Le sottoclassi `final`:
- `Mensile`: 45 EUR
- `Annuale`: 400 EUR
- `Ingressi` (campo `numero`): 8 EUR a ingresso

Nel main scrivere:
- `prezzoConSwitch(Abbonamento a)`: lo stesso calcolo di `prezzo()`, ma con uno switch sui tipi
- `descrizione(Abbonamento a)`: `mensile`, `annuale`, `carnet da <n> ingressi`

Aggiungere poi l'abbonamento `Giornaliero` (10 EUR) e annotare **dove** il compilatore obbliga a intervenire: nella classe, in `permits`, negli switch. Provare anche a togliere `final` da una sottoclasse:

```
error: sealed, non-sealed or final modifiers expected
```

Stampare ogni abbonamento con `String.format("%-7s %-26s metodo %6.2f, switch %6.2f", ...)`: i due prezzi devono coincidere.

```java
Abbonamento[] iscritti = {
    new Mensile("Anna"),
    new Annuale("Marco"),
    new Ingressi("Giulia", 10),
    new Giornaliero("Luca")
};
```

Output atteso:

```
Anna    mensile                    metodo  45,00, switch  45,00
Marco   annuale                    metodo 400,00, switch 400,00
Giulia  carnet da 10 ingressi      metodo  80,00, switch  80,00
Luca    giornaliero                metodo  10,00, switch  10,00
```

Quale dei due modi sceglieresti per il prezzo? E per la descrizione da stampare?

---

## Livello 4 — Progetto

### Esercizio 11: Mediateca della scuola

Creare una classe astratta **sealed** `Articolo` (codice, titolo) con il metodo astratto `descrizione()` e un `toString()` nel formato `<codice> <descrizione>`. Le sottoclassi `final`:
- `Libro` (autore): `Libro: <titolo> di <autore>`
- `Rivista` (numero): `Rivista: <titolo> n. <numero>`
- `Film` (minuti): `Film: <titolo> (<minuti> min)`

Creare la classe `Mediateca`, costruita con la capienza del catalogo (un array di `Articolo`). Metodi:
- `aggiungi(Articolo a)`: restituisce `false` se il catalogo è pieno
- `trova(String codice)`: restituisce l'articolo o `null`
- `stampaCatalogo()`: stampa tutti gli articoli
- `riepilogo()`: conta libri, riviste e film con uno switch sui tipi usato come istruzione (`case Libro l -> libri++;`)
- `cercaAutore(String autore)`: stampa i titoli dei libri di quell'autore (pattern matching)
- `static int giorniPrestito(Articolo a)`: libro 30 giorni, rivista 7, film 3
- `static double penale(Articolo a, int giorniTenuto)`: per ogni giorno di ritardo libro 0.20 EUR, rivista 0.10 EUR, film 1.00 EUR; senza ritardo 0

Nel main creare una mediateca da 6 articoli e provare ad aggiungerne 7:

```java
Mediateca m = new Mediateca(6);
Articolo[] nuovi = {
    new Libro("L1", "Il barone rampante", "Calvino"),
    new Libro("L2", "Le città invisibili", "Calvino"),
    new Libro("L3", "La coscienza di Zeno", "Svevo"),
    new Rivista("R1", "Focus", 412),
    new Film("F1", "Nuovo Cinema Paradiso", 155),
    new Film("F2", "La vita è bella", 116),
    new Rivista("R2", "Wired", 98)
};
```

Poi simulare quattro restituzioni, stampando per ognuna giorni, durata del prestito e penale, e cercare i libri di Calvino:

```java
String[] codici = { "L1", "R1", "F2", "L3" };
int[] giorni = { 35, 5, 6, 30 };
```

Output atteso:

```
R2 non aggiunto: catalogo pieno
Catalogo:
  L1 Libro: Il barone rampante di Calvino
  L2 Libro: Le città invisibili di Calvino
  L3 Libro: La coscienza di Zeno di Svevo
  R1 Rivista: Focus n. 412
  F1 Film: Nuovo Cinema Paradiso (155 min)
  F2 Film: La vita è bella (116 min)
Libri: 3, riviste: 1, film: 2
---
L1 restituito dopo 35 giorni (prestito 30): penale 1,00 EUR
R1 restituito dopo 5 giorni (prestito 7): penale 0,00 EUR
F2 restituito dopo 6 giorni (prestito 3): penale 3,00 EUR
L3 restituito dopo 30 giorni (prestito 30): penale 0,00 EUR
Penali totali: 4,00 EUR
---
Libri di Calvino:
  Il barone rampante
  Le città invisibili
```

---

### Esercizio 12: Scontrino del supermercato

Creare una classe astratta **sealed** `Prodotto` (nome) con il metodo astratto `prezzo()`. Le sottoclassi `final`:
- `ProdottoAPezzo` (prezzoUnitario, quantita)
- `ProdottoAPeso` (prezzoKg, grammi): il prezzo è `prezzoKg * grammi / 1000`
- `ProdottoInOfferta` (prezzoUnitario, quantita): offerta 3x2, ogni 3 pezzi uno è gratis. Ha in più il metodo `risparmio()`, che restituisce quanto si risparmia con l'offerta

Creare la classe `Scontrino`, costruita con il numero massimo di righe. Metodi:
- `aggiungi(Prodotto p)`: restituisce `false` se lo scontrino è pieno
- `totale()`: somma i prezzi (polimorfismo)
- `risparmio()`: somma il risparmio dei soli prodotti in offerta (pattern matching)
- `static String dettaglio(Prodotto p)`: con uno switch sui tipi restituisce il dettaglio della riga, diverso per ogni tipo: `2 x 1,50`, `1,250 kg x 2,40/kg`, `6 x 0,90 (3x2)`
- `stampa()`: stampa ogni riga con `String.format("%-12s %-20s %6.2f", ...)`, una riga di 40 trattini, il totale con `String.format("%-33s %6.2f", "TOTALE EUR", ...)` e, se c'è, il risparmio

```java
Scontrino s = new Scontrino(10);
s.aggiungi(new ProdottoAPezzo("Latte", 1.50, 2));
s.aggiungi(new ProdottoAPeso("Mele", 2.40, 1250));
s.aggiungi(new ProdottoInOfferta("Yogurt", 0.90, 6));
s.aggiungi(new ProdottoAPeso("Parmigiano", 22.00, 350));
s.aggiungi(new ProdottoInOfferta("Biscotti", 2.50, 4));
s.aggiungi(new ProdottoAPezzo("Pane", 3.20, 1));
s.stampa();
```

Output atteso:

```
Latte        2 x 1,50               3,00
Mele         1,250 kg x 2,40/kg     3,00
Yogurt       6 x 0,90 (3x2)         3,60
Parmigiano   0,350 kg x 22,00/kg    7,70
Biscotti     4 x 2,50 (3x2)         7,50
Pane         1 x 3,20               3,20
----------------------------------------
TOTALE EUR                         28,00
Con le offerte risparmi 4,30 EUR
```

Perché `prezzo()` sta nelle sottoclassi e `dettaglio()` nello scontrino?
