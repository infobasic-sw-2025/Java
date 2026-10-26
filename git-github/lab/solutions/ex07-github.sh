# Esercizio 7 · Pubblicare e clonare
# Obiettivo: collegare il repository a GitHub, pubblicarlo e lavorarci da una seconda copia
#
# Sostituire mariorossi con il proprio utente GitHub

cd calcolatrice
git remote add origin https://github.com/mariorossi/calcolatrice.git
git push -u origin main
# → * [new branch]      main -> main
# → branch 'main' set up to track 'origin/main'.

cd ..
git clone https://github.com/mariorossi/calcolatrice.git calcolatrice-copia
cd calcolatrice-copia
git log --oneline                # → gli stessi commit dell'originale
echo 'Uso: java Calcolatrice.java' >> README.md
git commit -am "docs: come si esegue"
git push

cd ../calcolatrice
git pull                         # → Fast-forward: arriva docs: come si esegue
git log --oneline -1             # → docs: come si esegue
