# Laboratorio · Git e GitHub

Tutti gli esercizi si fanno dal terminale: Git Bash su Windows, il Terminale su macOS e Linux. Gli hash dei commit sono diversi per ognuno, perché dipendono anche da autore e data: negli output qui sotto contano i messaggi, non gli hash.

Prima e dopo ogni comando, `git status`.

---

## Livello 1 · Git in locale

### Esercizio 1 · Configurazione

Configura Git con il tuo nome, l'email **noreply** di GitHub (Settings → Emails, nel formato `ID+utente@users.noreply.github.com`), `main` come branch iniziale e `pull.rebase false`. Poi controlla:

```
$ git config --global --list
user.name=Mario Rossi
user.email=12345678+mariorossi@users.noreply.github.com
init.defaultbranch=main
pull.rebase=false
```

**Suggerimento:** i comandi sono nella slide della configurazione. Se un valore è sbagliato, basta ripetere il comando con quello giusto.

### Esercizio 2 · Il primo repository

Crea la cartella `calcolatrice`, entraci e trasformala in un repository. Poi salva tre commit, uno per ogni passo:

1. `calcolatrice.js` con una funzione `somma` e un `console.log` che la usa → `feat: somma`
2. una funzione `sottrazione` aggiunta in fondo allo stesso file → `feat: sottrazione`. Prima del commit guarda la modifica con `git diff`
3. un file `README.md` con il titolo `# Calcolatrice` → `docs: README`

```
$ git log --oneline
051d709 docs: README
bba9247 feat: sottrazione
003c1a0 feat: somma
```

**Suggerimento:** `git add` prima di ogni `git commit`. Se `git commit` risponde `nothing added to commit`, manca proprio quello.

### Esercizio 3 · Due modifiche, due commit

Fai due modifiche insieme, senza committare in mezzo: aggiungi una funzione `prodotto` a `calcolatrice.js` e una riga di descrizione a `README.md`. Poi salvale in **due commit separati**: `feat: prodotto` con il solo `calcolatrice.js`, `docs: descrizione nel README` con il solo `README.md`.

Controlla che ogni commit contenga un solo file:

```
$ git show --stat HEAD~1
    feat: prodotto

 calcolatrice.js | 2 ++
 1 file changed, 2 insertions(+)
```

**Suggerimento:** `git add` con il nome di un solo file. Dopo il primo `git add`, `git status` mostra un file in *Changes to be committed* e l'altro in *Changes not staged for commit*.

### Esercizio 4 · Tornare indietro

Prova i quattro modi di rimediare a un errore:

1. aggiungi una riga di prova a `calcolatrice.js`, poi buttala via senza toccare il file a mano;
2. crea `appunti.txt`, aggiungilo con `git add`, poi toglilo dalla staging area (il file deve restare sul disco);
3. aggiungi una funzione `divisione` e committala con il messaggio sbagliato `feat: divsione`, poi correggi il messaggio;
4. annulla il commit della divisione con un nuovo commit.

```
$ git log --oneline -2
5fcb08f Revert "feat: divisione"
cec21e4 feat: divisione
```

**Suggerimento:** i comandi sono nella tabella *Tornare indietro*. Dopo `--amend` l'hash dell'ultimo commit cambia: è un commit nuovo.

---

## Livello 2 · Sotto il cofano

### Esercizio 5 · Commit, tree e blob

Con `git cat-file -p` leggi l'ultimo commit, il suo tree e il contenuto di `README.md`. Poi stampa la catena dei commit con il loro parent:

```
$ git log --format="%h  parent: %p  %s"
5fcb08f  parent: cec21e4  Revert "feat: divisione"
cec21e4  parent: 640eb15  feat: divisione
...
003c1a0  parent:   feat: somma
```

Disegna su un foglio la catena, con le frecce dal figlio al parent, e rispondi:

1. Quale commit non ha parent, e perché?
2. `README.md` non cambia da `docs: descrizione nel README` in poi. Il suo blob è lo stesso in tutti quei commit? Verificalo con `git rev-parse HEAD:README.md HEAD~2:README.md`
3. Se domani rifai lo stesso identico commit, con gli stessi file e lo stesso messaggio, l'hash sarà uguale?

**Suggerimento:** `HEAD^{tree}` è il tree dell'ultimo commit, `HEAD:README.md` il blob di un file. Per la domanda 3, guarda che cosa c'è scritto dentro un commit oltre ai file.

