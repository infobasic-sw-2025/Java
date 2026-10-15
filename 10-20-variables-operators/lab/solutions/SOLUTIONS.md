# 10.20 Laboratorio · Soluzioni

I file `.java` di questa cartella sono le soluzioni, verificate con Oracle JDK 25.0.4.1 e con `javac --release 21`.

## Esercizio 1
`PersonalCard.java`. Tipi: `String` per nome e città, `char` per l'iniziale (tra apici singoli), `int` per l'età, `double` per l'altezza, `boolean` per lo studente.

Gli errori richiesti:
- `ANNO_CORRENTE = 2027;` → `cannot assign a value to final variable ANNO_CORRENTE`
- `citta = 10;` → `incompatible types: int cannot be converted to String`: con `var` il tipo è dedotto una volta, poi resta `String`

## Esercizio 2
`Swap.java`. `a = b; b = a;` non funziona: dopo la prima istruzione `a` vale già 8, quindi anche `b` diventa 8 e il 5 si perde. Serve una variabile di appoggio che conservi il valore di `a`:

```java
int temp = a;
a = b;
b = temp;
```

## Esercizio 3
`Average.java`.

```
Media tra interi: 7.0
Media: 7.666666666666667
Media arrotondata: 7.7
```

`(7 + 8 + 8) / 3` è una divisione tra interi: 23 / 3 = 7, poi convertito in 7.0 quando finisce nel `double`. Con `/ 3.0` la divisione è decimale. `Math.round(media * 10) / 10.0` arrotonda a un decimale.

## Esercizio 4
`Initials.java`.

```
159
M.R.
MR
```

Due `char` sommati sono numeri: 77 + 82 = 159. Con `"."` in mezzo, da sinistra a destra, il primo `+` ha già una String. Con `""` all'inizio tutto diventa concatenazione.

## Esercizio 5
`TimeConverter.java`.
- Ore: `10000 / 3600` = 2, divisione intera
- Minuti: `10000 % 3600` = 2800 secondi rimasti, poi `/ 60` = 46. `%` e `/` hanno la stessa precedenza e si valutano da sinistra a destra, quindi non servono parentesi
- Secondi: `10000 % 60` = 40

## Esercizio 6
`TemperatureConverter.java`.

```
Sbagliata: 57.0
Corretta: 77.0
Con decimali: 77.0
37 °C = 98 °F (tra interi)
37 °C = 98.6 °F (con double)
```

1. Le parentesi fanno calcolare prima `9 / 5`, una divisione tra interi che vale 1. Il risultato è `25 * 1 + 32` = 57. Assegnarlo a un `double` non cambia niente: il calcolo è già avvenuto tra `int`.
2. No. `celsius * 9 / 5` calcola prima `25 * 9` = 225, che è divisibile per 5. Con 37 si ottiene `333 / 5` = 66, e il decimale si perde: 98 invece di 98.6. La versione corretta per qualsiasi valore usa `9.0`.

## Esercizio 7
`ShoppingReceipt.java`.

```
Articoli: 6
Imponibile: 13.860000000000001
Scontato: 12.474000000000002
Totale con IVA: 15.218280000000002
Da pagare: 15.22 euro
```

L'imponibile dovrebbe essere 13.86: le cifre in più sono l'errore di arrotondamento dei `double` (1.29 e 4.99 non sono rappresentabili esattamente in binario). `Math.round(totale * 100) / 100.0` arrotonda ai centesimi: `100.0` è un `double`, quindi la divisione non è intera. Nei programmi reali gli importi si gestiscono in centesimi interi o con `BigDecimal`.

## Esercizio 8
`LeapYear.java`. La condizione è:

```java
(anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0
```

Le parentesi non sono obbligatorie, perché `&&` viene prima di `||`, ma rendono chiara la regola. 1900 è divisibile per 4 e per 100, ma non per 400: non è bisestile. 2000 è divisibile per 400: è bisestile.

## Esercizio 9
`PredictTheOutput.java`.

| # | Output | Perché |
|---|---|---|
| 1 | `22` | `x++` vale 10 e porta x a 11; `++x` porta x a 12 e vale 12: 10 + 12 |
| 2 | `12` | Dopo i due incrementi |
| 3 | `17` | `17 / 4` = 4, `4 * 4` = 16, `17 % 4` = 1 |
| 4 | `4.0` | `5 / 2` = 2 tra interi, poi `2 * 2.0` = 4.0 |
| 5 | `Java25` | Da sinistra: `"Java" + 2` è già una String |
| 6 | `7Java` | Prima la somma `2 + 5`, poi la concatenazione |
| 7 | `195` | Due `char` si sommano come numeri: 97 + 98 |
| 8 | `ab` | `"" + 'a'` è una String, e da lì è concatenazione |
| 9 | `0` | Il cast tronca: 3 + (−3) |
| 10 | `-126` | 130 non sta in un byte: si tengono solo gli 8 bit, 130 − 256 |
| 11 | `false` | Errore di arrotondamento: 0.1 + 0.2 vale 0.30000000000000004 |

## Esercizio 10
`DigitSum.java`.
- Unità: `numero % 10` = 7
- Decine: `numero / 10 % 10` = 2
- Centinaia: `numero / 100 % 10` = 8
- Migliaia: `numero / 1000` = 4

Dividere per 10 toglie l'ultima cifra; `% 10` la estrae.

## Esercizio 11
`Coins.java`. Per ogni moneta, dal valore più alto: `resto / valore` è il numero di monete, `resto % valore` quello che resta da dare.

476 = 2 × 200 + 50 + 20 + 5 + 1.

## Esercizio 12
`FixTheErrors.java` è la versione corretta. javac non mostra tutti gli errori insieme, ma in tre giri, ed è normale:

1. **Errori di sintassi:** `';' expected` alla riga di `promosso`, e `unclosed character literal` per `'Media: '`. Le stringhe vanno tra virgolette doppie; gli apici singoli sono per un solo `char`.
2. **Letterale troppo grande:** `integer number too large` per `3000000000`. Serve il suffisso `L`.
3. **Errori di tipo:**
   - `float prezzo = 19.99;` → `possible lossy conversion from double to float`: serve `19.99f`
   - `metri / 1000.0` è un `double`: per i chilometri interi basta `metri / 1000`
   - `livello = livello + 1;` → `livello + 1` è un `int`: `livello = (byte) (livello + 1);` oppure `livello += 1;`
   - `MASSIMO = MASSIMO + 10;` → `cannot assign a value to final variable MASSIMO`: il risultato va in una nuova variabile, `int punteggio = MASSIMO + 10;`

L'errore che il compilatore non vede: `(7 + 8) / 2` è una divisione intera e vale 7.0. Per ottenere 7.5 serve `/ 2.0`.

```
3000000000 19.99 1 101
60 Media: 7.5 true
```

## Esercizio 13
`BigNumbers.java`.

```
Secondi in 100 anni (int): -1141367296
Secondi in 100 anni (long): 3153600000
Millisecondi in un anno: 1471228928
Millisecondi in un anno: 31536000000
```

- 3.153.600.000 supera il massimo di un `int` (2.147.483.647): overflow. Con `100L` il primo operando è `long` e tutto il calcolo avviene in `long`
- `365 * 24 * 3600 * 1000` è un calcolo tra `int`: va in overflow **prima** dell'assegnazione al `long`. La correzione è un carattere: `1000L`
