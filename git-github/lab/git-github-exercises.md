# Laboratorio · Git e GitHub (versione Java)

Tutti gli esercizi si fanno dal terminale: Git Bash su Windows, il Terminale su macOS e Linux. I file Java si possono scrivere con IntelliJ o con qualsiasi editor, ma i comandi di Git si danno dal terminale. Gli hash dei commit sono diversi per ognuno, perché dipendono anche da autore e data: negli output qui sotto contano i messaggi, non gli hash.

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

1. `Calcolatrice.java` con un metodo statico `somma` e un `main` che lo usa → `feat: somma`
2. un metodo `sottrazione` aggiunto alla stessa classe, usato anche nel `main` → `feat: sottrazione`. Prima del commit guarda la modifica con `git diff`
3. un file `README.md` con il titolo `# Calcolatrice` → `docs: README`

```
$ git log --oneline
ae1d4c0 docs: README
d923b0e feat: sottrazione
38469b6 feat: somma
```

**Suggerimenti:**
- `git add` prima di ogni `git commit`. Se `git commit` risponde `nothing added to commit`, manca proprio quello
- Prova il programma con `java Calcolatrice.java`: dal JDK 11 si può eseguire un file sorgente senza compilarlo prima con `javac`

### Esercizio 3 · Due modifiche, due commit

Fai due modifiche insieme, senza committare in mezzo: aggiungi un metodo `prodotto` a `Calcolatrice.java` e una riga di descrizione a `README.md`. Poi salvale in **due commit separati**: `feat: prodotto` con il solo `Calcolatrice.java`, `docs: descrizione nel README` con il solo `README.md`.

Controlla che ogni commit contenga un solo file:

```
$ git show --stat HEAD~1
    feat: prodotto

 Calcolatrice.java | 2 ++
 1 file changed, 2 insertions(+)
```

**Suggerimento:** `git add` con il nome di un solo file. Dopo il primo `git add`, `git status` mostra un file in *Changes to be committed* e l'altro in *Changes not staged for commit*.

### Esercizio 4 · Tornare indietro

Prova i quattro modi di rimediare a un errore:

1. aggiungi una riga di prova a `Calcolatrice.java`, poi buttala via senza toccare il file a mano;
2. crea `appunti.txt`, aggiungilo con `git add`, poi toglilo dalla staging area (il file deve restare sul disco);
3. aggiungi un metodo `divisione` e committalo con il messaggio sbagliato `feat: divsione`, poi correggi il messaggio;
4. annulla il commit della divisione con un nuovo commit.

```
$ git log --oneline -2
9a7eb83 Revert "feat: divisione"
958686d feat: divisione
```

**Suggerimento:** i comandi sono nella tabella *Tornare indietro*. Dopo `--amend` l'hash dell'ultimo commit cambia: è un commit nuovo.

---

## Livello 2 · Sotto il cofano

### Esercizio 5 · Commit, tree e blob

Con `git cat-file -p` leggi l'ultimo commit, il suo tree e il contenuto di `README.md`. Poi stampa la catena dei commit con il loro parent:

```
$ git log --format="%h  parent: %p  %s"
9a7eb83  parent: 958686d  Revert "feat: divisione"
958686d  parent: 2f35944  feat: divisione
...
38469b6  parent:   feat: somma
```

Disegna su un foglio la catena, con le frecce dal figlio al parent, e rispondi:

1. Quale commit non ha parent, e perché?
2. `README.md` non cambia da `docs: descrizione nel README` in poi. Il suo blob è lo stesso in tutti quei commit? Verificalo con `git rev-parse HEAD:README.md HEAD~2:README.md`
3. Se domani rifai lo stesso identico commit, con gli stessi file e lo stesso messaggio, l'hash sarà uguale?

**Suggerimento:** `HEAD^{tree}` è il tree dell'ultimo commit, `HEAD:README.md` il blob di un file. Per la domanda 3, guarda che cosa c'è scritto dentro un commit oltre ai file.

### Esercizio 6 · .gitignore

Compila il programma con `javac Calcolatrice.java` e guarda `git status`: compare `Calcolatrice.class`. Crea un `.gitignore` che escluda tutti i file `.class` e la cartella `out/`, poi committalo con `chore: .gitignore per i file compilati`.

```
$ git status
On branch main
Untracked files:
  (use "git add <file>..." to include in what will be committed)
	.gitignore

nothing added to commit but untracked files present (use "git add" to track)
```

**Suggerimenti:**
- `*.class` vale per tutti i file con quell'estensione. I `.class` non si committano: si ricreano con `javac` a partire dai `.java`
- `out/` è la cartella in cui compila IntelliJ: anche quella non va su GitHub

---

## Livello 3 · GitHub

### Prima di cominciare · Accesso a GitHub dal terminale

GitHub non accetta la password dell'account per `git push`: dal terminale serve un **personal access token**, una chiave da usare al posto della password.

**1. Crea il token.** Su GitHub: foto del profilo → **Settings** → **Developer settings** → **Personal access tokens** → **Tokens (classic)** → **Generate new token** → **Generate new token (classic)**. Poi:

- **Note:** un nome che ricordi a cosa serve, per esempio `pc-aula`;
- **Expiration:** una scadenza, per esempio 90 giorni;
- **Scopes:** spunta **repo**, che basta per fare push sui tuoi repository;
- **Generate token**, e copia subito il token (inizia con `ghp_`): GitHub non te lo mostrerà più.

Il token vale come la password: non metterlo in un file del repository e non mandarlo a nessuno.

