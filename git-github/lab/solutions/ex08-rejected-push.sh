# Esercizio 8 · Push rifiutato
# Obiettivo: lavorare in parallelo su due copie e unire le modifiche

cd calcolatrice-copia
cat > Calcolatrice.java <<'JAVA'
public class Calcolatrice {
    static int somma(int a, int b) { return a + b; }
    static int sottrazione(int a, int b) { return a - b; }
    static int prodotto(int a, int b) { return a * b; }
    static double potenza(double a, double b) { return Math.pow(a, b); }

    public static void main(String[] args) {
        System.out.println(somma(2, 3));
        System.out.println(sottrazione(5, 3));
        System.out.println(prodotto(4, 3));
        System.out.println(potenza(2, 10));
    }
}
JAVA
git commit -am "feat: potenza"
git push

cd ../calcolatrice
echo 'Metodi: somma, sottrazione, prodotto' >> README.md
git commit -am "docs: elenco dei metodi"
git push                         # → ! [rejected]        main -> main (fetch first)
git pull                         # → Merge made by the 'ort' strategy.
git push

git log --oneline --graph -4
# → *   Merge branch 'main' of https://github.com/mariorossi/calcolatrice
# → |\
# → | * feat: potenza
# → * | docs: elenco dei metodi
# → |/
