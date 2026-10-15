public class TemperatureMethods {

    // 9.0 è un double: la divisione non viene troncata
    static double celsiusToFahrenheit(double c) {
        return c * 9.0 / 5 + 32;
    }

    static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5.0 / 9;
    }

    public static void main(String[] args) {
        System.out.println("0 °C = " + celsiusToFahrenheit(0) + " °F");
        System.out.println("100 °C = " + celsiusToFahrenheit(100) + " °F");
        System.out.println("37 °C = " + celsiusToFahrenheit(37) + " °F");

        System.out.println("32 °F = " + fahrenheitToCelsius(32) + " °C");
        System.out.println("212 °F = " + fahrenheitToCelsius(212) + " °C");
        System.out.println("98.6 °F = " + fahrenheitToCelsius(98.6) + " °C");
    }
}
