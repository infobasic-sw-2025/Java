# Esercizi — 10.60 Debugging

Ogni esercizio contiene un programma con uno o più errori. Per ciascuno:

1. crea il file con il nome indicato (il nome del file deve coincidere con il nome della classe) e copia il codice così com'è, errori compresi;
2. compila con `javac NomeFile.java` ed esegui con `java NomeClasse`;
3. leggi con attenzione ogni messaggio: riga, tipo di errore, freccia `^` che indica il punto;
4. correggi un errore alla volta, poi ricompila ed esegui di nuovo.

Ricorda le tre categorie di errore:

- **di compilazione**: `javac` rifiuta il programma e non produce il file `.class`;
- **di runtime**: il programma compila, ma durante l'esecuzione si interrompe con un'eccezione (`Exception in thread "main" ...`);
- **logico**: il programma compila e termina senza errori, ma il risultato è sbagliato.

Attenzione: `javac` non mostra sempre tutti gli errori in una volta. Prima controlla la sintassi (punti e virgola, parentesi...) e segnala solo quegli errori; i problemi di tipo e i nomi sconosciuti compaiono soltanto quando la sintassi è a posto. Dopo una correzione possono quindi comparire errori "nuovi" che prima non vedevi.

---

## Livello 1 — Base

### 10.60.10 — Errori di compilazione

Crea `Compilazione.java`.

**Consegna**: Il seguente programma non compila. Contiene 3 errori di compilazione: individuali e correggili. Alla prima compilazione `javac` ne segnala solo 2: perché? Il terzo compare quando hai corretto i primi due.

```java
public class Compilazione {
    public static void main(String[] args) {
        int numero = "10";
        System.out.println("Numero: " + numero)
        String messaggio = "Ciao"
    }
}
```

---

### 10.60.20 — Errori di runtime

Crea `RuntimeErrore.java`.

**Consegna**: Il seguente programma compila correttamente, ma si interrompe durante l'esecuzione. Spiega quale eccezione viene lanciata e perché, poi correggi il programma in modo che stampi `Lettere del nome: 5`.

`nome.length()` restituisce il numero di caratteri della stringa `nome`: ad esempio, `"Mario".length()` vale 5.

```java
public class RuntimeErrore {
    public static void main(String[] args) {
        String nome = null;
        System.out.println("Lettere del nome: " + nome.length());
    }
}
```

---

### 10.60.30 — Errore logico semplice

Crea `AreaRettangolo.java`.

**Consegna**: Il programma dovrebbe calcolare l'area di un rettangolo con base 5 e altezza 10, ma il risultato è sbagliato. Trova e correggi l'errore (risultato atteso: `Area: 50`).

```java
public class AreaRettangolo {
    public static void main(String[] args) {
        int base = 5;
        int altezza = 10;
        int area = base + altezza;
        System.out.println("Area: " + area);
    }
}
```

---

### 10.60.40 — Leggere lo stack trace

Crea `StackTrace.java`.

**Consegna**: Esegui il seguente programma. Leggi lo stack trace prodotto e rispondi: quale eccezione viene lanciata? In quale riga? Qual è la causa? Poi correggi il programma: se il divisore è 0, deve stampare `Impossibile dividere per zero` invece di interrompersi.

```java
public class StackTrace {
    public static void main(String[] args) {
        int a = 50;
        int b = 0;
        int risultato = a / b;
        System.out.println("Risultato: " + risultato);
    }
}
```

---

## Livello 2 — Intermedio

### 10.60.50 — Debugging con println

Crea `NumeriPari.java`.

**Consegna**: Il programma dovrebbe stampare i numeri pari da 2 a 10 (uno per riga), ma non funziona come previsto. Aggiungi stampe di debug con `System.out.println` (ad esempio il valore di `i` e di `i % 2` a ogni giro) per capire cosa non va, poi correggi l'errore e togli le stampe di debug.

```java
public class NumeriPari {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }
    }
}
```

---

### 10.60.60 — La media sbagliata

Crea `MediaVoti.java`.

**Consegna**: Il programma calcola la media di tre voti, ma stampa `Media: 27.0`. La media corretta di 28, 30 e 25 è 83 / 3 = 27,67 circa: Java stampa `Media: 27.666666666666668`. Usa println per trovare il problema e correggilo.

```java
public class MediaVoti {
    public static void main(String[] args) {
        int voto1 = 28;
        int voto2 = 30;
        int voto3 = 25;
        double media = (voto1 + voto2 + voto3) / 3;
        System.out.println("Media: " + media);
    }
}
```

---

### 10.60.70 — Bug multipli

Crea `Perimetro.java`.