**2. Configura il sistema che lo conserva.** Prima del push, di' a Git dove salvare il token, con il comando del tuo sistema: è un'impostazione `--global`, vale per tutti i repository.

| Sistema | Comando | Dove finisce il token |
|---|---|---|
| Windows | `git config --global credential.helper manager` | Gestione credenziali di Windows (Git Credential Manager, incluso in Git for Windows) |
| macOS | `git config --global credential.helper osxkeychain` | Portachiavi |
| Linux | `git config --global credential.helper store` | file `~/.git-credentials`, in chiaro |

Controlla con `git config --get-all credential.helper`: deve comparire il nome che hai impostato.

**3. Fai il primo push.** Quando Git chiede le credenziali, scrivi il tuo username di GitHub e incolla il token al posto della password. Mentre lo incolli non compare niente: è normale. Git lo salva nel sistema e dal push successivo non lo chiede più.

```
$ git push -u origin main
Username for 'https://github.com': mariorossi
Password for 'https://mariorossi@github.com':
```

Su Windows, al posto di queste due righe si apre la finestra di Git Credential Manager: accedi dal browser oppure incolla il token.

Per vedere che è salvato: su macOS apri **Accesso Portachiavi** e cerca `github.com`; su Windows apri **Gestione credenziali** → **Credenziali di Windows** e cerca `git:https://github.com`.

**Se il push dà `Authentication failed`**, di solito il token è scaduto o non ha lo scope `repo`. Crea un token nuovo, poi cancella quello salvato e rifai il push, che lo chiederà di nuovo:

```
$ printf "protocol=https\nhost=github.com\n\n" | git credential reject
```

Su Windows si può anche cancellarlo a mano: Pannello di controllo → Gestione credenziali → Credenziali di Windows → `git:https://github.com` → Rimuovi.

### Esercizio 7 · Pubblicare e clonare

Crea su GitHub un repository **vuoto** chiamato `calcolatrice`, senza README. Collegalo come `origin` e fai il primo push. Controlla sul sito che ci siano tutti i commit.

Poi clona il repository in una seconda cartella, `calcolatrice-copia`, come farebbe un compagno sul suo computer. Nella copia aggiungi al README una riga con il comando per eseguire il programma, committa con `docs: come si esegue` e fai push. Torna nella cartella originale e scarica la modifica.

```
$ git pull
Updating 95f9d42..d0ecaef
Fast-forward
 README.md | 1 +
 1 file changed, 1 insertion(+)
```

**Suggerimento:** al primo push serve il token creato prima di cominciare il Livello 3: la password dell'account non funziona. Con `-u` nel primo push, dopo basta `git push`.

### Esercizio 8 · Push rifiutato

Simula due persone che lavorano insieme:

1. nella copia aggiungi un metodo `potenza`, committa con `feat: potenza` e fai push;
2. nell'originale, **senza fare pull**, aggiungi al README l'elenco dei metodi, committa con `docs: elenco dei metodi` e prova a fare push.

Il push viene rifiutato. Risolvi e pubblica, poi guarda la storia:

```
$ git log --oneline --graph -4
*   767926c Merge branch 'main' of https://github.com/mariorossi/calcolatrice
|\
| * 7c9ae92 feat: potenza
* | 75dce58 docs: elenco dei metodi
|/
* d0ecaef docs: come si esegue
```

**Suggerimento:** leggi l'ultima riga di `hint` del messaggio di errore. Non usare mai `git push --force`: cancellerebbe il commit dell'altra copia.

---

## Livello 4 · I branch

### Esercizio 9 · Branch e merge

Crea il branch `modulo` e spostati lì. Crea `Modulo.java`, una classe con un metodo statico `modulo` che restituisce il resto della divisione, e committa con `feat: modulo`. Torna su `main` e controlla con `ls` che `Modulo.java` non ci sia. Poi unisci il branch in `main`, cancellalo e fai push.

```
$ git merge modulo
Updating 767926c..25dca62
Fast-forward
 Modulo.java | 3 +++
 1 file changed, 3 insertions(+)
 create mode 100644 Modulo.java
```

**Suggerimento:** `git switch -c` crea il branch e ci si sposta in un colpo solo. Il merge è un *fast-forward* perché `main` non è andato avanti nel frattempo.

### Esercizio 10 · Un conflitto

Provoca un conflitto e risolvilo:

1. su `main` crea `Messaggio.java`, una classe con la costante `static final String MESSAGGIO = "Calcolatrice";`, e committa;
2. crea il branch `benvenuto` e cambia il valore in `"Benvenuto nella calcolatrice"`, poi committa;
3. torna su `main`, cambia la stessa riga in `"Calcolatrice 1.0"` e committa;
4. unisci `benvenuto` in `main`.

```
$ git merge benvenuto
Auto-merging Messaggio.java
CONFLICT (content): Merge conflict in Messaggio.java
Automatic merge failed; fix conflicts and then commit the result.
```

Apri `Messaggio.java`, lascia una sola riga con `"Benvenuto nella calcolatrice 1.0"`, togli i marcatori e completa il merge. Fai push.

**Suggerimento:** tra `<<<<<<<` e `=======` c'è la versione di `main`, tra `=======` e `>>>>>>>` quella di `benvenuto`. Le righe uguali nei due branch, come `public class Messaggio {`, restano fuori dai marcatori. Dopo aver sistemato il file, `git add` e `git commit`. Se ti perdi, `git merge --abort` torna a prima del merge.
