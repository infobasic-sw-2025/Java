# 10.40 Laboratorio · Metodi

Ogni metodo è `static` e va scritto nella stessa classe del `main` (per il momento). Usa la forma classica: `public static void main(String[] args)`.

---

## Livello 1 · Base

### Esercizio 1 · Saluto personalizzato

Crea `Greeting.java` con un metodo `static void saluta(String nome)` che stampa `Ciao, <nome>!`. Chiamalo dal main con tre nomi diversi.

```
Ciao, Alice!
Ciao, Bob!
Ciao, Carlo!
```

### Esercizio 2 · L'area del rettangolo

Crea `RectangleArea.java` con un metodo `static int area(int base, int altezza)` che restituisce l'area. Chiamalo dal main con due rettangoli diversi e stampa i risultati.

```
Area 1: 28
Area 2: 45
```

### Esercizio 3 · Pari o dispari

Crea `EvenOdd.java` con un metodo `static boolean isPari(int n)` che restituisce `true` se il numero è pari. Usalo dal main per stampare, per i numeri da 1 a 10, se sono pari o dispari.

```
1 è dispari
2 è pari
...
10 è pari
```

### Esercizio 4 · Il massimo tra due numeri

Crea `MaxOfTwo.java` con un metodo `static int massimo(int a, int b)` che restituisce il maggiore. Non usare `Math.max`: scrivi la logica con un `if`.

---

## Livello 2 · Intermedio

### Esercizio 5 · Conversione di temperatura

Crea `TemperatureMethods.java` con due metodi:
- `static double celsiusToFahrenheit(double c)` — formula: `c * 9.0 / 5 + 32`
- `static double fahrenheitToCelsius(double f)` — formula: `(f - 32) * 5.0 / 9`

Converti 0, 100 e 37 gradi Celsius in Fahrenheit, e 32, 212 e 98.6 Fahrenheit in Celsius.

### Esercizio 6 · Il metodo potenza

Crea `Power.java` con un metodo `static long potenza(int base, int esponente)` che calcola la potenza usando un ciclo `for`, senza usare `Math.pow`. Prova con `potenza(2, 10)` e `potenza(3, 5)`.

```
2^10 = 1024
3^5 = 243
```

### Esercizio 7 · Overloading: la somma

Crea `SumOverload.java` con tre versioni del metodo `somma`:
- `static int somma(int a, int b)`
- `static int somma(int a, int b, int c)`
- `static double somma(double a, double b)`

Chiamale tutte dal main e verifica che il compilatore scelga quella giusta.

### Esercizio 8 · Il numero primo

Crea `PrimeCheck.java` con un metodo `static boolean isPrimo(int n)` che restituisce `true` se il numero è primo. Usalo per stampare i numeri primi tra 2 e 50.

```
2 3 5 7 11 13 17 19 23 29 31 37 41 43 47
```

---

## Livello 3 · Avanzato

### Esercizio 9 · Il miniconvertitore

Crea `TimeFormatter.java` con un metodo `static String formattaTempo(int totaleSecondi)` che restituisce una stringa nel formato `"Xh Ym Zs"`. Un secondo metodo `static int tempoInSecondi(int ore, int minuti, int secondi)` fa la conversione inversa.

```
10000 secondi = 2h 46m 40s
1h 30m 0s = 5400 secondi
```

### Esercizio 10 · Il fattoriale

Crea `Factorial.java` con due versioni del fattoriale:
- `static long fattorialeIterativo(int n)` — con un ciclo
- `static long fattorialeRicorsivo(int n)` — il metodo chiama se stesso

Confronta i risultati per n da 1 a 15. Per quale valore di n il risultato diventa negativo? Perché?

### Esercizio 11 · Caccia all'errore

Copia questo codice in `FixMethods.java`. Non compila: correggilo leggendo i messaggi di javac, un errore alla volta.

```java
public class FixMethods {

    static int doppio(int n) {
        n * 2;
    }

    static boolean isPositivo(int n) {
        if (n > 0) {
            return true;
        }
    }

    static void saluta(String nome) {
        return "Ciao, " + nome;
    }

    public static void main(String[] args) {
        System.out.println(doppio(5));
        System.out.println(isPositivo(-3));
        saluta("Anna");
    }
}
```

### Esercizio 12 · Refactoring

Questo programma funziona ma ha codice ripetuto. Copia in `Refactor.java` e riscrivilo usando dei metodi.

```java
public class Refactor {
    public static void main(String[] args) {
        int a = 7, b = 3, c = 12;

        if (a % 2 == 0) {
            System.out.println(a + " è pari");
        } else {
            System.out.println(a + " è dispari");
        }

        if (b % 2 == 0) {
            System.out.println(b + " è pari");
        } else {
            System.out.println(b + " è dispari");
        }

        if (c % 2 == 0) {
            System.out.println(c + " è pari");
        } else {
            System.out.println(c + " è dispari");
        }
    }
}
```
