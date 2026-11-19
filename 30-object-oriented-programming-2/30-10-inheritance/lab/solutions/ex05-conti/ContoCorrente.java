public class ContoCorrente extends ContoBancario {
    private double costoOperazione;

    public ContoCorrente(String intestatario, double saldo, double costoOperazione) {
        super(intestatario, saldo);
        this.costoOperazione = costoOperazione;
    }

    @Override
    public void deposita(double importo) {
        super.deposita(importo);
        super.preleva(costoOperazione);
    }

    @Override
    public void preleva(double importo) {
        // Il costo fa parte del prelievo: va controllato insieme all'importo
        if (importo + costoOperazione > getSaldo()) {
            System.out.println("Saldo insufficiente");
            return;
        }
        super.preleva(importo);
        super.preleva(costoOperazione);
    }
}
