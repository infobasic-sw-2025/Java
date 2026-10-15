public class TemperatureConverter {
    public static void main(String[] args) {
        int celsius = 25;

        double sbagliata = celsius * (9 / 5) + 32;
        double corretta = celsius * 9 / 5 + 32;
        double conDecimali = celsius * (9.0 / 5) + 32;

        System.out.println("Sbagliata: " + sbagliata);
        System.out.println("Corretta: " + corretta);
        System.out.println("Con decimali: " + conDecimali);

        // Con 37 gradi la versione intera perde i decimali
        int febbre = 37;
        System.out.println(febbre + " °C = " + (febbre * 9 / 5 + 32) + " °F (tra interi)");
        System.out.println(febbre + " °C = " + (febbre * 9.0 / 5 + 32) + " °F (con double)");
    }
}
