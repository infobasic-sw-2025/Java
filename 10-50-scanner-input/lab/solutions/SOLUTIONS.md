# 10.50 Laboratorio · Soluzioni

I file `.java` di questa cartella sono le soluzioni, verificate con Oracle JDK 25.0.4.1 e con `javac --release 21`.

Gli esempi di esecuzione riportano anche i messaggi di richiesta (`Nome: `, `Voto (1-10): `...) e i valori digitati dall'utente, come appaiono nel terminale. Gli output attesi di `exercises.md` mostrano invece solo le righe di risultato.

## Esercizio 10.50.10
`Greeting.java`. `nextLine()` legge l'intera riga fino a Invio, spazi compresi: con `Mario Rossi` stampa `Ciao, Mario Rossi!`. Con `next()` si leggerebbe solo `Mario`.

```
Come ti chiami? Mario
Ciao, Mario!
```

## Esercizio 10.50.20
`SumTwoNumbers.java`. `nextInt()` legge un token alla volta e salta spazi e a capo: i due numeri si possono scrivere su due righe o sulla stessa (`7 3`). Le parentesi in `"Somma: " + (a + b)` servono, altrimenti `+` concatenerebbe `73`.

- Se l'utente scrive un testo, `nextInt()` lancia `InputMismatchException` e il programma termina: la validazione arriva con l'esercizio 10.50.70

## Esercizio 10.50.30
`PersonalCard.java`. `nextInt()` legge `22` ma lascia nel buffer il `'\n'` premuto dopo. Senza la `nextLine()` di consumo, la `nextLine()` della città troverebbe subito quel `'\n'` e restituirebbe una stringa vuota: l'output sarebbe `Alice, 22 anni, vive a `.

```
Nome: Alice
Età: 22
Città: Roma
Alice, 22 anni, vive a Roma
```

## Esercizio 10.50.40
`EvenOdd.java`. Il controllo è `numero % 2 == 0`: con i negativi il resto vale `-1` (es. `-7 % 2`), quindi `numero % 2 == 1` darebbe "pari" per tutti i dispari negativi. Anche 0 risulta pari.

## Esercizio 10.50.50
`Average.java`.

```
Primo numero: 7.5
Secondo numero: 8.0
Terzo numero: 6.5
Media: 7.333333333333333
```

- `nextDouble()` usa il separatore decimale del sistema: con il locale italiano si aspetta la virgola, e `7.5` provoca `InputMismatchException`
- `scanner.useLocale(Locale.US)` fissa il punto come separatore, così l'input dell'esempio funziona su qualsiasi computer
- La media è un `double` anche se i numeri inseriti sono interi: `(a + b + c) / 3` divide un `double` per un `int`, quindi la divisione è decimale

## Esercizio 10.50.60
`SimpleCalculator.java`.

```
Primo numero: 12
Secondo numero: 0
Operazione (+ - * /): /
Attenzione: divisione per zero
```

- Dopo `nextDouble()` serve la `nextLine()` di consumo, poi l'operazione si legge con `nextLine()`. In alternativa `next()` legge il token senza preoccuparsi del `'\n'`
- Lo `switch` con la freccia lavora sulla `String` letta; il `default` gestisce l'operazione non valida (`Operazione non valida: x`)
- Con i `double` la divisione per zero non lancia eccezioni: `12.0 / 0` vale `Infinity` e `0.0 / 0` vale `NaN`. Per questo il controllo `b == 0` va fatto a mano, prima di dividere

## Esercizio 10.50.70
`GradeValidation.java`. Il ciclo controlla prima il tipo con `hasNextInt()`, che guarda il token senza consumarlo; se non è un intero, `next()` lo scarta, altrimenti `hasNextInt()` lo troverebbe di nuovo all'infinito. Solo dopo la lettura si controlla l'intervallo, e `break` esce quando il voto è valido.

```
Voto (1-10): 0
Il voto deve essere tra 1 e 10
Voto (1-10): abc
Inserisci un numero
Voto (1-10): 15
Il voto deve essere tra 1 e 10
Voto (1-10): 7
Voto registrato: 7
```

## Esercizio 10.50.80
`SentinelSum.java`. Il valore `0` è la sentinella: segnala la fine dell'input e non entra nella somma. I negativi si ignorano in silenzio, perché l'output atteso non prevede un messaggio per `-2`; i valori non numerici si scartano con `next()`.

