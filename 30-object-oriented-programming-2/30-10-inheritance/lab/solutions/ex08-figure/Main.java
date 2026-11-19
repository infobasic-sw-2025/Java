public class Main {
    public static void main(String[] args) {
        Figura[] figure = { new Rettangolo(4, 5), new Triangolo(6, 3), new Rettangolo(2, 2) };

        double totale = 0;
        for (Figura f : figure) {
            System.out.println(f + ": area " + f.area());
            totale += f.area();
        }
        System.out.println("Area totale: " + totale);
    }
}
