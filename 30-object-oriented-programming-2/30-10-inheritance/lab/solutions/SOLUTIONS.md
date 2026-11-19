# 30.10 Soluzioni · Ereditarietà

Ogni esercizio ha la sua cartella. Le soluzioni sono verificate con Oracle JDK 25.0.4.1 e con `javac --release 21`:

```
cd ex01-forma-cerchio
javac *.java
java Main
```

## Esercizio 1 · Forma e Cerchio
`ex01-forma-cerchio/`. `colore` è `private`: `Cerchio` lo inizializza con `super(colore)` e lo legge con `super.descrizione()`.

```
rosso, raggio: 5.0
```

## Esercizio 2 · Prodotto e ProdottoScontato
`ex02-prodotto-scontato/`. Il prezzo si legge con `getPrezzo()`, perché il campo è `private`. `super.toString()` riusa il testo di `Prodotto`.

```
900.0
Laptop - 1000.0 EUR (sconto 10%)
```

## Esercizio 3 · Strumento e Chitarra
`ex03-strumenti/`. L'array è di `Strumento`, ma `suona()` è quello del tipo reale di ogni oggetto.

```
Chitarra: Tlin tlin!
Tamburo: Bum bum!
```

## Esercizio 4 · Veicolo, Automobile, Autocarro
`ex04-veicoli/`. Ogni sottoclasse ridefinisce `toString()` e prende la targa con il getter ereditato.

```
CF123RM:4
CA133SM:50.0
```

## Esercizio 5 · Conto bancario
`ex05-conti/`. `ContoCorrente` ridefinisce `deposita` e `preleva`, riusando quelli della superclasse con `super.`. Il prelievo controlla importo e costo insieme, così non si scala solo una parte. `applicaInteresse()` usa `deposita`, perché il saldo è `private`.

```
Anna: 1198.5 EUR
Anna: 1097.0 EUR
Saldo insufficiente
Anna: 1097.0 EUR
Marco: 1050.0 EUR
```

## Esercizio 6 · Dipendente, Manager, Stagista
`ex06-dipendenti/`. `Stagista` passa 0 come stipendio base e ridefinisce il calcolo senza usarlo.

```
Anna: 3500.0
Marco: 680.0
Laura: 540.0
```

## Esercizio 7 · Biblioteca
`ex07-biblioteca/`. `Biblioteca` ha un array di `Pubblicazione`: è composizione. `cercaPerAnno` conta prima i risultati per creare un array della misura giusta.

```
Il nome della rosa (1980) di Eco
Nature (2024), numero 612
Del 2024:
Nature (2024), numero 612
```

## Esercizio 8 · Figure geometriche
`ex08-figure/`. `f.area()` esegue il metodo della figura reale. Stampando `f` si usa il suo `toString()`.

```
Rettangolo 4.0 x 5.0: area 20.0
Triangolo 6.0 x 3.0: area 9.0
Rettangolo 2.0 x 2.0: area 4.0
Area totale: 33.0
```

## Esercizio 9 · Distributore di bevande
`ex09-distributore/`. Il prodotto venduto esce dall'array spostando indietro i successivi. Con saldo insufficiente, o prodotto finito, `scegliProdotto` restituisce `null`: è l'ultima riga dell'output.

```
Caffe
Cappuccino
0.5
null
```

## Esercizio 10 · Sistema di notifiche
`ex10-notifiche/`. `mittente` non serve ai tre formati richiesti: resta usato solo dall'`invia()` di `Notifica`.

```
Email a anna@email.it: Lezione spostata
SMS a 3331234567: Codice 1234
Push su Telefono di Marco: Pioggia in arrivo
```

## Esercizio 11 · Ordine e-commerce
`ex11-ordine/`. `calcolaTotale()` somma `costoFinale()` senza sapere quale tipo di articolo ha davanti.

```
Libro Java: 32.0 EUR
E-book Java: 18.0 EUR
Totale: 50.0 EUR
```

## Esercizio 12 · Zoo
`ex12-zoo/`. `Leone`, `Pappagallo` e `Serpente` aggiungono un testo al `toString()` solo se il loro campo è `true`.

```
Simba: Ruggito!
Polly: Cra cra!
Flipper: Click click!
Kaa: Sss!
Simba (Leone), con la criniera fa Ruggito!
Polly (Pappagallo), sa parlare fa Cra cra!
Flipper (Delfino), vive in acqua fa Click click!
Kaa (Serpente) fa Sss!
Leoni: 1
```
