// 4/4 · Numeri in virgola mobile
public class FloatingPoint {
    public static void main(String[] args) {
        // Sommiamo 0.1 e 0.2: il risultato non è 0.3
        System.out.println(0.1 + 0.2);   // 0.30000000000000004

        // Confrontiamo il risultato con 0.3: == fallisce, la tolleranza funziona
        double somma = 0.1 + 0.2;
        System.out.println(somma == 0.3);                      // false
        System.out.println(Math.abs(somma - 0.3) < 1e-9);     // true

        // Dividiamo per zero con i decimali: nessuna eccezione, ma valori speciali
        System.out.println(10.0 / 0);      // Infinity
        System.out.println(0.0 / 0);       // NaN

        double nan = 0.0 / 0;
        System.out.println(nan == nan);          // false
        System.out.println(Double.isNaN(nan));   // true
    }
}
