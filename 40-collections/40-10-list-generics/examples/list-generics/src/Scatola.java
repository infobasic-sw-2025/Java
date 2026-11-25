// una classe generica: T diventa un tipo vero quando la si usa
public class Scatola<T> {

    private T contenuto;

    public Scatola(T contenuto) {
        this.contenuto = contenuto;
    }

    public T apri() {
        return contenuto;
    }
}
