# Esercizio 4 · Tornare indietro
# Obiettivo: usare il comando giusto per ogni errore

cd calcolatrice

# a) Modifica da buttare
echo '// prova' >> Calcolatrice.java
git restore Calcolatrice.java
git status                       # → nothing to commit, working tree clean

# b) File aggiunto per sbaglio
echo 'appunti' > appunti.txt
git add appunti.txt
git restore --staged appunti.txt
git status                       # → Untracked files: appunti.txt
rm appunti.txt

# c) Messaggio sbagliato
cat > Calcolatrice.java <<'JAVA'
public class Calcolatrice {
    static int somma(int a, int b) { return a + b; }
    static int sottrazione(int a, int b) { return a - b; }
    static int prodotto(int a, int b) { return a * b; }
    static double divisione(double a, double b) { return a / b; }

    public static void main(String[] args) {
        System.out.println(somma(2, 3));
        System.out.println(sottrazione(5, 3));
        System.out.println(prodotto(4, 3));
        System.out.println(divisione(7, 2));
    }
}
JAVA
git add Calcolatrice.java
git commit -m "feat: divsione"
git commit --amend -m "feat: divisione"
git log --oneline -1             # → feat: divisione (con un hash nuovo)

# d) Commit da annullare
git revert --no-edit HEAD
git log --oneline -2             # → Revert "feat: divisione", feat: divisione
