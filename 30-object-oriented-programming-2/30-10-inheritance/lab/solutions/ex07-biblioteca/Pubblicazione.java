public class Pubblicazione {
    private String titolo;
    private int anno;

    public Pubblicazione(String titolo, int anno) {
        this.titolo = titolo;
        this.anno = anno;
    }

    public int getAnno() {
        return anno;
    }

    @Override
    public String toString() {
        return titolo + " (" + anno + ")";
    }
}
