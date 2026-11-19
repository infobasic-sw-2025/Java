public class Main {
    public static void main(String[] args) {
        Studente s1 = new Studente("Anna");
        Studente s2 = new Studente("Luca");
        Armadietto a = new Armadietto(1, 111);
        Armadietto b = new Armadietto(2, 222);
        Armadietto c = a;
        a.assegna(s1);
// PUNTO A
        c.apri(0);
        a.apri(5);
        b.assegna(s2);
        s2.setNome("Marco");
// PUNTO B
        a.apri(111);
        b.assegna(s1);
        c = b;
        a = null;
        b.apri(1);
        b.apri(2);
        b.apri(3);
        b.assegna(s2);
// PUNTO C
        System.out.println(c.apri(222));
        System.out.println(Armadietto.getCreati());

        System.out.println(b.stessoProprietario(b));
    }
}