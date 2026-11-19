public class Main {
    public static void main(String[] args) {
        Dipendente[] dipendenti = {
            new Manager("Anna", 3000, 500),
            new Stagista("Marco", 80, 8.5),
            new Stagista("Laura", 60, 9)
        };

        for (Dipendente d : dipendenti) {
            System.out.println(d.getNome() + ": " + d.calcolaStipendio());
        }
    }
}
