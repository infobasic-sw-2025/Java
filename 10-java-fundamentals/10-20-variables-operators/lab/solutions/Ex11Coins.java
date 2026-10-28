public class Ex11Coins {
    public static void main(String[] args) {
        int resto = 476;

        int da200 = resto / 200;
        resto = resto % 200;
        int da100 = resto / 100;
        resto = resto % 100;
        int da50 = resto / 50;
        resto = resto % 50;
        int da20 = resto / 20;
        resto = resto % 20;
        int da10 = resto / 10;
        resto = resto % 10;
        int da5 = resto / 5;
        resto = resto % 5;
        int da2 = resto / 2;
        resto = resto % 2;
        int da1 = resto;

        System.out.println("2 euro: " + da200);
        System.out.println("1 euro: " + da100);
        System.out.println("50 cent: " + da50);
        System.out.println("20 cent: " + da20);
        System.out.println("10 cent: " + da10);
        System.out.println("5 cent: " + da5);
        System.out.println("2 cent: " + da2);
        System.out.println("1 cent: " + da1);
    }
}
