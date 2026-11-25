public class Conto {

    private double saldo;

    public Conto(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("Saldo iniziale negativo: " + saldo);
        }
        this.saldo = saldo;
    }

    public void preleva(double importo) throws SaldoInsufficienteException {
        if (importo > saldo) {
            throw new SaldoInsufficienteException(saldo, importo);
        }
        saldo -= importo;
        System.out.println("Prelevati " + importo + ", saldo " + saldo);
    }
}
