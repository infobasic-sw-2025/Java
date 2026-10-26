# Esercizio 6 · .gitignore
# Obiettivo: tenere i file compilati fuori dalla storia

cd calcolatrice

javac Calcolatrice.java
git status                       # → Untracked files: Calcolatrice.class

printf '*.class\nout/\n' > .gitignore
git status                       # → Untracked files: .gitignore (Calcolatrice.class sparito)

git add .gitignore
git commit -m "chore: .gitignore per i file compilati"
git status                       # → nothing to commit, working tree clean
