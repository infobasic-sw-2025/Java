# 20.20 Soluzioni · Memoria e stringhe

Ogni esercizio ha la sua cartella con un solo file, che compila da solo. Le soluzioni sono verificate con Oracle JDK 25.0.4.1 e con `javac --release 17`:

```
cd ex01-references
javac References.java
java References
```

Gli esercizi 4, 5 e 11 leggono una riga da tastiera; per provarli senza scrivere: `echo "Ciao Mondo" | java CharFrequency`. Le soluzioni usano solo quello che si è visto finora: niente metodi della classe `Character` e niente calcoli sui codici dei caratteri; per sapere se un carattere è una lettera, e quale, si usa `indexOf` su una stringa con l'alfabeto.

Gli output sono quelli di un sistema in italiano: `printf` e `String.format` scrivono i decimali con la virgola (`8,50`). Con il sistema in inglese escono con il punto (`8.50`). `println` di un `double` usa sempre il punto.

## Esercizio 1 · Riferimenti e copie
`ex01-references/References.java`. `int[] b = originale` copia il riferimento: c'è un solo array nello heap con due nomi, quindi `b[0] = 99` si vede anche da `originale`. `Arrays.copyOf` (10.70) crea un array nuovo: modificare la copia non tocca l'originale, che resta con il 99 della prima modifica.

```
Dopo la modifica tramite b: [99, 20, 30, 40, 50]
Dopo la modifica della copia: [99, 20, 30, 40, 50]
Copia modificata: [0, 20, 30, 40, 50]
```

## Esercizio 2 · Null safe
`ex02-null-safe/NullSafe.java`. Il controllo `s == null` va fatto prima di chiamare `s.length()`. La stringa vuota `""` non è `null`: è un oggetto con zero caratteri, e `length()` restituisce 0.

```
Lunghezza di 'Ciao': 4
Lunghezza di '': 0
La stringa è null
```

## Esercizio 3 · Confronto tra stringhe
`ex03-string-comparison/StringComparison.java`.
- `a == b` è `true`: i due letterali uguali sono un solo oggetto nel String pool
- `a == c` e `b == c` sono `false`: `new String("Java")` crea un oggetto nuovo nello heap, fuori dal pool
- `equals` è sempre `true`: confronta i caratteri, non i riferimenti

```
a == b:      true
a.equals(b): true
a == c:      false
a.equals(c): true
b == c:      false
b.equals(c): true
```

## Esercizio 4 · Analisi di una frase
`ex04-sentence-analysis/SentenceAnalysis.java`.
- I caratteri contati da `length()` comprendono gli spazi
- Le parole sono la lunghezza dell'array restituito da `split(" ")`, come suggerisce il testo. Con due spazi di fila `split` produce una parola vuota in mezzo: `Ciao  Mondo` (due spazi) risulta di 3 parole. Per frasi scritte normalmente il conteggio è giusto

Input `Ciao Mondo Bello`:

```
Inserisci una frase: Caratteri: 16
Parole: 3
Maiuscolo: CIAO MONDO BELLO
Minuscolo: ciao mondo bello
Al contrario: olleB odnoM oaiC
```

## Esercizio 5 · Vocali e consonanti
`ex05-vowel-count/VowelCount.java`.
- La stringa letta passa subito per `toLowerCase()`: così basta controllare le vocali minuscole
- I caratteri si scorrono con `toCharArray()` e il for-each
- Un carattere è una vocale se `"aeiou".indexOf(c) != -1`, una consonante se non è una vocale ma è nell'alfabeto. Tutto il resto (spazi, cifre, punteggiatura) non viene contato
- Le lettere accentate (`à`, `è`...) non sono nell'alfabeto di 26 lettere e vengono ignorate
- In `Programmazione Java` le vocali sono 8 (o, a, a, i, o, e, a, a) e le consonanti 10

Input `Programmazione Java`:

```
Inserisci una stringa: Vocali: 8
Consonanti: 10
```

