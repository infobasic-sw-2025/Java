# 10.20 Laboratorio · Variabili ed operatori

Lavora da terminale con `javac` e `java`, nella forma classica: una classe con `public static void main(String[] args)`.

---

## Livello 1 · Base

### Esercizio 1 · Scheda personale

Crea `PersonalCard.java`. Dichiara una variabile per ciascun dato, scegliendo il tipo più adatto:
- nome (testo);
- iniziale del cognome (un solo carattere);
- età (numero intero);
- altezza in metri (numero decimale);
- se sei uno studente (vero o falso);
- città, dichiarata con `var`.

Dichiara anche la costante `ANNO_CORRENTE` con `final` e calcola l'anno di nascita.

```
Nome: Anna R.
Età: 22 anni
Anno di nascita: 2004
Altezza: 1.68 m
Studente: true
Città: Torino
```

Poi prova a riassegnare `ANNO_CORRENTE` e a mettere un numero nella variabile della città. Che errori dà javac?

### Esercizio 2 · Scambio di variabili

Crea `Swap.java`. Con `int a = 5;` e `int b = 8;`, scambia i valori delle due variabili e stampali prima e dopo.

```
Prima: a = 5, b = 8
Dopo:  a = 8, b = 5
```

**Suggerimento:** `a = b; b = a;` non funziona. Perché? Disegna il diagramma di stato.

### Esercizio 3 · La media dei voti

Crea `Average.java`. Con tre voti interi, 7, 8 e 8, calcola la media e salvala in un `double`.

```
Media: 7.666666666666667
Media arrotondata: 7.7
```

Se ottieni `7.0`, cerca il motivo. Per arrotondare a un decimale usa `Math.round`.

### Esercizio 4 · Le iniziali

Crea `Initials.java` con due variabili `char`, `'M'` e `'R'`. Prima di eseguire, prevedi cosa stampano queste tre righe:

```java
System.out.println(nome + cognome);
System.out.println(nome + "." + cognome + ".");
System.out.println("" + nome + cognome);
```

---

## Livello 2 · Intermedio

### Esercizio 5 · Da secondi a ore, minuti e secondi

Crea `TimeConverter.java`. Data la variabile `int totaleSecondi = 10000;`, calcola ore, minuti e secondi usando solo `/` e `%`.

```
10000 secondi = 2 ore, 46 minuti e 40 secondi
```

### Esercizio 6 · Celsius e Fahrenheit

Crea `TemperatureConverter.java`. La formula è `F = C × 9 / 5 + 32`. Con `int celsius = 25;` calcola i gradi Fahrenheit in tre modi e salva ogni risultato in un `double`:

```java
celsius * (9 / 5) + 32
celsius * 9 / 5 + 32
celsius * (9.0 / 5) + 32
```

Prima di eseguire, scrivi su un foglio i tre risultati che ti aspetti. Poi esegui e rispondi:
1. Perché il primo è sbagliato?
2. Il secondo è giusto con 25 °C. È giusto anche con 37 °C?

### Esercizio 7 · Lo scontrino

Crea `ShoppingReceipt.java`. Il carrello contiene:

| Articolo | Prezzo | Quantità |
|---|---|---|
| Pane | 2.50 | 2 |
| Latte | 1.29 | 3 |
| Caffè | 4.99 | 1 |

Usa due costanti, `SCONTO = 0.10` e `IVA = 0.22`. Calcola e stampa:
- il numero di articoli;
- l'imponibile (prezzo × quantità, sommati);
- l'importo scontato del 10%;
- il totale con l'IVA;
- il totale arrotondato a due decimali, con `Math.round`.

```
Da pagare: 15.22 euro
```

### Esercizio 8 · Divisibilità e anni bisestili

Crea `LeapYear.java`. Un anno è bisestile se è divisibile per 4 ma non per 100, oppure se è divisibile per 400. Scrivi la condizione con `%`, `==`, `!=`, `&&` e `||`, e salva il risultato in un `boolean` per gli anni 2024, 1900, 2000 e 2026.

```
2024 bisestile: true
1900 bisestile: false
2000 bisestile: true
2026 bisestile: false
```

### Esercizio 9 · Cosa stampa?

Senza eseguire, scrivi su un foglio cosa stampa ciascuna riga. Poi copia il codice in `PredictTheOutput.java`, esegui e confronta. Per ogni risposta sbagliata, spiega il motivo.

```java
int x = 10;
System.out.println(x++ + ++x);                  // 1
System.out.println(x);                          // 2
System.out.println(17 / 4 * 4 + 17 % 4);        // 3
System.out.println(5 / 2 * 2.0);                // 4
System.out.println("Java" + 2 + 5);             // 5
System.out.println(2 + 5 + "Java");             // 6
System.out.println('a' + 'b');                  // 7
System.out.println("" + 'a' + 'b');             // 8
System.out.println((int) 3.99 + (int) -3.99);   // 9
System.out.println((byte) 130);                 // 10
System.out.println(0.1 + 0.2 == 0.3);           // 11
```

---

## Livello 3 · Avanzato

### Esercizio 10 · La somma delle cifre

Crea `DigitSum.java`. Dato `int numero = 4827;`, ricava le quattro cifre usando solo `/` e `%`, poi calcolane la somma.

```
Cifre: 4 8 2 7
Somma delle cifre: 21
```

### Esercizio 11 · Il resto in monete

Crea `Coins.java`. Un distributore deve dare un resto di 476 centesimi con il minor numero di monete: 2 €, 1 €, 50, 20, 10, 5, 2 e 1 centesimo. Calcola quante monete di ogni tipo servono.

```
2 euro: 2
1 euro: 0
50 cent: 1
20 cent: 1
10 cent: 0
5 cent: 1
2 cent: 0
1 cent: 1
```

**Suggerimento:** dopo ogni moneta, il resto si aggiorna con `%`.

### Esercizio 12 · Caccia all'errore

Copia questo codice in `FixTheErrors.java`. Non compila: correggilo leggendo i messaggi di javac, un errore alla volta. Attenzione: c'è anche un errore che il compilatore non vede, perché il codice è valido ma il risultato è sbagliato.

```java
public class FixTheErrors {
    public static void main(String[] args) {
        long popolazione = 3000000000;
        float prezzo = 19.99;
        int metri = 1250;
        int chilometri = metri / 1000.0;
        byte livello = 100;
        livello = livello + 1;
        final int MASSIMO = 50;
        MASSIMO = MASSIMO + 10;
        double media = (7 + 8) / 2;
        boolean promosso = media >= 6
        String messaggio = 'Media: ' + media;

        System.out.println(popolazione + " " + prezzo + " " + chilometri + " " + livello);
        System.out.println(MASSIMO + " " + messaggio + " " + promosso);
    }
}
```

Il programma corretto stampa la media giusta, 7.5. Il punteggio, `MASSIMO + 10`, va salvato in una nuova variabile.

### Esercizio 13 · Numeri grandi e overflow

Crea `BigNumbers.java` e calcola:
1. i secondi in 100 anni (365 giorni l'anno), prima in un `int` e poi in un `long`;
2. i millisecondi in un anno, salvati in un `long`:

```java
long ms = 365 * 24 * 3600 * 1000;
```

Il secondo calcolo usa già un `long`, eppure il risultato è sbagliato. Perché? Correggilo cambiando un solo carattere.
