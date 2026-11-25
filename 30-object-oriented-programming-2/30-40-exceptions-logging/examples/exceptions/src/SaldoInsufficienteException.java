// checked: estende Exception, quindi chi chiama preleva deve gestirla
public class SaldoInsufficienteException extends Exception {

    public SaldoInsufficienteException(double saldo, double importo) {
        super("Saldo " + saldo + " insufficiente per prelevare " + importo);
    }
}
