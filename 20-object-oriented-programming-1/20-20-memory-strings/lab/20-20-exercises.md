# 20.20 Laboratorio · Memoria e stringhe

Nota: `printf` e `String.format` scrivono i decimali con la virgola se il sistema è in italiano (`8,50`) e con il punto se è in inglese (`8.50`). Gli output qui sotto sono quelli di un sistema in italiano.

## Livello 1 · Base

### Esercizio 1 · Riferimenti e copie

Creare `References.java`. Dichiarare un array di interi `{10, 20, 30, 40, 50}` e assegnarlo a una seconda variabile `b`. Modificare il primo elemento tramite `b` e stampare l'array originale.

Poi creare una copia indipendente con `Arrays.copyOf`, modificarla e mostrare che l'originale non cambia.

```
Dopo la modifica tramite b: [99, 20, 30, 40, 50]
Dopo la modifica della copia: [99, 20, 30, 40, 50]
Copia modificata: [0, 20, 30, 40, 50]
```

### Esercizio 2 · Null safe

Creare `NullSafe.java` con un metodo `static void stampaLunghezza(String s)` che stampa la lunghezza della stringa ricevuta. Se la stringa è `null`, stampare "La stringa è null" senza causare una `NullPointerException`.

Provarlo con `"Ciao"`, `""` e `null`:

```
Lunghezza di 'Ciao': 4
Lunghezza di '': 0
La stringa è null
```

### Esercizio 3 · Confronto tra stringhe

Creare `StringComparison.java` con tre stringhe:
- `a` con il letterale `"Java"`
- `b` con il letterale `"Java"`
- `c` con `new String("Java")`

Stampare il risultato di `==` e di `equals()` per tutte le coppie (a-b, a-c, b-c) e spiegare ogni risultato con un commento.

### Esercizio 4 · Analisi di una frase

Creare `SentenceAnalysis.java`. Chiedere all'utente una frase con `Scanner` e stampare:
- il numero di caratteri
- il numero di parole (suggerimento: `split(" ")`)
- la frase in maiuscolo
- la frase in minuscolo
- la frase al contrario (con `StringBuilder`)

Con la frase `Ciao Mondo Bello`:

```
Caratteri: 16
Parole: 3
Maiuscolo: CIAO MONDO BELLO
Minuscolo: ciao mondo bello
Al contrario: olleB odnoM oaiC
```

---

## Livello 2 · Intermedio

### Esercizio 5 · Vocali e consonanti

Creare `VowelCount.java`. Chiedere all'utente una stringa, poi contare e stampare il numero di vocali e di consonanti. Contano solo le lettere: spazi, cifre e punteggiatura si ignorano. Maiuscole e minuscole valgono allo stesso modo.

Suggerimento: `"aeiou".indexOf(c)` restituisce `-1` se il carattere `c` non è una vocale; lo stesso vale con una stringa che contiene tutte le lettere dell'alfabeto.

Con la stringa `Programmazione Java`:

```
Vocali: 8
Consonanti: 10
```

### Esercizio 6 · Palindromo

Creare `Palindrome.java` con un metodo `static boolean isPalindromo(String s)` che restituisce `true` se la stringa è un palindromo, cioè si legge uguale da sinistra a destra e da destra a sinistra. Ignorare maiuscole, minuscole e spazi.

Provarlo con `"anna"`, `"Java"` e `"i topi non avevano nipoti"`:

```
'anna' è palindromo? true
'Java' è palindromo? false
'i topi non avevano nipoti' è palindromo? true
```

### Esercizio 7 · Sostituisci le vocali

Creare `ReplaceVowels.java` con un metodo `static String sostituisciVocali(String s, char sostituto)` che restituisce una nuova stringa in cui ogni vocale è sostituita dal carattere `sostituto`.

Con `"Programmazione"` e `'*'`:

```
Originale: Programmazione
Risultato: Pr*gr*mm*z**n*
```

### Esercizio 8 · Parser CSV

Creare `CsvParser.java`. Data la stringa `"Mario Rossi,25,Roma,8.5"`, separare i campi con `split(",")`, convertire età e media nei tipi corretti (`int` e `double`) e stampare i dati con `printf`:

```
Nome:  Mario Rossi
Età:   25
Città: Roma
Media: 8,50
```

---

## Livello 3 · Avanzato

### Esercizio 9 · Iniziali

Creare `Initials.java` con un metodo `static String iniziali(String nomeCompleto)` che riceve un nome completo (per esempio `"Mario Rossi"`) e restituisce le iniziali in maiuscolo (`"MR"`).

Provarlo con `"Mario Rossi"`, `"anna maria verdi"` e `"Leonardo"`:

```
Mario Rossi → MR
anna maria verdi → AMV
Leonardo → L
```

### Esercizio 10 · StringBuilder: una tabella

Creare `StudentTable.java`. Usare `StringBuilder` per costruire una tabella con i dati di 3 studenti: nome, età e media con un decimale. Ogni riga si formatta con `String.format()`.

Suggerimento: un numero tra `%` e la lettera fissa la larghezza del campo. `%-15s` scrive la stringa su 15 caratteri allineata a sinistra, `%3d` l'intero su 3 caratteri allineato a destra, `%5.1f` il decimale su 5 caratteri con una cifra dopo la virgola.

```
+-----------------+-----+-------+
| Nome            | Età | Media |
+-----------------+-----+-------+
| Alice           |  20 |   8,5 |
| Bob             |  22 |   7,3 |
| Carol           |  21 |   9,0 |
+-----------------+-----+-------+
```

### Esercizio 11 · Frequenza delle lettere

Creare `CharFrequency.java`. Chiedere all'utente una stringa e stampare quante volte compare ogni lettera, in ordine alfabetico. Tutto in minuscolo; spazi e simboli si ignorano.

Suggerimento: usare un array di 26 contatori, uno per lettera. La posizione di una lettera è il suo indice nella stringa `"abcdefghijklmnopqrstuvwxyz"`, che si trova con `indexOf`.

Con la stringa `Ciao Mondo`:

```
a: 1
c: 1
d: 1
i: 1
m: 1
n: 1
o: 3
```

### Esercizio 12 · Cifrario di Cesare

Creare `CaesarCipher.java` con due metodi:
- `static String cifra(String testo, int spostamento)`: sposta ogni lettera in avanti di `spostamento` posizioni nell'alfabeto, ripartendo dalla A dopo la Z
- `static String decifra(String testo, int spostamento)`: l'operazione inversa

Le maiuscole restano maiuscole e le minuscole restano minuscole; spazi e punteggiatura non cambiano.

Suggerimento: come nell'esercizio 11, la posizione di una lettera si trova con `indexOf` in una stringa con l'alfabeto (una per le minuscole, una per le maiuscole), e `%` riporta all'inizio dopo la Z.

Con `"Ciao Mondo"` e spostamento 3:

```
Originale: Ciao Mondo
Cifrato:   Fldr Prqgr
Decifrato: Ciao Mondo
```
