public class Dipendente {
    private String nome;
    private double stipendioBase;

    public Dipendente(String nome, double stipendioBase) {
        this.nome = nome;
        this.stipendioBase = stipendioBase;
    }

    public String getNome() {
        return nome;
    }

    public double calcolaStipendio() {
        return stipendioBase;
    }
}
