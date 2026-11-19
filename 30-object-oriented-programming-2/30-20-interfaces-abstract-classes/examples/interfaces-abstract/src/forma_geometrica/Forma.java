package forma_geometrica;

public abstract class Forma {
    String colore;

    Forma(String colore){
        this.colore = colore;
    }

    // solo la firma del metodo, no impelemnetazione!
    abstract double area();

    public void setColore(String colore){
        this.colore = colore;
    }

    public String descrizione(){
        return "Forma di colore: " + colore + ", area: " + area();
    }
}
