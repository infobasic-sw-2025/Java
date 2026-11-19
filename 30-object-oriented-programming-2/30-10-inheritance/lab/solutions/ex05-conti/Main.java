public class Main {
    public static void main(String[] args) {
        ContoCorrente cc = new ContoCorrente("Anna", 1000, 1.5);
        cc.deposita(200);
        System.out.println(cc);
        cc.preleva(100);
        System.out.println(cc);
        cc.preleva(5000);
        System.out.println(cc);

        ContoRisparmio cr = new ContoRisparmio("Marco", 1000, 5);
        cr.applicaInteresse();
        System.out.println(cr);
    }
}
