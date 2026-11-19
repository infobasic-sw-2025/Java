public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo(20);
        zoo.aggiungiAnimale(new Leone("Simba", true));
        zoo.aggiungiAnimale(new Pappagallo("Polly", true));
        zoo.aggiungiAnimale(new Delfino("Flipper"));
        zoo.aggiungiAnimale(new Serpente("Kaa", false));
        zoo.concerto();
        zoo.stampaAnimali();
        System.out.println("Leoni: " + zoo.contaPerSpecie("Leone"));
    }
}