```
Numero (0 per terminare): 5
Numero (0 per terminare): -2
Numero (0 per terminare): abc
Valore non numerico, riprova
Numero (0 per terminare): 4
Numero (0 per terminare): 0
Somma dei numeri positivi: 9
```

## Esercizio 10.50.90
`VowelCounter.java`. Servono due metodi di `String` non ancora visti: `length()` restituisce il numero di caratteri, `charAt(i)` il carattere in posizione `i` (da 0 a `length() - 1`). Lo `switch` con la freccia raggruppa le dieci vocali, minuscole e maiuscole, in un solo `case`; i `char` vanno tra apici singoli.

```
Parola: Programmazione
Numero di vocali: 6
```

## Esercizio 10.50.100
`GuessNumber.java`. `Math.random()` restituisce un `double` tra 0 (incluso) e 1 (escluso): moltiplicato per 100 e convertito in `int` dà un valore da 0 a 99, e `+ 1` lo porta da 1 a 100. Il cast va applicato al prodotto, con le parentesi: `(int) Math.random() * 100` varrebbe sempre 0.

- Il `do-while` è naturale: almeno un tentativo va fatto sempre
- I valori non numerici vengono scartati e non contano come tentativi
- Con la strategia di dimezzare l'intervallo bastano al massimo 7 tentativi

Il numero segreto cambia a ogni esecuzione; in questa era 8:

```
Tentativo (1-100): 50
Troppo alto
Tentativo (1-100): 25
Troppo alto
Tentativo (1-100): 12
Troppo alto
Tentativo (1-100): 6
Troppo basso
Tentativo (1-100): 9
Troppo alto
Tentativo (1-100): 7
Troppo basso
Tentativo (1-100): 8
Indovinato in 7 tentativi!
```

## Esercizio 10.50.110
`OperationsMenu.java`.

- Il menu è un `do-while`: va mostrato almeno una volta e si ripete finché la scelta non è 0
- Il metodo statico `leggiIntero` raccoglie la validazione, usata per la scelta e per i numeri: ripete la domanda finché l'input non è un intero, poi consuma il `'\n'`. Così la `nextLine()` del nome nell'opzione 1 legge davvero il nome
- Il fattoriale cresce molto in fretta: si usa un `long`, che arriva fino a `20! = 2432902008176640000`; `21!` non ci sta più e darebbe un risultato sbagliato senza errori. Per questo il numero viene accettato solo tra 0 e 20 (`0! = 1`)

```

1. Saluta
2. Somma
3. Fattoriale
0. Esci
Scelta: 1
Come ti chiami? Mario
Ciao, Mario!

1. Saluta
2. Somma
3. Fattoriale
0. Esci
Scelta: 2
Primo numero: 7
Secondo numero: abc
Inserisci un numero
Secondo numero: 3
Somma: 10

1. Saluta
2. Somma
3. Fattoriale
0. Esci
Scelta: 3
Numero (0-20): 5
5! = 120

1. Saluta
2. Somma
3. Fattoriale
0. Esci
Scelta: 9
Scelta non valida

1. Saluta
2. Somma
3. Fattoriale
0. Esci
Scelta: 0
Arrivederci!
```

## Esercizio 10.50.120
`SeriesStats.java`.

- Minimo e massimo partono da `Integer.MAX_VALUE` e `Integer.MIN_VALUE`: il primo numero inserito li aggiorna entrambi. Partire da 0 sarebbe sbagliato, ad esempio con soli numeri positivi il minimo resterebbe 0
- La media richiede il cast: `somma / conteggio` tra due `int` darebbe 9, `(double) somma / conteggio` dà 9.8
- Se l'utente inserisce subito 0 non ci sono numeri: il programma stampa `Nessun numero inserito` invece di dividere per zero
- I negativi sono numeri validi e contano nelle statistiche; solo 0 termina l'input

```
Numero (0 per terminare): 10
Numero (0 per terminare): 3
Numero (0 per terminare): abc
Valore non numerico, riprova
Numero (0 per terminare): 7
Numero (0 per terminare): 25
Numero (0 per terminare): 4
Numero (0 per terminare): 0
Numeri inseriti: 5
Somma: 49
Media: 9.8
Minimo: 3
Massimo: 25
```
