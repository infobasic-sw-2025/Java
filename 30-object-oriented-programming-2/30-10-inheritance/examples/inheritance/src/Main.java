public class Main {

    public static void main(String[] args) {

        // --- Gerarchia Persona ---
        System.out.println("=== Gerarchia Persona ===");

        Persona p = new Persona("Anna", "anna@email.it");
        Studente s = new Studente("Marco", "marco@email.it", "M001");
        Docente d = new Docente("Laura", "laura@email.it", "Informatica");

        System.out.println(p);  // Anna (anna@email.it)
        System.out.println(s);  // Marco (marco@email.it) - Matricola: M001
        System.out.println(d);  // Laura (laura@email.it) - Materia: Informatica

        // Getter ereditati
        System.out.println();
        System.out.println("Nome studente: " + s.getNome());
        System.out.println("Email studente: " + s.getEmail());
        System.out.println("Matricola: " + s.getMatricola());

        // --- Gerarchia Animale ---
        System.out.println();
        System.out.println("=== Gerarchia Animale ===");

        Animale a1 = new Cane("Rex", "Pastore Tedesco");
        Animale a2 = new Gatto("Micio", true);
        Animale a3 = new Animale("Creatura");

        // Override in azione: ogni animale ha il suo verso
        System.out.println(a1 + " fa " + a1.verso());  // Rex (Pastore Tedesco) fa Bau!
        System.out.println(a2 + " fa " + a2.verso());  // Micio (indoor) fa Miao!
        System.out.println(a3 + " fa " + a3.verso());  // Creatura fa ...

        // Array di animali: il polimorfismo in azione
        System.out.println();
        System.out.println("=== Tutti gli animali ===");
        Animale[] animali = { a1, a2, a3 };
        for (Animale a : animali) {
            System.out.println(a.getNome() + " -> " + a.verso());
        }
    }
}
