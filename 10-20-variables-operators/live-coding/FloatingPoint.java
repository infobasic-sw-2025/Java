// 4/4 · Numeri in virgola mobile
public class FloatingPoint {
    public static void main(String[] args) {
        // 0.1 + 0.2 non fa 0.3
        System.out.println(0.1 + 0.2);   // 0.30000000000000004

        // Confronto con tolleranza
        double somma = 0.1 + 0.2;
        System.out.println(somma == 0.3);                      // false
        System.out.println(Math.abs(somma - 0.3) < 1e-9);     // true

        // Valori speciali
        System.out.println(10.0 / 0);      // Infinity
        System.out.println(0.0 / 0);       // NaN

        // NaN non è uguale a niente, nemmeno a se stesso
        double nan = 0.0 / 0;
        System.out.println(nan == nan);          // false
        System.out.println(Double.isNaN(nan));   // true
    }
}
