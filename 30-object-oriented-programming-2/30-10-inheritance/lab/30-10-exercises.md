# 30.10 Ereditarietà — Esercizi di laboratorio

## Livello 1 — Base

### Esercizio 1: Forma e Cerchio

Creare una classe `Forma` con un campo `colore` (String) e un metodo `descrizione()` che restituisca il colore.

Creare una classe `Cerchio` che estende `Forma` e aggiunge un campo `raggio` (double).
Ridefinire `descrizione()` per restituire colore e raggio.

```java
Cerchio c = new Cerchio("rosso", 5.0);
System.out.println(c.descrizione());
// rosso, raggio: 5.0
```

---

### Esercizio 2: Prodotto e ProdottoScontato

Creare una classe `Prodotto` con campi `nome` (String) e `prezzo` (double), un costruttore, getter e un metodo `toString()`.

Creare una classe `ProdottoScontato` che estende `Prodotto` e aggiunge un campo `sconto` (int, percentuale da 0 a 100). Aggiungere un metodo `getPrezzoScontato()` che restituisce il prezzo ridotto e ridefinire `toString()` per mostrare anche lo sconto.

```java
ProdottoScontato ps = new ProdottoScontato("Laptop", 1000.0, 10);
System.out.println(ps.getPrezzoScontato()); // 900.0
System.out.println(ps);
// Laptop - 1000.0 EUR (sconto 10%)
```

---

### Esercizio 3: Strumento e Chitarra

Creare una classe `Strumento` con un campo `nome` (String) e un metodo `suona()` che restituisce `"..."`.

Creare `Chitarra` (extends `Strumento`) che ridefinisce `suona()` restituendo `"Tlin tlin!"` e `Tamburo` (extends `Strumento`) che restituisce `"Bum bum!"`.

Creare un array di `Strumento` con una chitarra e un tamburo, iterare e stampare il suono di ciascuno.

---

### Esercizio 4: Veicolo, Automobile, Autocarro

Creare una classe `Veicolo` con campi `targa` (String) e `posti` (int).

Creare `Automobile` (extends `Veicolo`) con un campo aggiuntivo `porte` (int). Il `toString()` restituisce targa e numero di porte separati da `:`.

Creare `Autocarro` (extends `Veicolo`) con un campo aggiuntivo `caricoMax` (double, in quintali). Il `toString()` restituisce targa e capacità massima separati da `:`.

```java
Automobile auto = new Automobile("CF123RM", 4, 4);
Autocarro camion = new Autocarro("CA133SM", 2, 50.0);
System.out.println(auto);    // CF123RM:4
System.out.println(camion);  // CA133SM:50.0
```

---

## Livello 2 — Intermedio

### Esercizio 5: Conto bancario

Creare una classe `ContoBancario` con:
- campi: `intestatario` (String), `saldo` (double)
- metodi: `deposita(double)`, `preleva(double)` (non permette saldo negativo), `getSaldo()`, `toString()`

Creare `ContoCorrente` (extends `ContoBancario`) che aggiunge un campo `costoOperazione` (double). Ogni deposito e prelievo sottrae il costo dell'operazione dal saldo.

Creare `ContoRisparmio` (extends `ContoBancario`) che aggiunge un campo `tassoInteresse` (double). Aggiungere un metodo `applicaInteresse()` che incrementa il saldo in base al tasso.

```java
ContoCorrente cc = new ContoCorrente("Anna", 1000, 1.5);
cc.deposita(200);       // saldo: 1198.5 (1200 - 1.5)
cc.preleva(100);        // saldo: 1097.0 (1098.5 - 1.5)

ContoRisparmio cr = new ContoRisparmio("Marco", 1000, 5);
cr.applicaInteresse();  // saldo: 1050.0
```

---

### Esercizio 6: Dipendente, Manager, Stagista

Creare una classe `Dipendente` con campi `nome` (String) e `stipendioBase` (double) e un metodo `calcolaStipendio()` che restituisce lo stipendio base.

Creare `Manager` (extends `Dipendente`) con un campo `bonus` (double). Il metodo `calcolaStipendio()` restituisce stipendio base + bonus.

Creare `Stagista` (extends `Dipendente`) con un campo `oreLavorate` (int) e `pagaOraria` (double). Il metodo `calcolaStipendio()` restituisce ore * paga oraria (ignora lo stipendio base).

Creare un array di `Dipendente` con un manager e due stagisti, iterare e stampare nome e stipendio di ciascuno.

---

### Esercizio 7: Biblioteca

Creare una classe `Pubblicazione` con campi `titolo` (String), `anno` (int) e un metodo `toString()`.

Creare `Libro` (extends `Pubblicazione`) con campo `autore` (String) e `Rivista` (extends `Pubblicazione`) con campo `numero` (int).

Creare una classe `Biblioteca` che contiene un array di `Pubblicazione` (composizione). La biblioteca ha:
- `aggiungi(Pubblicazione p)`: aggiunge una pubblicazione
- `cercaPerAnno(int anno)`: restituisce un array con le pubblicazioni di quell'anno
- `stampaAll()`: stampa tutte le pubblicazioni

```java
Biblioteca bib = new Biblioteca(100);
bib.aggiungi(new Libro("Il nome della rosa", 1980, "Eco"));
bib.aggiungi(new Rivista("Nature", 2024, 612));
bib.stampaAll();
```

