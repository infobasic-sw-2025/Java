package forma_geometrica;

public class Cerchio extends Forma{
    double raggio;

    public Cerchio(String colore, double raggio){
        super(colore);
        this.raggio = raggio;
    }

    @Override
    double area() {
        return Math.PI * raggio * raggio;
    }
}
