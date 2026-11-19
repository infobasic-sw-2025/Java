// Classe astratta: non si può fare new Forma(...)
abstract class Forma {
    String colore;

    Forma(String colore) {
        this.colore = colore;
    }

    // Metodo astratto: solo la firma, il corpo lo scrive ogni sottoclasse
    abstract double area();

    // Metodo concreto: è uguale per tutte le forme e usa area()
    String descrizione() {
        return "Forma di colore " + colore + ", area = " + area();
    }
}
