class Rettangolo extends Forma {
    double base;
    double altezza;

    Rettangolo(String colore, double base, double altezza) {
        super(colore);
        this.base = base;
        this.altezza = altezza;
    }

    @Override
    double area() {
        return base * altezza;
    }
}
