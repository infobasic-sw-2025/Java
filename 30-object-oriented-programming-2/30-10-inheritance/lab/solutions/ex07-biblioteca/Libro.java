public class Libro extends Pubblicazione {
    private String autore;

    public Libro(String titolo, int anno, String autore) {
        super(titolo, anno);
        this.autore = autore;
    }

    @Override
    public String toString() {
        return super.toString() + " di " + autore;
    }
}
