# 10.30 Laboratorio · Soluzioni

I file `.java` di questa cartella sono le soluzioni, verificate con Oracle JDK 25.0.4.1 e con `javac --release 21`.

## Esercizio 1
`EvenOdd.java`. `-7 % 2` vale `-1`, non `1`: in Java il resto ha il segno del dividendo. Per questo il controllo giusto è `numero % 2 == 0`; `numero % 2 == 1` darebbe "pari" per tutti i dispari negativi.

## Esercizio 2
`Grades.java`. Il controllo del voto non valido va per primo: altrimenti 12 finirebbe in `voto >= 9` e diventerebbe "ottimo". Nella catena di `else if` ogni condizione può dare per scontato che le precedenti siano false, quindi basta `voto >= 7` e non `voto >= 7 && voto <= 8`. Il ternario è indipendente dalla catena: con un voto non valido, ad esempio 12, stampa comunque `promosso`.

## Esercizio 3
`TicketPrice.java`. Le condizioni vanno dalla più restrittiva alla più generale. Se il controllo dello studente venisse prima di quello dei minorenni, uno studente di 15 anni pagherebbe 8 euro invece di 6. Il prezzo è un `double`, per questo stampa `8.0`.

## Esercizio 4
`DayOfWeek.java`. Nella forma classica i casi raggruppati sfruttano il fall-through (`case 1: case 2: ...`); nella forma con la freccia gli stessi valori si separano con la virgola. Lo `switch` come espressione richiede il `default`, perché deve produrre un valore per ogni `int`.

## Esercizio 5
`Calculator.java`.

```
17 / 5 = 3 con resto 2
```

- Il risultato è una `String` perché i casi producono sia numeri sia testi. `"" + (a + b)` trasforma il numero in testo: le parentesi servono, altrimenti `"" + a + b` concatenerebbe `175`.
- Il caso `'/'` è un blocco con due `yield`: uno per la divisione per zero, uno per il risultato.
- `yield a / b + " con resto " + a % b`: `/` e `%` hanno la precedenza su `+`, quindi i calcoli avvengono prima della concatenazione.

## Esercizio 6
`SumToN.java`. La variabile della somma si dichiara e si inizializza a 0 prima del ciclo. Nella versione con `while` il contatore `i` è dichiarato fuori dal ciclo e va incrementato nel corpo: dimenticare `i++` produce un ciclo infinito.

## Esercizio 7
`MultiplicationTable.java`. Nella tavola pitagorica il ciclo esterno scorre le righe, quello interno le colonne; `println()` dopo il ciclo interno va a capo alla fine di ogni riga.

## Esercizio 8
`Digits.java`. Il ciclo lavora su una copia (`resto`), così `numero` resta intatto per la stampa. Il minimo parte da 9 e il massimo da 0, i valori estremi di una cifra. Il rovesciato si costruisce con `rovesciato * 10 + cifra`. Con `do-while` il caso `numero = 0` dà una cifra; con un `while` darebbe 0 cifre.

## Esercizio 9
`BreakContinue.java`.
1. `break` quando `i == 7`, prima della stampa: il 7 non compare.
2. `continue` quando `i == 5`: il ciclo riprende dall'aggiornamento.
3. `while (true)` con `break` quando `n % 7 == 0`: 105.
4. Prima il `continue` per i multipli di 3, poi il `break` se `somma + i` supera 100. Dopo il 16 la somma è 91; il numero successivo non multiplo di 3 è 17, e 108 supera 100.

## Esercizio 10
`PrimeNumber.java`.
- `primo` parte da `numero >= 2`: così 0 e 1 non risultano primi.
- Basta cercare divisori finché `d * d <= numero`: se un numero ha un divisore più grande della sua radice, ne ha anche uno più piccolo. Scrivere `d < numero` è comunque corretto, solo più lento.
- Nel bonus, `break` esce dal ciclo interno e il ciclo esterno passa al numero successivo. La variabile `ePrimo` va reimpostata a `true` a ogni giro esterno.

## Esercizio 11
`Shapes.java`.
- Rettangolo: il ciclo interno va fino a `lato * 2`.
- Triangolo: il ciclo interno va fino a `r`, il numero di riga.
- Quadrato vuoto: la condizione del bordo è `r == 1 || r == lato || c == 1 || c == lato`, e il ternario sceglie `"*"` o `" "`.
- Piramide: alla riga `r` servono `lato - r` spazi e `2 * r - 1` asterischi, con due cicli interni uno dopo l'altro.

## Esercizio 12
`Collatz.java`.

```
27 arriva a 1 in 111 passi, valore massimo 9232
Tra 1 e 100 il più lungo è 97, con 118 passi
```

Non si sa quanti passi servono, quindi il ciclo è un `while`. Nel bonus un `for` scorre i numeri da 1 a 100 e, per ciascuno, un `while` annidato conta i passi. Il record si aggiorna come un massimo, con `p > passiRecord`.
