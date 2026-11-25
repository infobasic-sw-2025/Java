import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // --- 1. Creare una lista e i metodi principali ---
        System.out.println("=== Metodi ===");
        List<String> nomi = new ArrayList<>();
        nomi.add("Alice");
        nomi.add("Bob");
        nomi.add("Carla");
        System.out.println(nomi + " -> " + nomi.size() + " elementi");

        nomi.set(1, "Bruno");
        nomi.add(1, "Bea");
        System.out.println(nomi);
        nomi.remove(2);
        nomi.remove("Alice");
        System.out.println(nomi);
        System.out.println("Carla c'è? " + nomi.contains("Carla"));

        // --- 2. Scorrere, wrapper e remove con gli interi ---
        System.out.println("\n=== Numeri ===");
        List<Integer> voti = new ArrayList<>();
        voti.add(7);
        voti.add(9);
        voti.add(6);
        int somma = 0;
        for (int v : voti) {
            somma += v;
        }
        System.out.println("Somma: " + somma);

        voti.remove(1);                    // toglie la posizione 1
        System.out.println(voti);
        voti.remove(Integer.valueOf(6));   // toglie il valore 6
        System.out.println(voti);

        // --- 3. Ordinare, Java 21, List.of ---
        System.out.println("\n=== Ordine ===");
        List<String> classe = new ArrayList<>(List.of("Carla", "Alice", "Bob"));
        Collections.sort(classe);
        System.out.println(classe);
        System.out.println("Primo: " + classe.getFirst() + ", ultimo: " + classe.getLast());
        System.out.println("Al contrario: " + classe.reversed());

        // --- 4. Generics: una classe e un metodo ---
        System.out.println("\n=== Generics ===");
        Scatola<String> s1 = new Scatola<>("un libro");
        Scatola<Integer> s2 = new Scatola<>(42);
        String cosa = s1.apri();
        int numero = s2.apri();
        System.out.println(cosa + ", " + (numero + 1));
        stampaTutti(List.of("Alice", "Bob"));
        stampaTutti(List.of(1, 2, 3));

        // --- 5. Una lista di oggetti: filtrare e togliere con l'Iterator ---
        System.out.println("\n=== Studenti ===");
        List<Studente> studenti = new ArrayList<>();
        studenti.add(new Studente("Alice", 8));
        studenti.add(new Studente("Bob", 5));
        studenti.add(new Studente("Carla", 9));
        System.out.println(studenti);

        List<Studente> promossi = new ArrayList<>();
        for (Studente st : studenti) {
            if (st.getVoto() >= 6) {
                promossi.add(st);
            }
        }
        System.out.println("Promossi: " + promossi);

        Iterator<Studente> it = studenti.iterator();
        while (it.hasNext()) {
            if (it.next().getVoto() < 6) {
                it.remove();
            }
        }
        System.out.println("Dopo l'Iterator: " + studenti);
    }

    // un metodo generico: T lo ricava il compilatore dalla lista
    static <T> void stampaTutti(List<T> lista) {
        for (T elemento : lista) {
            System.out.println("- " + elemento);
        }
    }
}
