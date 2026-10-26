# Esercizio 2 · Il primo repository
# Obiettivo: creare un repository e salvare tre commit, uno per ogni passo

mkdir calcolatrice
cd calcolatrice
git init

cat > Calcolatrice.java <<'JAVA'
public class Calcolatrice {
    static int somma(int a, int b) { return a + b; }

    public static void main(String[] args) {
        System.out.println(somma(2, 3));
    }
}
JAVA
java Calcolatrice.java           # → 5
git status                       # → Untracked files: Calcolatrice.java
git add Calcolatrice.java
git status                       # → Changes to be committed: new file: Calcolatrice.java
git commit -m "feat: somma"

# Il metodo sottrazione e la sua chiamata nel main: due righe nuove
cat > Calcolatrice.java <<'JAVA'
public class Calcolatrice {
    static int somma(int a, int b) { return a + b; }
    static int sottrazione(int a, int b) { return a - b; }

    public static void main(String[] args) {
        System.out.println(somma(2, 3));
        System.out.println(sottrazione(5, 3));
    }
}
JAVA
git status                       # → Changes not staged for commit: modified: Calcolatrice.java
git diff                         # → le due righe nuove, con il +
git add Calcolatrice.java
git commit -m "feat: sottrazione"

echo '# Calcolatrice' > README.md
git add README.md
git commit -m "docs: README"

git log --oneline
# → 3 righe, dalla più recente: docs: README, feat: sottrazione, feat: somma
# Gli hash sono diversi per ognuno: dipendono anche da autore e data