### Esercizio 6 · .gitignore

Installa `prompt-sync` nel progetto con `npm install prompt-sync` e guarda `git status`: compare `node_modules/`. Crea un `.gitignore` che lo escluda e committa `.gitignore`, `package.json` e `package-lock.json` con `chore: prompt-sync e .gitignore`.

```
$ git status
On branch main
Untracked files:
  (use "git add <file>..." to include in what will be committed)
	.gitignore
	package-lock.json
	package.json
```

**Suggerimento:** `package.json` e `package-lock.json` vanno committati, perché dicono quali pacchetti installare; `node_modules` si ricrea con `npm install`.

---

## Livello 3 · GitHub

### Esercizio 7 · Pubblicare e clonare

Crea su GitHub un repository **vuoto** chiamato `calcolatrice`, senza README. Collegalo come `origin` e fai il primo push. Controlla sul sito che ci siano tutti i commit.

Poi clona il repository in una seconda cartella, `calcolatrice-copia`, come farebbe un compagno sul suo computer. Nella copia aggiungi al README una riga con il comando per eseguire il programma, committa con `docs: come si esegue` e fai push. Torna nella cartella originale e scarica la modifica.

```
$ git pull
Updating 7985586..f39bfcd
Fast-forward
 README.md | 1 +
 1 file changed, 1 insertion(+)
```

**Suggerimento:** al primo push GitHub chiede di accedere dal browser (Windows) o con `gh auth login` (macOS e Linux): la password dell'account non funziona. Con `-u` nel primo push, dopo basta `git push`.

### Esercizio 8 · Push rifiutato

Simula due persone che lavorano insieme:

1. nella copia aggiungi una funzione `potenza`, committa con `feat: potenza` e fai push;
2. nell'originale, **senza fare pull**, aggiungi al README l'elenco delle funzioni, committa con `docs: elenco delle funzioni` e prova a fare push.

Il push viene rifiutato. Risolvi e pubblica, poi guarda la storia:

```
$ git log --oneline --graph -4
*   0fdac07 Merge branch 'main' of https://github.com/mariorossi/calcolatrice
|\
| * 5c97dca feat: potenza
* | 916818f docs: elenco delle funzioni
|/
* f39bfcd docs: come si esegue
```

**Suggerimento:** leggi l'ultima riga di `hint` del messaggio di errore. Non usare mai `git push --force`: cancellerebbe il commit dell'altra copia.

---

## Livello 4 · I branch

### Esercizio 9 · Branch e merge

Crea il branch `modulo` e spostati lì. Crea `modulo.js` con una funzione `modulo` e committa con `feat: modulo`. Torna su `main` e controlla con `ls` che `modulo.js` non ci sia. Poi unisci il branch in `main`, cancellalo e fai push.

```
$ git merge modulo
Updating 0fdac07..1ae3fad
Fast-forward
 modulo.js | 1 +
 1 file changed, 1 insertion(+)
 create mode 100644 modulo.js
```

**Suggerimento:** `git switch -c` crea il branch e ci si sposta in un colpo solo. Il merge è un *fast-forward* perché `main` non è andato avanti nel frattempo.

### Esercizio 10 · Un conflitto

Provoca un conflitto e risolvilo:

1. su `main` crea `messaggio.js` con `const MESSAGGIO = "Calcolatrice";` e committa;
2. crea il branch `benvenuto` e cambia la riga in `"Benvenuto nella calcolatrice"`, poi committa;
3. torna su `main`, cambia la stessa riga in `"Calcolatrice 1.0"` e committa;
4. unisci `benvenuto` in `main`.

```
$ git merge benvenuto
Auto-merging messaggio.js
CONFLICT (content): Merge conflict in messaggio.js
Automatic merge failed; fix conflicts and then commit the result.
```

Apri `messaggio.js`, lascia una sola riga, `"Benvenuto nella calcolatrice 1.0"`, togli i marcatori e completa il merge. Fai push.

**Suggerimento:** tra `<<<<<<<` e `=======` c'è la versione di `main`, tra `=======` e `>>>>>>>` quella di `benvenuto`. Dopo aver sistemato il file, `git add` e `git commit`. Se ti perdi, `git merge --abort` torna a prima del merge.
