public class Main {

    public static void main(String[] args) {

        // --- 1. Riferimento e oggetto: il metodo lo sceglie l'oggetto ---
        System.out.println("=== Late binding ===");
        Animale a1 = new Cane();
        Animale a2 = new Gatto();
        a1.faiVerso();
        a2.faiVerso();

        // --- 2. Array polimorfico e metodo per tutte le forme ---
        System.out.println("\n=== Array polimorfico ===");
        Forma[] forme = {
            new Cerchio(1),
            new Rettangolo(4, 3),
            new Triangolo(6, 2)
        };
        for (Forma f : forme) {
            stampaArea(f);
        }

        // --- 3. Downcasting con instanceof e pattern matching ---
        System.out.println("\n=== instanceof ===");
        Animale[] animali = { new Cane(), new Gatto() };
        for (Animale a : animali) {
            a.faiVerso();
            if (a instanceof Cane c) {
                c.riporta();
            }
        }

        // --- 4. Switch sui tipi (Java 21) ---
        System.out.println("\n=== Switch sui tipi ===");
        for (Forma f : forme) {
            System.out.println(descrivi(f));
        }

        // --- 5. In pratica: le notifiche ---
        System.out.println("\n=== Notifiche ===");
        Notifica[] notifiche = {
            new Email("anna@scuola.it"),
            new Sms("333 1234567"),
            new Push("marco")
        };
        for (Notifica n : notifiche) {
            n.invia("lezione alle 10");
        }
    }

    static void stampaArea(Forma f) {
        System.out.println("Area: " + f.area());
    }

    // Forma è sealed: i casi sono tutti, il default non serve
    static String descrivi(Forma f) {
        return switch (f) {
            case Cerchio c -> "Cerchio di raggio " + c.raggio;
            case Rettangolo r -> "Rettangolo " + r.base + " x " + r.altezza;
            case Triangolo t -> "Triangolo di base " + t.base;
        };
    }
}
