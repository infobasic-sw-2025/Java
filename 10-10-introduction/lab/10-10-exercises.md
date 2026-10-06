# 10.10 Laboratorio · Primi programmi

Lavora da terminale con il JDK 25 installato sulla tua macchina: controlla con `java -version`.

---

## Esercizio 1 · Il tuo nome, forma classica

Crea il file `HelloName.java` con la forma classica di un programma Java (quella usata fino a Java 21 ma valida anche in Java 25): una classe `HelloName` con il metodo `public static void main(String[] args)`.

Il programma deve:
- salvare il tuo nome in una variabile di tipo `String`;
- stampare `Ciao, <tuo nome>!`, usando la variabile.

```
Ciao, Davide!
```

Compila con `javac HelloName.java` ed esegui con `java HelloName`.

---

## Esercizio 2 · Il tuo nome, forma compatta di Java 25

Riscrivi lo stesso programma nel file `HelloName25.java`, questa volta nella forma compatta di Java 25:
`void main()` al posto della classe e `IO.println` al posto di `System.out.println`.

Esegui direttamente il sorgente con `java HelloName25.java`.

Rispondi:
1. Quali parole della forma classica sono sparite?
2. Dopo l'esecuzione, nella cartella c'è un file `HelloName25.class`? Perché?

---

## Esercizio 3 · La tabellina del 2

Crea il file `TimesTable.java`, con la forma classica, che stampi la tabellina del 2, una riga per ogni
moltiplicazione:

```
2 x 1 = 2
2 x 2 = 4
...
2 x 10 = 20
```

Nota: il risultato non va scritto a mano, fallo calcolare a Java, con un'espressione come `2 * 3`.
Per ora scrivi una riga di codice per ogni moltiplicazione. 

**Bonus.** Prima di eseguirla, prova a prevedere cosa stampa questa riga:

```java
System.out.println("2 + 1 = " + 2 + 1);
```

Poi eseguila. Il risultato è quello che ti aspettavi? Come la correggi per ottenere `2 + 1 = 3`?

---

## Esercizio 4 · print senza ln

Copia `TimesTable.java` in un nuovo file `PrintWithoutLn.java`, rinomina la classe in `PrintWithoutLn` e
sostituisci `System.out.println` con `System.out.print` nelle prime tre righe (togli le altre).

Prima di eseguire, scrivi su un foglio cosa ti aspetti di vedere. Poi esegui e rispondi:
1. Cosa succede all'output?
2. Che differenza c'è tra `print` e `println`?
3. Dove compare il prompt del terminale dopo l'esecuzione? Perché?
