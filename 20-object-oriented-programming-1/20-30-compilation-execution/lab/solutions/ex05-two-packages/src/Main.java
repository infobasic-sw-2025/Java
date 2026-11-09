import modello.Prodotto;
import servizio.Inventario;

public class Main {
    public static void main(String[] args) {
        Inventario inv = new Inventario(10);

        inv.aggiungi(new Prodotto("Laptop", 899.99));
        inv.aggiungi(new Prodotto("Mouse", 29.99));
        inv.aggiungi(new Prodotto("Tastiera", 59.99));

        inv.stampaListino();
    }
}
