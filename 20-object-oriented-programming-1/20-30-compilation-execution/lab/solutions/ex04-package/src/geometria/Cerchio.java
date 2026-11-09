package geometria;

public class Cerchio {
    double raggio;

    public Cerchio(double raggio) {
        this.raggio = raggio;
    }

    public double area() {
        return Math.PI * raggio * raggio;
    }

    public String toString() {
        return "Cerchio(raggio=" + raggio + ", area=" + area() + ")";
    }
}
