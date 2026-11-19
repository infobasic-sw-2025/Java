# 30.20 · Live coding dell'aula (2SW, 19/11/2026)

Versione scritta in aula, accanto all'esempio ufficiale `../interfaces-abstract/`. Rispetto a quello:

- le classi stanno in package: `forma_geometrica` per la classe astratta `Forma` con `Cerchio` e `Rettangolo`, `veicolo` per l'interfaccia `Motore` e `veicolo.impl` per le due implementazioni `Elettrico` e `Termico`
- `Motore` è usata come tipo: `Motore mE = new Elettrico();`
- nel for-each si assegna la variabile del ciclo (`fg = null`, poi `fg = new Cerchio(...)`): cambiare `fg` non cambia l'array, lo cambia solo `formeGeometriche[0] = fg`
- in fondo un'anticipazione della 40.10: `List` è un'interfaccia, `ArrayList` e `LinkedList` due implementazioni

Avvio dalla cartella `src`: `javac -d out $(find . -name '*.java')`, poi `java -cp out Main`. Compila con JDK 21 e JDK 25.

Note:

- `Cerchio` non ha `toString()`: `println(fg)` stampa `forma_geometrica.Cerchio@` seguito da un codice che cambia a ogni esecuzione
- `List motori = new ArrayList()` usa i raw type e `javac -Xlint` dà un warning: con i generics della 40.10 diventa `List<Motore> motori = new ArrayList<>();`
- il costruttore di `Forma` e il metodo astratto `area()` non hanno modificatore, quindi solo le classi del package `forma_geometrica` possono estenderla; con tutti e due `protected` la si estende anche da fuori
- per convenzione i nomi dei package non hanno underscore (`formageometrica`)
