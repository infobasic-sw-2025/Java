public class ContoBancario {
    private String intestatario;
    private double saldo;

    public ContoBancario(String intestatario, double saldo) {
        this.intestatario = intestatario;
        this.saldo = saldo;
    }

    public void deposita(double importo) {
        saldo += importo;
    }

    public void preleva(double importo) {
        if (importo > saldo) {
            System.out.println("Saldo insufficiente");
            return;
        }
        saldo -= importo;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return intestatario + ": " + saldo + " EUR";
    }
}
