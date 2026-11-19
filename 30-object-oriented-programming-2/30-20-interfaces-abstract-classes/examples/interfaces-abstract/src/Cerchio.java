class Cerchio extends Forma {
    double raggio;

    Cerchio(String colore, double raggio) {
        super(colore);
        this.raggio = raggio;
    }

    @Override
    double area() {
        return Math.PI * raggio * raggio;
    }
}
