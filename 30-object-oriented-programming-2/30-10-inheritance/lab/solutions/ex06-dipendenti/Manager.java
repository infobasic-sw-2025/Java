public class Manager extends Dipendente {
    private double bonus;

    public Manager(String nome, double stipendioBase, double bonus) {
        super(nome, stipendioBase);
        this.bonus = bonus;
    }

    @Override
    public double calcolaStipendio() {
        return super.calcolaStipendio() + bonus;
    }
}
