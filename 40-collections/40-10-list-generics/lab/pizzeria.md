# Progetto — Il menù della pizzeria

Una pizzeria in stile americano vende pizze, drink e qualche articolo con il suo marchio (una maglietta e una tazza). Il programma gestisce il menù e gli ordini ai tavoli.

- Tutti i prodotti hanno un nome e un prezzo; pizze, topping e drink hanno anche le calorie. Tutte queste informazioni compaiono sul menù.
- Ogni pizza parte da una margherita (pomodoro e mozzarella, 4,99 €, 1104 kcal) e si arricchisce con dei **topping**, anche ripetuti: per esempio una margherita con doppio prosciutto. Prezzo e calorie della pizza sono quelli della base più quelli dei topping.
- Alcune combinazioni hanno un nome che compare sul menù: «Hawaiian» (prosciutto e ananas) e «Salame» (salame).

Il progetto è diviso in livelli: completatene uno e controllate l'output prima di passare al successivo.

---

## I prezzi in centesimi

I prezzi si tengono in **centesimi**, come `int`: 4,99 € è `499`. Con i `double` le somme di prezzi danno risultati come `6.7700000000000005`. Per stampare un prezzo usate questa classe, così com'è:

```java
public class Prezzi {

    public static String euro(int centesimi) {
        int cent = centesimi % 100;
        return centesimi / 100 + "," + (cent < 10 ? "0" : "") + cent + " €";
    }
}
```

`Prezzi.euro(499)` restituisce `"4,99 €"`.

---

## Livello 1 — I prodotti

- Un'interfaccia `MenuItem` con i metodi `String getNome()`, `int getPrezzo()`, `String rigaMenu()` (la riga stampata sul menù) e `String sezione()` (la sezione del menù: `"Pizze"`, `"Topping"`, `"Drink"` o `"Franchising"`).
- Una classe astratta `ProdottoAlimentare` che implementa `MenuItem`, con nome, prezzo e calorie. La sua `rigaMenu()` restituisce per esempio `Limonata 0,33 l - 128 kcal - 1,29 €`.
- Le sottoclassi `Topping` e `Drink`.
- Una classe `Franchising` che implementa `MenuItem` senza le calorie: `Tazza - 4,99 €`.

I prodotti del menù:

| Sezione | Nome | Prezzo (centesimi) | Calorie |
|---|---|---|---|
| Topping | Mozzarella | 69 | 92 |
| Topping | Prosciutto | 99 | 35 |
| Topping | Cipolla | 69 | 22 |
| Topping | Ananas | 79 | 24 |
| Topping | Salame | 99 | 86 |
| Drink | Acqua 0,5 l | 129 | 0 |
| Drink | Limonata 0,33 l | 129 | 128 |
| Drink | Vino 0,75 l | 749 | 607 |
| Franchising | Maglietta | 2199 | — |
| Franchising | Tazza | 499 | — |

---

## Livello 2 — Le pizze

- Una classe `Pizza` che estende `ProdottoAlimentare`. Il costruttore riceve solo il nome della combinazione (`"Margherita"`, `"Hawaiian"`...): prezzo e calorie della base sono costanti della classe.
- I topping stanno in una `List<Topping>`. Il metodo `aggiungi(Topping t)` aggiunge un topping e restituisce la pizza stessa (`return this;`), così si possono scrivere più aggiunte di seguito:

```java
Pizza hawaiian = new Pizza("Hawaiian").aggiungi(prosciutto).aggiungi(ananas);
```

- `getPrezzo()` e `getCalorie()` sommano la base e tutti i topping.
- La riga del menù elenca gli ingredienti: `Hawaiian (pomodoro, mozzarella, prosciutto, ananas) - 1163 kcal - 6,77 €`.

---

## Livello 3 — Il menù

Una classe `Menu` con una sola `List<MenuItem>`, un metodo `aggiungi(MenuItem voce)` e un metodo `stampa()` che stampa le quattro sezioni, nell'ordine Pizze, Topping, Drink, Franchising. I prodotti si possono aggiungere in qualsiasi ordine: è `stampa()` che li raggruppa, usando `sezione()`.

Output atteso:
```
== Pizze ==
Margherita (pomodoro, mozzarella) - 1104 kcal - 4,99 €
Hawaiian (pomodoro, mozzarella, prosciutto, ananas) - 1163 kcal - 6,77 €
Salame (pomodoro, mozzarella, salame) - 1190 kcal - 5,98 €

== Topping ==
Mozzarella - 92 kcal - 0,69 €
Prosciutto - 35 kcal - 0,99 €
Cipolla - 22 kcal - 0,69 €
Ananas - 24 kcal - 0,79 €
Salame - 86 kcal - 0,99 €

== Drink ==
Acqua 0,5 l - 0 kcal - 1,29 €
Limonata 0,33 l - 128 kcal - 1,29 €
Vino 0,75 l - 607 kcal - 7,49 €

== Franchising ==
Maglietta - 21,99 €
Tazza - 4,99 €

```

---

## Livello 4 — Gli ordini

- Una classe `Ordine` con il numero del tavolo e una `List<MenuItem>`: un ordine può contenere pizze, drink e articoli del franchising.
- `aggiungi(MenuItem voce)`, `int totale()` e `stampa()`.
- `boolean togli(String nome)` toglie la **prima** voce con quel nome e restituisce `true`, oppure `false` se il nome non c'è. Usate un `Iterator`.

Con un ordine per il tavolo 4 (una margherita con doppio prosciutto, due acque e una tazza), poi `togli("Tazza")` e `togli("Vino 0,75 l")`:
```
Ordine tavolo 4 (4 voci)
- Margherita: 6,97 €
- Acqua 0,5 l: 1,29 €
- Acqua 0,5 l: 1,29 €
- Tazza: 4,99 €
Totale: 14,54 €

Tolta la tazza? true
Tolto il vino? false
Ordine tavolo 4 (3 voci)
- Margherita: 6,97 €
- Acqua 0,5 l: 1,29 €
- Acqua 0,5 l: 1,29 €
Totale: 9,55 €
```

---

## Bonus (facoltativi)

- **Formato famiglia:** un metodo `formatoFamiglia()` nella pizza aggiunge 4,15 € al prezzo, raddoppia le calorie e aggiunge « (famiglia)» al nome. La pizza Salame in formato famiglia diventa `Salame (famiglia) (pomodoro, mozzarella, salame) - 2380 kcal - 10,13 €`.
- **Leggeri:** un metodo `sottoLeCalorie(int massimo)` del menù restituisce una `List<ProdottoAlimentare>` con i prodotti che non superano quel numero di calorie. Il franchising non ha calorie e non va considerato: usate `instanceof`.
- **Cerca:** un metodo del menù che riceve un pezzo di nome e restituisce la lista delle voci che lo contengono.

---

## Consegna

Una cartella `pizzeria` con un file per classe e un `Main` che costruisce il menù, lo stampa e prova un ordine.
