public class EvenOdd {

    // La condizione è già un boolean: non serve un if
    static boolean isPari(int n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (isPari(i)) {
                System.out.println(i + " è pari");
            } else {
                System.out.println(i + " è dispari");
            }
        }
    }
}
