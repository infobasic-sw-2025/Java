# Esercizi — 10.50 Scanner e input

## Livello 1 — Base

### 10.50.10 — Saluto personalizzato
Leggi il nome dell'utente con `nextLine()` e stampa un saluto.

Input di esempio:
```
Mario
```
Output atteso:
```
Ciao, Mario!
```

---

### 10.50.20 — Somma di due numeri
Leggi due interi con `nextInt()` e stampa la loro somma.

Input di esempio:
```
7
3
```
Output atteso:
```
Somma: 10
```

---

### 10.50.30 — Scheda personale
Leggi nome (`nextLine()`), età (`nextInt()`) e città (`nextLine()`). Stampa una frase riepilogativa. Attenzione al newline residuo.

Input di esempio:
```
Alice
22
Roma
```
Output atteso:
```
Alice, 22 anni, vive a Roma
```

---

### 10.50.40 — Pari o dispari
Leggi un intero e stampa se è pari o dispari.

Input di esempio:
```
10
```
Output atteso:
```
10 è pari
```

---

## Livello 2 — Intermedio

### 10.50.50 — Media aritmetica
Leggi tre numeri `double` e stampa la media.

Input di esempio:
```
7.5
8.0
6.5
```
Output atteso:
```
Media: 7.333333333333333
```

---

### 10.50.60 — Calcolatrice semplice
Leggi due `double` e un'operazione (`+`, `-`, `*`, `/`). Stampa il risultato. Se l'operazione non è valida, stampa un messaggio di errore. Se si divide per zero, stampa un avviso.

Input di esempio:
```
12
3
/
```
Output atteso:
```
Risultato: 4.0
```

---

### 10.50.70 — Voto con validazione
Chiedi un voto intero tra 1 e 10. Se l'utente inserisce un valore fuori range o non numerico, chiedi di nuovo finché il voto non è valido.

Input di esempio:
```
0
abc
15
7
```
Output atteso:
```
Il voto deve essere tra 1 e 10
Inserisci un numero
Il voto deve essere tra 1 e 10
Voto registrato: 7
```

---

### 10.50.80 — Somma con sentinella
Leggi numeri interi finché l'utente inserisce `0`. Somma solo i positivi e stampa il totale. I valori non numerici vanno scartati con un messaggio.

Input di esempio:
```
5
-2
abc
4
0
```
Output atteso:
```
Valore non numerico, riprova
Somma dei numeri positivi: 9
```

---

## Livello 3 — Avanzato

### 10.50.90 — Contatore di vocali
Leggi una parola con `nextLine()` e stampa quante vocali contiene (a, e, i, o, u, maiuscole e minuscole).

Input di esempio:
```
Programmazione
```
Output atteso:
```
Numero di vocali: 6
```

---

### 10.50.100 — Indovina il numero
Genera un numero casuale tra 1 e 100 con `(int)(Math.random() * 100) + 1`. L'utente inserisce tentativi finché non indovina. Ad ogni tentativo stampa "Troppo alto" o "Troppo basso". Alla fine stampa il numero di tentativi.

Input di esempio (se il numero è 42):
```
50
25
42
```
Output atteso:
```
Troppo alto
Troppo basso
Indovinato in 3 tentativi!
```

---

### 10.50.110 — Menu con operazioni
Crea un menu testuale con queste opzioni:
1. Saluta (chiede il nome e saluta)
2. Somma (chiede due interi e stampa la somma)
3. Fattoriale (chiede un intero positivo e stampa il fattoriale)
0. Esci

Il menu si ripete finché l'utente non sceglie 0. Le scelte non valide mostrano un messaggio di errore.

---

### 10.50.120 — Statistiche di una serie
Leggi numeri interi finché l'utente inserisce `0`. Al termine stampa: quanti numeri sono stati inseriti, la somma, la media, il valore minimo e il valore massimo. I valori non numerici vanno scartati.

Input di esempio:
```
10
3
7
25
4
0
```
Output atteso:
```
Numeri inseriti: 5
Somma: 49
Media: 9.8
Minimo: 3
Massimo: 25
```
