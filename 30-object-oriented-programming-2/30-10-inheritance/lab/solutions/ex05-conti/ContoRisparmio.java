public class ContoRisparmio extends ContoBancario {
    private double tassoInteresse;

    public ContoRisparmio(String intestatario, double saldo, double tassoInteresse) {
        super(intestatario, saldo);
        this.tassoInteresse = tassoInteresse;
    }

    public void applicaInteresse() {
        deposita(getSaldo() * tassoInteresse / 100);
    }
}
