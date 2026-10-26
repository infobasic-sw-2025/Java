# Esercizio 9 · Branch e merge
# Obiettivo: sviluppare una funzionalità su un branch e portarla in main

cd calcolatrice
git switch -c modulo
cat > Modulo.java <<'JAVA'
public class Modulo {
    static int modulo(int a, int b) { return a % b; }
}
JAVA
git add Modulo.java
git commit -m "feat: modulo"

git switch main
ls                               # → Modulo.java non c'è: è solo sul branch modulo

git merge modulo                 # → Fast-forward, Modulo.java | 3 +++
ls                               # → ora Modulo.java c'è
git branch -d modulo             # → Deleted branch modulo
git push
