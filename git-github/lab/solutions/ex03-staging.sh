# Esercizio 3 · Due modifiche, due commit
# Obiettivo: scegliere con git add che cosa entra in ogni commit

cd calcolatrice

cat > Calcolatrice.java <<'JAVA'
public class Calcolatrice {
    static int somma(int a, int b) { return a + b; }
    static int sottrazione(int a, int b) { return a - b; }
    static int prodotto(int a, int b) { return a * b; }

    public static void main(String[] args) {
        System.out.println(somma(2, 3));
        System.out.println(sottrazione(5, 3));
        System.out.println(prodotto(4, 3));
    }
}
JAVA
echo 'Somma, sottrazione e prodotto di due numeri' >> README.md
git status                       # → modified: Calcolatrice.java, modified: README.md

git add Calcolatrice.java
git status                       # → staged: Calcolatrice.java; non staged: README.md
git commit -m "feat: prodotto"

git add README.md
git commit -m "docs: descrizione nel README"

git show --stat HEAD~1           # → feat: prodotto, solo Calcolatrice.java | 2 ++
git show --stat HEAD             # → docs: descrizione nel README, solo README.md
