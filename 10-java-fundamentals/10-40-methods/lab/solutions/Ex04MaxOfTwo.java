public class Ex04MaxOfTwo {

    // Il primo return che viene eseguito chiude il metodo
    static int massimo(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println("massimo(3, 8) = " + massimo(3, 8));
        System.out.println("massimo(10, -2) = " + massimo(10, -2));
        System.out.println("massimo(5, 5) = " + massimo(5, 5));
    }
}
