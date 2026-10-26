# Esercizio 1 · Configurazione
# Obiettivo: configurare Git una volta per computer e controllare il risultato

git config --global user.name "Mario Rossi"
git config --global user.email "12345678+mariorossi@users.noreply.github.com"
git config --global init.defaultBranch main
git config --global pull.rebase false

git config --global --list
# → user.name=Mario Rossi
# → user.email=12345678+mariorossi@users.noreply.github.com
# → init.defaultbranch=main
# → pull.rebase=false

git config user.email
# → 12345678+mariorossi@users.noreply.github.com
