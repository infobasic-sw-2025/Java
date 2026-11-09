# 20.30 Soluzioni · Compilazione e organizzazione del codice

Le soluzioni sono verificate con Oracle JDK 25.0.4.1. Gli esercizi con il codice hanno la loro cartella; i comandi si lanciano dalla cartella dell'esercizio. Gli esercizi 3, 8, 9 e 12 sono di sola osservazione: qui sotto ci sono gli output reali.

## Esercizio 1 · Due classi senza package
`ex01-two-classes/`. `javac *.java` compila i due file e crea `Persona.class` e `TestPersona.class`.

```
$ javac *.java
$ java TestPersona
Marco (25 anni)
Laura (22 anni)
```

## Esercizio 2 · Separare src e out
Stessi file dell'esercizio 1, spostati in `src/`. Con `-d out` i `.class` finiscono in `out/` e i sorgenti restano puliti. Per eseguire serve `-cp out`, perché la JVM cerca i `.class` nella cartella corrente.

```
$ javac -d out src/*.java
$ java -cp out TestPersona
Marco (25 anni)
Laura (22 anni)
$ ls out
Persona.class      TestPersona.class
```

## Esercizio 3 · Nome del file sbagliato
Una classe `public` deve stare in un file con lo stesso nome, maiuscole comprese. La correzione è rinominare il file in `Animale.java`.

```
$ javac animale.java
animale.java:1: error: class Animale is public, should be declared in a file named Animale.java
public class Animale { }
       ^
1 error
```

## Esercizio 4 · Un package semplice
`ex04-package/`. `Cerchio.java` sta in `src/geometria/` e dichiara `package geometria;`. `-d out` ricrea la cartella del package: `out/geometria/Cerchio.class`.

```
$ javac -d out src/geometria/Cerchio.java src/TestCerchio.java
$ java -cp out TestCerchio
Area: 78.53981633974483
```

## Esercizio 5 · Due package
`ex05-two-packages/`. `Inventario` importa `modello.Prodotto`; `Main` importa sia `modello.Prodotto` sia `servizio.Inventario`.

```
$ javac -d out src/modello/Prodotto.java src/servizio/Inventario.java src/Main.java
$ find out -name "*.class"
out/Main.class
out/modello/Prodotto.class
out/servizio/Inventario.class
$ java -cp out Main
=== Listino ===
  Laptop - 899.99 EUR
  Mouse - 29.99 EUR
  Tastiera - 59.99 EUR
```

## Esercizio 6 · Import con l'asterisco
`import modello.*;` e `import servizio.*;` importano tutte le classi dei due package. Il programma compila e stampa lo stesso listino dell'esercizio 5.

## Esercizio 7 · Package e cartella diversi
`ex07-package-folder/` contiene la prima correzione. `javac` compila `Contatto.java` anche se è nella cartella sbagliata, ma la classe si chiama `info.Contatto` e finisce in `out/info/Contatto.class`. `Rubrica` cerca `dati.Contatto`, che non esiste:

```
$ javac -d out src/dati/Contatto.java src/Rubrica.java
src/Rubrica.java:1: error: package dati does not exist
import dati.Contatto;
           ^
src/Rubrica.java:5: error: cannot find symbol
        Contatto c = new Contatto();
        ^
  symbol:   class Contatto
  location: class Rubrica
src/Rubrica.java:5: error: cannot find symbol
        Contatto c = new Contatto();
                         ^
  symbol:   class Contatto
  location: class Rubrica
3 errors
```

Package e cartella devono coincidere. Le due correzioni:

1. Cambiare la dichiarazione in `package dati;`, come nella cartella `ex07-package-folder/`.
2. Lasciare `package info;`, spostare il file in `src/info/Contatto.java` e importare `info.Contatto` in `Rubrica`.

In entrambi i casi:

```
$ java -cp out Rubrica
anna@example.com
```

## Esercizio 8 · Cannot find symbol
1. `javac Auto.java` compila anche `Motore.java`, perché `Auto` lo usa e il file è nella stessa cartella. Nella cartella compaiono `Auto.class` e `Motore.class`; `java Auto` stampa `Motore acceso`.
2. Senza `Motore.java` la compilazione funziona ancora: `javac` trova `Motore.class`, già compilato, e gli basta.
3. Senza il sorgente e senza il `.class`, `javac` non trova più la classe:

```
$ javac Auto.java
Auto.java:3: error: cannot find symbol
        Motore m = new Motore();
        ^
  symbol:   class Motore
  location: class Auto
Auto.java:3: error: cannot find symbol
        Motore m = new Motore();
                       ^
  symbol:   class Motore
  location: class Auto
2 errors
```

## Esercizio 9 · Il classpath sbagliato
Senza `-cp` la JVM cerca `TestCerchio.class` nella cartella corrente, ma il file è in `out/`.

```
$ java TestCerchio
Error: Could not find or load main class TestCerchio
Caused by: java.lang.ClassNotFoundException: TestCerchio
```

## Esercizio 10 · Creare un JAR
Si parte da `ex05-two-packages/` compilato in `out/`. `-C out/ .` mette nel JAR tutto il contenuto di `out/`, con le cartelle dei package.

```
$ jar --create --file app.jar -C out/ .
$ java -cp app.jar Main
=== Listino ===
  Laptop - 899.99 EUR
  Mouse - 29.99 EUR
  Tastiera - 59.99 EUR
$ jar --create --file app.jar --main-class Main -C out/ .
$ java -jar app.jar
=== Listino ===
  Laptop - 899.99 EUR
  Mouse - 29.99 EUR
  Tastiera - 59.99 EUR
```

## Esercizio 11 · Progetto completo
`ex11-school-project/`. `Main` è nel package `scuola.app`, quindi si esegue con il nome completo.

```
$ javac -d out src/scuola/modello/*.java src/scuola/app/Main.java
$ java -cp out scuola.app.Main
=== Programmazione Java (3 iscritti) ===
  MAT001 - Marco Rossi
  MAT002 - Laura Bianchi
  MAT003 - Luca Verdi
```

## Esercizio 12 · Indagine sugli errori

| Comando | Risultato | Perché |
|---|---|---|
| `java -cp out Main` | errore | `Main` è nel package `scuola.app`: serve il nome completo |
| `java -cp out scuola.app.Main` | funziona | classpath giusto e nome completo |
| `java -cp out scuola/app/Main` | funziona | `java` accetta anche le barre, ma la forma corretta usa i punti |
| `java scuola.app.Main` | errore | senza `-cp out` la JVM cerca nella cartella corrente |
| `java -cp out scuola.app.Main.class` | errore | `java` vuole il nome della classe, senza estensione |
| `javac src/scuola/app/Main.java` | errore | `javac` cerca le classi importate dalla cartella corrente e non le trova in `src/` |

Il messaggio dei comandi 1, 4 e 5 è sempre `Error: Could not find or load main class`, seguito dal nome cercato. Il comando 6 dà `package scuola.modello does not exist`.
