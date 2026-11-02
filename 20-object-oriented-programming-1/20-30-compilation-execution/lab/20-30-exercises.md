# Lab 20.30 — Compilazione e organizzazione del codice

Tutti gli esercizi si svolgono dal terminale, con `javac` e `java`.
Non usare l'IDE per compilare.

---

## Esercizio 1 — Due classi senza package

Crea due file nella stessa cartella:

- `Persona.java`: attributi `nome` (String) e `eta` (int), un costruttore e
  un metodo `toString()` che restituisce `"nome (eta anni)"`
- `TestPersona.java`: nel `main` crea due oggetti `Persona` e stampali

Compila con `javac *.java` ed esegui con `java TestPersona`.

---

## Esercizio 2 — Separare src e out

Sposta i file dell'esercizio 1 in una cartella `src/`.
Compila con `javac -d out src/*.java`, poi esegui con `java -cp out TestPersona`.

Controlla che i file `.class` siano dentro `out/`.

---

## Esercizio 3 — Nome del file sbagliato

Crea un file chiamato `animale.java` (con la a minuscola) che contiene
`public class Animale { }`. Prova a compilare e leggi l'errore.
Poi correggi il problema.

---

## Esercizio 4 — Un package semplice

Crea questa struttura:

```
src/
  geometria/
    Cerchio.java
  TestCerchio.java
```

- `Cerchio.java`: package `geometria`, attributo `raggio` (double),
  metodo `area()` che restituisce `Math.PI * raggio * raggio`
- `TestCerchio.java`: importa `geometria.Cerchio`, crea un cerchio di
  raggio 5 e stampa l'area

Compila con `javac -d out src/geometria/Cerchio.java src/TestCerchio.java`.
Esegui con `java -cp out TestCerchio`.

---

## Esercizio 5 — Due package

Crea questa struttura:

```
src/
  modello/
    Prodotto.java
  servizio/
    Inventario.java
  Main.java
```

- `Prodotto.java`: package `modello`, attributi `nome` (String) e
  `prezzo` (double), costruttore e `toString()`
- `Inventario.java`: package `servizio`, importa `modello.Prodotto`, contiene
  un array di `Prodotto`, un metodo `aggiungi(Prodotto p)` e un metodo
  `stampaListino()` che stampa tutti i prodotti
- `Main.java`: importa le due classi, aggiunge 3 prodotti e stampa il listino

Compila e controlla che la struttura di `out/` rispecchi i package.

---

## Esercizio 6 — Import con l'asterisco

Modifica l'esercizio 5: in `Main.java` sostituisci i due import con
`import modello.*;` e `import servizio.*;`. Ricompila e controlla che il
programma funzioni come prima.

---

## Esercizio 7 — Package e cartella diversi

Crea il file `src/dati/Contatto.java`:

```java
package info;

public class Contatto {
    public String email;
}
```

e il file `src/Rubrica.java`:

```java
import dati.Contatto;

public class Rubrica {
    public static void main(String[] args) {
        Contatto c = new Contatto();
        c.email = "anna@example.com";
        System.out.println(c.email);
    }
}
```

Compila con `javac -d out src/dati/Contatto.java src/Rubrica.java` e leggi
l'errore. Dentro `out/`, in quale cartella è finito `Contatto.class`?
Trova il problema e correggilo in due modi diversi.

---

## Esercizio 8 — Cannot find symbol

Crea due file nella stessa cartella, senza package:

- `Motore.java` con un metodo `accendi()` che stampa `Motore acceso`
- `Auto.java` con un `main` che crea un `Motore` e chiama `accendi()`

1. Compila solo `Auto.java` con `javac Auto.java`. Funziona? Quali file
   `.class` trovi nella cartella?
2. Cancella `Motore.java` e compila di nuovo `Auto.java`. Cosa succede, e perché?
3. Cancella anche `Motore.class` e compila ancora. Cosa succede adesso?

---

## Esercizio 9 — Il classpath sbagliato

Compila i file dell'esercizio 4 con `javac -d out ...`.
Poi prova a eseguire con `java TestCerchio`, senza `-cp out`.
Leggi l'errore e spiega perché succede.

---

## Esercizio 10 — Creare un JAR

Parti dall'esercizio 5, già compilato in `out/`:

1. Crea un JAR: `jar --create --file app.jar -C out/ .`
2. Eseguilo con `java -cp app.jar Main`
3. Crea un JAR eseguibile aggiungendo `--main-class Main`
4. Eseguilo con `java -jar app.jar`

---

## Esercizio 11 — Progetto completo

Crea un progetto con questa struttura:

```
src/
  scuola/
    modello/
      Studente.java
      Corso.java
    app/
      Main.java
```

- `Studente`: package `scuola.modello`, attributi `nome` e `matricola`
- `Corso`: package `scuola.modello`, attributi `nome` e un array di `Studente`,
  metodi `aggiungi(Studente s)` e `stampa()`
- `Main`: package `scuola.app`, crea un corso, aggiunge 3 studenti e lo stampa

Compila con `javac -d out src/scuola/modello/*.java src/scuola/app/Main.java`.
Esegui con `java -cp out scuola.app.Main`.

---

## Esercizio 12 — Indagine sugli errori

Il progetto dell'esercizio 11 è già compilato in `out/`. Per ogni comando,
lanciato dalla cartella del progetto, prevedi se funziona o se dà errore.
Poi controlla al terminale.

1. `java -cp out Main`
2. `java -cp out scuola.app.Main`
3. `java -cp out scuola/app/Main`
4. `java scuola.app.Main`
5. `java -cp out scuola.app.Main.class`
6. `javac src/scuola/app/Main.java`
