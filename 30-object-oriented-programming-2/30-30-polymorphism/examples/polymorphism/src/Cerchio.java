public final class Cerchio extends Forma {

    double raggio;

    public Cerchio(double raggio) {
        this.raggio = raggio;
    }

    @Override
    public double area() {
        return Math.PI * raggio * raggio;
    }
}
