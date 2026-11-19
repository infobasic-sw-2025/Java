public class Triangolo extends Figura {
    private double base;
    private double altezza;

    public Triangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    @Override
    public double area() {
        return base * altezza / 2;
    }

    @Override
    public String toString() {
        return "Triangolo " + base + " x " + altezza;
    }
}
