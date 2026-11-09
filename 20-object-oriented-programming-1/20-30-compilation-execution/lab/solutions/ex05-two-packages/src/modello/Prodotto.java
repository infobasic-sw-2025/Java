package modello;

public class Prodotto {
    String nome;
    double prezzo;

    public Prodotto(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public String toString() {
        return nome + " - " + prezzo + " EUR";
    }
}
