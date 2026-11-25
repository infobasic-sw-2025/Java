public class Cane extends Animale {

    @Override
    public void faiVerso() {
        System.out.println("Bau!");
    }

    // esiste solo in Cane: da una variabile Animale non si vede
    public void riporta() {
        System.out.println("Il cane riporta la pallina");
    }
}