---

### Esercizio 8: Figure geometriche

Creare una classe `Figura` con un metodo `area()` che restituisce `0.0` e un metodo `toString()`.

Creare `Rettangolo` (extends `Figura`) con campi `base` e `altezza`, e `Triangolo` (extends `Figura`) con campi `base` e `altezza`. Entrambi ridefiniscono `area()` e `toString()`.

Creare un array di `Figura` con almeno 3 elementi, iterare e stampare la descrizione e l'area di ciascuno. Calcolare l'area totale.

---

## Livello 3 — Avanzato

### Esercizio 9: Distributore di bevande

Creare una classe `Prodotto` con campi `codice` (String) e `prezzo` (double).

Creare `Caffe` (extends `Prodotto`) e `Cappuccino` (extends `Prodotto`), ciascuno con il proprio `toString()`.

Creare una classe `DistributoreDiBevande` costruita con un intero `n` che determina la capienza. Il distributore ha:
- `caricaProdotto(Prodotto p)`: carica un prodotto nel distributore
- `inserisciImporto(double importo)`: inserisce denaro
- `scegliProdotto(String codice)`: se il saldo lo consente, restituisce il prodotto e decrementa il saldo; altrimenti restituisce `null`
- `saldoAttuale()`: restituisce il saldo corrente
- `getResto()`: restituisce il resto e azzera il saldo

```java
Caffe caffe = new Caffe("caffe", 0.5);
Cappuccino cappuccino = new Cappuccino("cappuccino", 1.0);
DistributoreDiBevande dist = new DistributoreDiBevande(10);
dist.caricaProdotto(caffe);
dist.caricaProdotto(cappuccino);
dist.inserisciImporto(2.0);
System.out.println(dist.scegliProdotto("caffe"));     // Caffe
System.out.println(dist.scegliProdotto("cappuccino")); // Cappuccino
System.out.println(dist.getResto());                   // 0.5
```

---

### Esercizio 10: Sistema di notifiche

Creare una classe `Notifica` con campi `mittente` (String), `messaggio` (String) e un metodo `invia()` che restituisce una stringa con il formato di invio.

Creare `NotificaEmail` (extends `Notifica`) con campo `emailDestinatario`, `NotificaSMS` (extends `Notifica`) con campo `numeroTelefono` e `NotificaPush` (extends `Notifica`) con campo `dispositivo`.

Ogni sottoclasse ridefinisce `invia()` con il proprio formato:
- Email: `"Email a <email>: <messaggio>"`
- SMS: `"SMS a <numero>: <messaggio>"`
- Push: `"Push su <dispositivo>: <messaggio>"`

Creare un array di `Notifica` e invocare `invia()` su ciascuna.

---

### Esercizio 11: Ordine e-commerce

Creare una classe `Articolo` con campi `nome` (String), `prezzo` (double) e un metodo `costoFinale()` che restituisce il prezzo.

Creare `ArticoloFisico` (extends `Articolo`) con campo `peso` (double, kg). Il `costoFinale()` aggiunge una spesa di spedizione pari a `peso * 2.5`.

Creare `ArticoloDigitale` (extends `Articolo`) che ridefinisce `costoFinale()` applicando uno sconto fisso del 10% (nessuna spedizione).

Creare una classe `Ordine` (composizione) che contiene un array di `Articolo` e ha:
- `aggiungiArticolo(Articolo a)`: aggiunge un articolo
- `calcolaTotale()`: somma il `costoFinale()` di tutti gli articoli
- `stampaRiepilogo()`: stampa ogni articolo con il suo costo finale e il totale

```java
Ordine ordine = new Ordine(10);
ordine.aggiungiArticolo(new ArticoloFisico("Libro Java", 30.0, 0.8));
ordine.aggiungiArticolo(new ArticoloDigitale("E-book Java", 20.0));
ordine.stampaRiepilogo();
// Libro Java: 32.0 EUR
// E-book Java: 18.0 EUR
// Totale: 50.0 EUR
```

---

### Esercizio 12: Zoo

Creare una classe `Animale` con campi `nome` (String), `specie` (String) e metodi `verso()` e `toString()`.

Creare almeno 4 sottoclassi: `Leone`, `Pappagallo`, `Delfino`, `Serpente`. Ciascuna ridefinisce `verso()` con un verso diverso e `toString()` con informazioni aggiuntive proprie (es. il Leone ha il campo `maschio` boolean per la criniera, il Pappagallo ha `parla` boolean, ecc.).

Creare una classe `Zoo` (composizione) con un array di `Animale` e i metodi:
- `aggiungiAnimale(Animale a)`
- `stampaAnimali()`: stampa tutti gli animali con il verso
- `contaPerSpecie(String specie)`: conta gli animali di una specie
- `concerto()`: stampa tutti i versi uno dopo l'altro

```java
Zoo zoo = new Zoo(20);
zoo.aggiungiAnimale(new Leone("Simba", true));
zoo.aggiungiAnimale(new Pappagallo("Polly", true));
zoo.aggiungiAnimale(new Delfino("Flipper"));
zoo.concerto();
// Simba: Ruggito!
// Polly: Cra cra!
// Flipper: Click click!
```
