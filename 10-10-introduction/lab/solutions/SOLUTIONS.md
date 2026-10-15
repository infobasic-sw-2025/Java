# 10.10 Laboratorio · Soluzioni

I file `.java` di questa cartella sono le soluzioni, verificate con Oracle JDK 21.0.3 e 25.0.4.1.

## Esercizio 1
`HelloName.java`. Output:

```
Ciao, Davide!
```

L'operatore `+` tra testo e una variabile `String` unisce le due parti (concatenazione).

## Esercizio 2
`HelloName25.java`, eseguito con `java HelloName25.java`.

1. Sono sparite `public class HelloName`, `public static`, `String[] args` e `System.out`.
2. Non c'è nessun `HelloName25.class`: con `java File.java` il sorgente viene compilato in memoria ed
   eseguito subito, senza scrivere il bytecode su disco.

Con un JDK precedente al 25 il file non compila: con il JDK 21 l'errore è
`unnamed classes are a preview feature and are disabled by default`.

## Esercizio 3
`TimesTable.java`. La moltiplicazione ha la precedenza su `+`, quindi `"2 x 3 = " + 2 * 3` prima
calcola `2 * 3`, poi concatena: `2 x 3 = 6`.

**Bonus** (`Bonus.java`):

```
2 + 1 = 21
2 + 1 = 3
```

`+` si valuta da sinistra a destra. `"2 + 1 = " + 2` produce il testo `"2 + 1 = 2"`, e `+ 1`
aggiunge un altro carattere: `"2 + 1 = 21"`. Con le parentesi, `(2 + 1)` viene calcolato prima come
somma tra numeri.

## Esercizio 4
`PrintWithoutLn.java`. Output:

```
2 x 1 = 22 x 2 = 42 x 3 = 6
```

1. Tutto finisce sulla stessa riga, senza spazi tra una stampa e l'altra: per questo `= 2` e `2 x 2`
   si attaccano e sembrano `= 22`.
2. `println` stampa il testo e poi va a capo; `print` stampa solo il testo.
3. Il prompt del terminale compare attaccato alla fine dell'output, perché l'ultima stampa non è andata
   a capo.
