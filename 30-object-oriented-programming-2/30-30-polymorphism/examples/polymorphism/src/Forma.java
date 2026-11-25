// sealed: solo le classi di permits possono estendere Forma
public sealed abstract class Forma permits Cerchio, Rettangolo, Triangolo {

    public abstract double area();
}
