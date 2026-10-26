# Esercizio 10 · Un conflitto
# Obiettivo: provocare un conflitto e risolverlo

cd calcolatrice
cat > Messaggio.java <<'JAVA'
public class Messaggio {
    static final String MESSAGGIO = "Calcolatrice";
}
JAVA
git add Messaggio.java
git commit -m "feat: messaggio"

git switch -c benvenuto
cat > Messaggio.java <<'JAVA'
public class Messaggio {
    static final String MESSAGGIO = "Benvenuto nella calcolatrice";
}
JAVA
git commit -am "feat: messaggio di benvenuto"

git switch main
cat > Messaggio.java <<'JAVA'
public class Messaggio {
    static final String MESSAGGIO = "Calcolatrice 1.0";
}
JAVA
git commit -am "feat: versione nel messaggio"

git merge benvenuto
# → CONFLICT (content): Merge conflict in Messaggio.java
# → Automatic merge failed; fix conflicts and then commit the result.
cat Messaggio.java
# → public class Messaggio {
# → <<<<<<< HEAD
# →     static final String MESSAGGIO = "Calcolatrice 1.0";
# → =======
# →     static final String MESSAGGIO = "Benvenuto nella calcolatrice";
# → >>>>>>> benvenuto
# → }

# Risoluzione: una riga sola, senza marcatori
cat > Messaggio.java <<'JAVA'
public class Messaggio {
    static final String MESSAGGIO = "Benvenuto nella calcolatrice 1.0";
}
JAVA
git add Messaggio.java
git commit --no-edit           # messaggio predefinito: Merge branch 'benvenuto'
git log --oneline --graph -4
git push
