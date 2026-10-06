# 10.30 Laboratorio · Condizionali e cicli

Lavora da terminale con `javac` e `java`, nella forma classica: una classe con `public static void main(String[] args)`, e tutto il codice dentro il `main`.

Non abbiamo ancora visto come leggere un valore da tastiera: i dati sono scritti nel codice, in variabili. Per provare altri casi, cambia il valore delle variabili, ricompila ed esegui di nuovo.

---

## Esercizio 1 · Pari o dispari

Crea `EvenOdd.java`. Data `int numero = -7;`, stampa se il numero è positivo, negativo o zero, e poi se è pari o dispari.

```
-7 è negativo
-7 è dispari
```

Prova anche con `0`, `12` e `-4`. Attenzione: quanto vale `-7 % 2`?

---

## Esercizio 2 · Il giudizio

Crea `Grades.java`. Dato `int voto = 7;`, stampa il giudizio con una catena di `else if`:

| Voto | Giudizio |
|---|---|
| 9 e 10 | ottimo |
| 7 e 8 | buono |
| 6 | sufficiente |
| da 0 a 5 | insufficiente |
| minore di 0 o maggiore di 10 | voto non valido |

Poi, con l'operatore ternario, salva in una `String` l'esito `promosso` o `bocciato` e stampalo.

```
Giudizio: buono
Esito: promosso
```

---

## Esercizio 3 · Il biglietto del cinema

Crea `TicketPrice.java`. Date `int eta = 22;` e `boolean studente = true;`, calcola il prezzo del biglietto:
- sotto i 6 anni è gratuito;
- sotto i 18 anni o dai 65 in su costa 6 euro;
- per gli studenti fino a 25 anni costa 8 euro;
- per tutti gli altri costa 12 euro.

```
Prezzo: 8.0 euro
```

Prova con 4, 15, 30, 70 anni e con `studente` a `false`. L'ordine delle condizioni cambia il risultato?

**Bonus.** Con un ternario, stampa `Biglietto gratuito` o `Biglietto a pagamento`.

---

## Esercizio 4 · Giorni della settimana

Crea `DayOfWeek.java`. Data `int giorno = 6;` (1 è lunedì, 7 è domenica), stampa se è un giorno feriale o del weekend, scrivendo lo stesso `switch` in tre modi:
1. nella forma classica, con i casi raggruppati e `break`;
2. con la freccia;
3. come espressione, salvando il risultato in una `String`.

```
Classico: weekend
Freccia: weekend
Espressione: weekend
```

Con `giorno = 9` tutte e tre le versioni devono stampare `non valido`.

**Bonus.** Con uno `switch` come espressione, stampa il nome del giorno: `Il giorno 6 è sabato`.

---

## Esercizio 5 · La calcolatrice

Crea `Calculator.java`. Date `int a = 17;`, `int b = 5;` e `char operazione = '/';`, calcola il risultato con uno `switch` come espressione su `operazione`. Le operazioni sono `+`, `-`, `*` e `/`; la divisione è intera e mostra anche il resto.

```
17 / 5 = 3 con resto 2
```

Il caso della divisione deve controllare `b`: se vale 0, il risultato è il testo `divisione per zero`. Serve un blocco con `yield`. Con un carattere diverso dai quattro, il risultato è `operazione sconosciuta`.

---

## Esercizio 6 · La somma da 1 a n

Crea `SumToN.java`. Data `int n = 100;`, calcola la somma dei numeri da 1 a `n` due volte: una con un `for` e una con un `while`. Poi confrontala con la formula `n * (n + 1) / 2`.

```
Somma da 1 a 100 (for): 5050
Somma da 1 a 100 (while): 5050
Formula n * (n + 1) / 2: 5050
```

**Bonus.** Nello stesso ciclo, somma separatamente i pari e i dispari: `Pari: 2550, dispari: 2500`.

---

## Esercizio 7 · La tabellina

Crea `MultiplicationTable.java`. Data `int n = 7;`, stampa la tabellina di `n` fino a 10.

```
7 x 1 = 7
7 x 2 = 14
...
7 x 10 = 70
```

**Bonus.** Con due cicli annidati, stampa la tavola pitagorica da 1 a 10. Per allineare le colonne usa `\t`.

```
1	2	3	4	5	6	7	8	9	10
2	4	6	8	10	12	14	16	18	20
...
```

---

## Esercizio 8 · Le cifre di un numero

Crea `Digits.java`. Dato `int numero = 708351;`, con un solo ciclo calcola:
- quante cifre ha;
- la somma delle cifre;
- la cifra più grande e la più piccola;
- il numero rovesciato.

```
Numero: 708351
Cifre: 6
Somma delle cifre: 24
Cifra massima: 8, minima: 0
Rovesciato: 153807
```

Suggerimento: `% 10` dà l'ultima cifra, `/ 10` la toglie. Con `numero = 0` il risultato deve essere `Cifre: 1`: quale ciclo garantisce almeno un giro?

---

## Esercizio 9 · Break e continue

Crea `BreakContinue.java` con quattro cicli:
1. stampa i numeri da 1 a 10, ma fermati quando arrivi al 7;
2. stampa i numeri da 1 a 10 saltando il 5;
3. con `while (true)` trova il primo multiplo di 7 maggiore di 100;
4. somma i numeri da 1 a 30 saltando i multipli di 3, e fermati prima che la somma superi 100.

```
1 2 3 4 5 6
1 2 3 4 6 7 8 9 10
Primo multiplo di 7 dopo 100: 105
1 2 4 5 7 8 10 11 13 14 16 -> somma 91
```

---

## Esercizio 10 · Numeri primi

Crea `PrimeNumber.java`. Dato `int numero = 97;`, stampa se è primo: un numero primo è maggiore di 1 e divisibile solo per 1 e per sé stesso. Appena trovi un divisore, esci dal ciclo con `break`.

```
97 è primo
```

Prova con 1, 2, 91 e 100.

**Bonus.** Con due cicli annidati, stampa tutti i primi fino a 50.

```
2 3 5 7 11 13 17 19 23 29 31 37 41 43 47
```

---

## Esercizio 11 · Figure con gli asterischi

Crea `Shapes.java`. Data `int lato = 4;`, stampa con cicli annidati quattro figure, separate da una riga vuota:

```
********
********
********
********

*
**
***
****

****
*  *
*  *
****

   *
  ***
 *****
*******
```

Nel quadrato vuoto l'asterisco va solo sul bordo: prima riga, ultima riga, prima colonna, ultima colonna. Nella piramide, ogni riga ha prima degli spazi e poi degli asterischi: quanti, in funzione del numero di riga?

---

## Esercizio 12 · La sequenza di Collatz (sfida)

Crea `Collatz.java`. Si parte da un numero `n`: se è pari si divide per 2, se è dispari si moltiplica per 3 e si aggiunge 1. Si ripete finché si arriva a 1. Con `int n = 27;` conta i passi e trova il valore più alto raggiunto.

```
27 arriva a 1 in 111 passi, valore massimo 9232
```

**Bonus.** Tra i numeri da 1 a 100, trova quello che richiede più passi.

```
Tra 1 e 100 il più lungo è 97, con 118 passi
```
