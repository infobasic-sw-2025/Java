# Esercizio 5 · Sotto il cofano
# Obiettivo: leggere commit, tree e blob e ricostruire la catena dei parent

cd calcolatrice

git cat-file -p HEAD             # → tree, parent, author, committer, messaggio
git cat-file -p HEAD^{tree}      # → una riga per file: 100644 blob <hash> nome
git cat-file -p HEAD:README.md   # → il contenuto del file
git cat-file -t HEAD             # → commit

# La catena: ogni riga è un commit, seguito dal suo parent
git log --format="%h  parent: %p  %s"
# → il commit feat: somma ha il parent vuoto: è il primo

# Risposte
# 1. Il commit senza parent è il primo, feat: somma
# 2. README.md non cambia dopo "docs: descrizione nel README" (HEAD~2): è lo stesso blob
git rev-parse HEAD:README.md HEAD~2:README.md   # → due hash uguali
# 3. Rifare lo stesso commit in un altro momento dà un hash diverso, perché cambia la data