## Esercizio 6 · Palindromo
`ex06-palindrome/Palindrome.java`. La stringa viene pulita con `toLowerCase()` e `replace(" ", "")`, poi invertita con `StringBuilder.reverse()` e confrontata con `equals`. Con `==` il confronto sarebbe sempre `false`, perché `toString()` crea una stringa nuova.

```
'anna' è palindromo? true
'Java' è palindromo? false
'i topi non avevano nipoti' è palindromo? true
```

## Esercizio 7 · Sostituisci le vocali
`ex07-replace-vowels/ReplaceVowels.java`. Il testo non dice se vale anche per le vocali maiuscole: qui sì, con la stringa `"aeiouAEIOU"`. Il risultato si costruisce con `StringBuilder`, carattere per carattere; la stringa originale non cambia.

```
Originale: Programmazione
Risultato: Pr*gr*mm*z**n*
```

## Esercizio 8 · Parser CSV
`ex08-csv-parser/CsvParser.java`. `split(",")` restituisce 4 stringhe; `Integer.parseInt` e `Double.parseDouble` convertono età e media. Nella stringa di partenza la media è `8.5` con il punto, perché `parseDouble` vuole il punto qualunque sia la lingua del sistema; è `printf` a stamparla con la virgola.

```
Nome:  Mario Rossi
Età:   25
Città: Roma
Media: 8,50
```

## Esercizio 9 · Iniziali
`ex09-initials/Initials.java`.
- Il nome si divide in parole con `split(" ")`; la prima lettera di ogni parola è `substring(0, 1)`, portata in maiuscolo con `toUpperCase()`
- Le parti vuote (due spazi di fila) si saltano con `isEmpty()`, altrimenti `substring(0, 1)` su una stringa vuota darebbe una `StringIndexOutOfBoundsException`

```
Mario Rossi → MR
anna maria verdi → AMV
Leonardo → L
```

## Esercizio 10 · StringBuilder: una tabella
`ex10-student-table/StudentTable.java`.
- I dati sono in tre array paralleli (nomi, età, medie): l'elemento `i` di ogni array è lo stesso studente
- Ogni riga è un `String.format` con le larghezze del suggerimento; `%n` va a capo dentro la stringa, le righe di separazione usano `append("\n")`
- L'intestazione usa `%3s` e `%5s` perché "Età" e "Media" sono stringhe
- `println` stampa la tabella una volta sola, alla fine, con `sb.toString()`

```
+-----------------+-----+-------+
| Nome            | Età | Media |
+-----------------+-----+-------+
| Alice           |  20 |   8,5 |
| Bob             |  22 |   7,3 |
| Carol           |  21 |   9,0 |
+-----------------+-----+-------+
```

## Esercizio 11 · Frequenza delle lettere
`ex11-char-frequency/CharFrequency.java`.
- `frequenze[0]` conta le `a`, `frequenze[25]` le `z`: la posizione è `alfabeto.indexOf(c)`, e `-1` vuol dire che il carattere non è una lettera
- La stampa scorre l'array dall'inizio, quindi le lettere escono in ordine alfabetico, e salta quelle a 0

Input `Ciao Mondo`:

```
Inserisci una stringa: a: 1
c: 1
d: 1
i: 1
m: 1
n: 1
o: 3
```

## Esercizio 12 · Cifrario di Cesare
`ex12-caesar-cipher/CaesarCipher.java`.
- Due costanti con l'alfabeto minuscolo e maiuscolo; `indexOf` dice in quale dei due sta il carattere, e in che posizione
- La nuova lettera è `charAt((pos + spostamento) % 26)`: con `x` (23) e spostamento 3 si arriva a 26, e `% 26` riporta a 0, cioè `a`
- `decifra` riusa `cifra`: tornare indietro di 3 è come andare avanti di 23. `spostamento % 26` tiene il conto giusto anche con spostamenti maggiori di 26
- Spazi e punteggiatura non sono in nessuno dei due alfabeti e vengono copiati così come sono

```
Originale: Ciao Mondo
Cifrato:   Fldr Prqgr
Decifrato: Ciao Mondo
```
