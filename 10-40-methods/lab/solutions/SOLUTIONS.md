# 10.40 Laboratorio · Soluzioni

I file `.java` di questa cartella sono le soluzioni, verificate con Oracle JDK 25.0.4.1 e con `javac --release 21`.

## Esercizio 1
`Greeting.java`. Il metodo è `void`: stampa e non restituisce nulla, quindi si chiama come un'istruzione a sé (`saluta("Alice");`). Il parametro `nome` riceve ogni volta il valore passato dal main.

## Esercizio 2
`RectangleArea.java`. `area(4, 7)` e `area(5, 9)` danno 28 e 45. Il metodo restituisce il valore con `return` invece di stamparlo: così il chiamante può salvarlo in una variabile, stamparlo o usarlo in altri calcoli.

## Esercizio 3
`EvenOdd.java`. `n % 2 == 0` è già un `boolean`, quindi basta `return n % 2 == 0;`. Scrivere `if (n % 2 == 0) return true; else return false;` è corretto ma ridondante. Nel main il metodo si usa direttamente come condizione: `if (isPari(i))`.

## Esercizio 4
`MaxOfTwo.java`. Il primo `return` eseguito chiude il metodo: se `a > b` restituisce `a`, altrimenti si arriva al `return b`. Non serve l'`else`. Con due valori uguali restituisce `b`, che è comunque il massimo.

```
massimo(3, 8) = 8
massimo(10, -2) = 10
massimo(5, 5) = 5
```

## Esercizio 5
`TemperatureMethods.java`. Il `9.0` e il `5.0` nelle formule rendono `double` tutta l'espressione: con `9 / 5` la divisione intera darebbe 1 e il risultato sarebbe sbagliato. Si possono passare anche interi (`celsiusToFahrenheit(100)`): Java li converte in `double` in automatico.

```
0 °C = 32.0 °F
100 °C = 212.0 °F
37 °C = 98.6 °F
32 °F = 0.0 °C
212 °F = 100.0 °C
98.6 °F = 37.0 °C
```

## Esercizio 6
`Power.java`. Il risultato parte da 1, l'elemento neutro della moltiplicazione, e il ciclo lo moltiplica per `base` esattamente `esponente` volte. Con esponente 0 il ciclo non parte e il metodo restituisce 1, che è corretto. Il tipo di ritorno è `long` perché le potenze superano presto il limite di `int`.

## Esercizio 7
`PrimeCheck.java`.
- I numeri minori di 2 non sono primi: il metodo li esclude subito
- Appena trova un divisore restituisce `false`: il `return` esce sia dal ciclo sia dal metodo, quindi non servono `break` né una variabile `boolean`
- Se il ciclo finisce senza trovare divisori, il numero è primo
- Come nella 10.30, basta cercare divisori finché `d * d <= n`

## Esercizio 8
`TimeFormatter.java`.
- Ore: `totaleSecondi / 3600`
- Minuti: `totaleSecondi % 3600 / 60`, cioè i secondi avanzati dalle ore, divisi per 60
- Secondi: `totaleSecondi % 60`
- Il metodo restituisce una `String` costruita con la concatenazione

Le chiamate si possono annidare: `formattaTempo(tempoInSecondi(2, 46, 40))` restituisce `2h 46m 40s`, una verifica che i due metodi sono uno l'inverso dell'altro.

## Esercizio 9
`Factorial.java`.

```
19! = 121645100408832000
20! = 2432902008176640000
21! = -4249290049419214848
22! = -1250660718674968576
23! = 8128291617894825984
24! = -7835185981329244160
25! = 7034535277573963776
```

- Il risultato diventa negativo per la prima volta con n = 21. 20! è l'ultimo che sta in un `long`, il cui massimo è 9223372036854775807 (circa 9,2 × 10^18); 21! vale circa 5,1 × 10^19
- Il motivo è l'overflow: quando il risultato supera il massimo, Java non segnala errori e il valore "riparte" dai negativi
- Dal 21 in poi tutti i valori sono sbagliati, anche quelli positivi: 23! stampa 8128291617894825984, ma il valore vero è 25852016738884976640000. Un risultato positivo non garantisce che il calcolo sia corretto

## Esercizio 10
`FixMethods.java`. javac mostra un errore alla volta: corretto il primo, compare il successivo.

1. `doppio`: `n * 2;` calcola un valore ma non lo usa
   ```
   FixMethods.java:4: error: not a statement
           n * 2;
             ^
   ```
   Correzione: `return n * 2;`
2. `saluta`: un metodo `void` non può restituire un valore
   ```
   FixMethods.java:14: error: incompatible types: unexpected return value
           return "Ciao, " + nome;
                           ^
   ```
   Correzione: stampare con `System.out.println("Ciao, " + nome);`. In alternativa si cambia il tipo di ritorno in `String` e si stampa nel main il valore restituito
3. `isPositivo`: se `n <= 0` il metodo arriva alla fine senza un `return`
   ```
   FixMethods.java:11: error: missing return statement
       }
       ^
   ```
   Correzione: aggiungere `return false;` dopo l'`if`, oppure scrivere direttamente `return n > 0;`

L'errore di `isPositivo` compare per ultimo anche se è nel codice prima di `saluta`: javac controlla i percorsi del `return` solo dopo aver verificato i tipi. Il programma corretto stampa:

```
10
false
Ciao, Anna
```

## Esercizio 11
`Refactor.java`. Il blocco `if/else` ripetuto tre volte diventa il metodo `stampaParita(int n)`, che usa a sua volta `isPari` dell'esercizio 3. Il main si riduce a tre chiamate e l'output resta identico. Se cambia il formato del messaggio, si modifica in un solo punto.

```
7 è dispari
3 è dispari
12 è pari
```
