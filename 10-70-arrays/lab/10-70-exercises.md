# 10.70 Laboratorio · Array

Ogni esercizio è un file con la sua classe e il suo `main`. Gli array si scrivono direttamente nel codice con le graffe, salvo dove è richiesto lo Scanner. Per usare `Arrays.toString` serve `import java.util.Arrays;` in cima al file.

---

## Livello 1 · Base

### Esercizio 1 · Somma degli elementi

Crea `Ex01ArraySum.java`: crea un array di 5 numeri interi e calcola la somma di tutti gli elementi.

Con l'array `{2, 4, 6, 8, 10}`:

```
La somma degli elementi è: 30
```

### Esercizio 2 · Massimo e minimo

Crea `Ex02MaxMin.java`: crea un array di 8 numeri interi e trova il valore massimo e il valore minimo.

Con l'array `{8, 6, 4, 2, 10, 12, 14, 16}`:

```
Il valore massimo è: 16
Il valore minimo è: 2
```

### Esercizio 3 · Pari e dispari

Crea `Ex03EvenOddCount.java`: crea un array di 10 numeri interi e conta quanti sono pari e quanti dispari.

Con l'array `{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}`:

```
Numeri pari: 5
Numeri dispari: 5
```

### Esercizio 4 · Media dei voti

Crea `Ex04GradeAverage.java`: crea un array di 7 voti interi e calcola la media come `double`. Stampa anche quanti voti sono sufficienti (>= 6).

Con l'array `{7, 5, 8, 4, 9, 6, 3}`:

```
Media: 6.0
Sufficienti: 4 su 7
```

---

## Livello 2 · Intermedio

### Esercizio 5 · Inversione dell'array

Crea `Ex05ReverseArray.java`: crea un array di 6 numeri interi e invertine l'ordine **senza creare un secondo array**. Stampa l'array prima e dopo con `Arrays.toString`.

Con l'array `{1, 2, 3, 4, 5, 6}`:

```
Array originale: [1, 2, 3, 4, 5, 6]
Array invertito: [6, 5, 4, 3, 2, 1]
```

Suggerimento: scambia il primo con l'ultimo, il secondo con il penultimo, e così via fino a metà array. Per scambiare due celle serve una variabile di appoggio.

### Esercizio 6 · Conta occorrenze

Crea `Ex06CountOccurrences.java`: crea un array di 10 numeri interi, chiedi all'utente con lo Scanner un numero da cercare e stampa quante volte compare nell'array.

Con l'array `{1, 3, 5, 3, 7, 3, 9, 2, 4, 6}`:

```
Numero da cercare: 3
Il numero 3 compare 3 volte
```

### Esercizio 7 · Secondo massimo

Crea `Ex07SecondMax.java`: crea un array di 10 numeri interi, tutti diversi, e trova il **secondo valore più grande** con un solo ciclo, senza usare `Arrays.sort`.

Con l'array `{5, 1, 9, 2, 6, 8, 3, 7, 4, 10}`:

```
Il valore massimo è: 10
Il secondo valore massimo è: 9
```

Suggerimento: tieni due variabili, `max` e `secondoMax`, inizializzate con i primi due elementi (il maggiore in `max`). Quando trovi un nuovo massimo, il vecchio `max` diventa `secondoMax`.

### Esercizio 8 · Elementi duplicati

Crea `Ex08Duplicates.java`: crea un array di 10 numeri interi e stampa, una volta sola, gli elementi che compaiono più di una volta.

Con l'array `{1, 2, 3, 4, 5, 6, 3, 8, 9, 1}`:

```
Elementi duplicati: 1 3
```

Suggerimento: per ogni elemento controlla con un secondo ciclo se compare anche in una posizione successiva. Per non stamparlo due volte quando compare tre o più volte, controlla anche che non sia già comparso in una posizione precedente.

---

## Livello 3 · Avanzato

### Esercizio 9 · Separa pari e dispari

Crea `Ex09SplitEvenOdd.java`: crea un array di 10 numeri interi e produci due nuovi array, uno con i numeri pari e uno con i dispari. Ogni array deve avere esattamente la dimensione necessaria (niente celle vuote).

Con l'array `{1, 2, 3, 4, 5, 6, 8, 8, 7, 10}`:

```
Pari:    [2, 4, 6, 8, 8, 10]
Dispari: [1, 3, 5, 7]
```

Suggerimento: prima conta quanti sono pari e quanti dispari, poi crea i due array della dimensione giusta e riempili con un secondo passaggio. Ogni array ha bisogno del suo indice di scrittura.

