public class Stagista extends Dipendente {
    private int oreLavorate;
    private double pagaOraria;

    public Stagista(String nome, int oreLavorate, double pagaOraria) {
        super(nome, 0);
        this.oreLavorate = oreLavorate;
        this.pagaOraria = pagaOraria;
    }

    @Override
    public double calcolaStipendio() {
        return oreLavorate * pagaOraria;
    }
}
