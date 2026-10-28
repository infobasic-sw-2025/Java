public class Ex02RectangleArea {

    // Restituisce il valore: è il chiamante a decidere cosa farne
    static int area(int base, int altezza) {
        return base * altezza;
    }

    public static void main(String[] args) {
        int area1 = area(4, 7);
        int area2 = area(5, 9);

        System.out.println("Area 1: " + area1);
        System.out.println("Area 2: " + area2);
    }
}