**Consegna**: Il seguente programma contiene 3 errori: due di compilazione e uno logico. Trovali tutti e correggili. Il programma dovrebbe stampare il perimetro di un rettangolo con base 6 e altezza 4 (risultato atteso: `Perimetro: 20`).

```java
public class Perimetro {
    public static void main(String[] args) {
        int base = 6;
        int alteza = 4
        int perimetro = base * altezza;
        System.out.println("Perimetro: " + perimetro);
    }
}
```

---

### 10.60.80 — Somma con off-by-one

Crea `Somma.java`.

**Consegna**: Il programma dovrebbe calcolare la somma dei numeri da 1 a 10 (risultato atteso: `Somma: 55`), ma stampa `Somma: 45`. Trova l'errore, spiegalo e correggilo.

```java
public class Somma {
    public static void main(String[] args) {
        int somma = 0;
        for (int i = 0; i < 10; i++) {
            somma += i;
        }
        System.out.println("Somma: " + somma);
    }
}
```

---

## Livello 3 — Avanzato

### 10.60.90 — Caccia ai bug nel ciclo

Crea `Massimo.java`.

**Consegna**: Il programma chiede 5 numeri interi e dovrebbe stampare il più grande. Compila ed esegue senza errori, ma per certi input il risultato è sbagliato. Trova e correggi l'errore logico.

Prova prima con `3 7 2 9 4` (risultato atteso: `Massimo: 9`), poi con `-5 -2 -8 -1 -9` (risultato atteso: `Massimo: -1`).

```java
import java.util.Scanner;

public class Massimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Numero " + i + ": ");
            int numero = scanner.nextInt();
            if (numero > max) {
                max = numero;
            }
        }

        System.out.println("Massimo: " + max);
    }
}
```

Suggerimento: cosa succede se tutti i numeri inseriti sono negativi? Da quale valore dovrebbe partire `max`?

---

### 10.60.100 — Conteggio vocali

Crea `ContaVocali.java`.

**Consegna**: Il programma dovrebbe contare le vocali (maiuscole e minuscole) nella stringa `"Buongiorno Italia"`: il risultato atteso è `Vocali: 9`. Contiene due errori: uno di runtime e uno logico. Trovali e correggili.

Il programma usa due metodi delle stringhe:

- `testo.length()` restituisce il numero di caratteri: `"Buongiorno Italia".length()` vale 17 (lo spazio conta);
- `testo.charAt(i)` restituisce il carattere in posizione `i`. Le posizioni partono da 0, quindi vanno da `0` a `testo.length() - 1`.

```java
public class ContaVocali {
    public static void main(String[] args) {
        String testo = "Buongiorno Italia";
        int contatore = 0;

        for (int i = 0; i <= testo.length(); i++) {
            char c = testo.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                contatore++;
            }
        }

        System.out.println("Vocali: " + contatore);
    }
}
```

---

### 10.60.110 — Programma completo da correggere

Crea `MediaInterattiva.java`.

**Consegna**: Il seguente programma dovrebbe chiedere 5 voti all'utente, calcolarne la media e dire se è sufficiente (media `>= 18`). Contiene 4 errori. Trovali, classificali (compilazione, runtime o logico) e correggili uno alla volta.

Per verificare la correzione inserisci i voti 28, 30, 25, 27 e 29: il programma deve stampare `Media: 27.8` e `Sufficiente`.

```java
import java.util.Scanner;

public class MediaInterattiva {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int somma = 0;
        int conteggio = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Inserisci il voto " + i + ": ")
            int voto = scanner.nextInt();
            somma += voto;
        }

        double media = somma / conteggio;
        System.out.println("Media: " + media);

        if (media = 18) {
            System.out.println("Sufficiente");
        } else {
            System.out.println("Insufficiente");
        }
    }
}
```

---

### 10.60.120 — Scrivi, rompi, ripara

Crea `FabbricaBug.java`.

**Consegna**: Scrivi un programma `FabbricaBug` che:

1. dichiari `int n = 5;`
2. calcoli con un ciclo `for` la somma dei numeri da 1 a `n`
3. calcoli la media di quei numeri come `double`
4. stampi somma e media

Output atteso:

```
Somma: 15
Media: 3.0
```

Quando il programma funziona, introduci intenzionalmente un bug alla volta, ripristinando la versione corretta prima di passare al successivo:

- un errore di compilazione
- un errore di runtime
- un errore logico

Per ogni bug, **prima** di compilare ed eseguire scrivi in un commento che cosa ti aspetti: quale messaggio del compilatore, quale eccezione o quale output sbagliato. Poi verifica: hai indovinato?

Se puoi, scambia il programma con un compagno di corso: ognuno cerca e corregge i bug dell'altro.