### Esercizio 10 · Matrice trasposta

Crea `Ex10Transpose.java`: crea una matrice 3x4 di numeri interi, costruisci in una nuova matrice 4x3 la sua **trasposta** (le righe diventano colonne e viceversa) e stampale entrambe.

```
Matrice originale (3x4):
   1   2   3   4
   5   6   7   8
   9  10  11  12

Matrice trasposta (4x3):
   1   5   9
   2   6  10
   3   7  11
   4   8  12
```

Suggerimento: l'elemento in riga `r` e colonna `c` finisce in riga `c` e colonna `r`. Per allineare i numeri usa `System.out.printf("%4d", n)`, che stampa `n` su 4 caratteri allineato a destra.

### Esercizio 11 · Somma diagonali

Crea `Ex11DiagonalSum.java`: crea una matrice quadrata 4x4 di numeri interi e calcola la somma della diagonale principale (da alto-sinistra a basso-destra) e della diagonale secondaria (da alto-destra a basso-sinistra). Basta un ciclo per ciascuna diagonale.

```
Matrice:
   1   2   3   4
   5   6   7   8
   9  10  11  12
  13  14  15  16

Diagonale principale: 1 + 6 + 11 + 16 = 34
Diagonale secondaria: 4 + 7 + 10 + 13 = 34
```

Suggerimento: sulla diagonale principale riga e colonna coincidono (`matrice[i][i]`); su quella secondaria la colonna è `n - 1 - i`.

### Esercizio 12 · Battaglia navale

Crea `Ex12Battleship.java`: una versione semplificata della battaglia navale.

**Regole:**
- Il campo di gioco è una griglia 5x5 rappresentata da un array 2D di `char`
- Il computer piazza una nave lunga 3 celle, orizzontale o verticale, in una posizione casuale
- Il giocatore non vede la nave e deve affondarla sparando colpi
- A ogni turno il giocatore inserisce riga e colonna con lo Scanner
- Se colpisce la nave stampa `Colpito!` e la cella diventa `X`; se manca stampa `Mancato!` e la cella diventa `O`
- L'acqua non ancora esplorata si stampa come `~`
- Se le coordinate sono fuori dalla griglia, o la cella è già stata colpita, il colpo non conta e si chiede di nuovo
- Il gioco termina quando tutte e tre le celle della nave sono colpite, e stampa il numero di colpi

Esempio di partita (la nave cambia a ogni esecuzione):

```
~ ~ ~ ~ ~
~ ~ ~ ~ ~
~ ~ ~ ~ ~
~ ~ ~ ~ ~
~ ~ ~ ~ ~

Inserisci riga (0-4): 2
Inserisci colonna (0-4): 3
Colpito!

~ ~ ~ ~ ~
~ ~ ~ ~ ~
~ ~ ~ X ~
~ ~ ~ ~ ~
~ ~ ~ ~ ~

Inserisci riga (0-4): 0
Inserisci colonna (0-4): 0
Mancato!

O ~ ~ ~ ~
~ ~ ~ ~ ~
~ ~ ~ X ~
~ ~ ~ ~ ~
~ ~ ~ ~ ~

Inserisci riga (0-4): 7
Inserisci colonna (0-4): 1
Coordinate fuori dalla griglia, riprova

Inserisci riga (0-4): 2
Inserisci colonna (0-4): 3
Hai già sparato qui, riprova

...

Inserisci riga (0-4): 4
Inserisci colonna (0-4): 3
Colpito!

O O O O O
O O O O O
O O O X O
O O O X O
O O O X ~

Nave affondata in 24 colpi!
```

**Suggerimenti:**
- Usa un array `char[][] campo` per la griglia visibile al giocatore, riempito di `'~'` con due cicli
- Usa un secondo array `char[][] navi` per memorizzare dove si trova la nave (`'N'`)
- Per la posizione casuale usa `(int) (Math.random() * k)`, che dà un intero da 0 a `k - 1`. La nave deve stare tutta nella griglia: se è orizzontale la colonna di partenza va da 0 a 2, se è verticale la riga di partenza va da 0 a 2
- Conta i colpi validi e quante celle della nave sono state colpite: il ciclo dei turni continua finché le celle colpite sono meno di 3
- Controlla le coordinate prima di usarle come indici, altrimenti arriva un'`ArrayIndexOutOfBoundsException`
- La stampa della griglia si ripete a ogni turno: conviene scriverla in un metodo `static void stampaCampo(char[][] campo)`
