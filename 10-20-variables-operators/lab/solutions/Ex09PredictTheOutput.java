public class Ex09PredictTheOutput {
    public static void main(String[] args) {
        int x = 10;
        System.out.println(x++ + ++x);           // 1
        System.out.println(x);                   // 2
        System.out.println(17 / 4 * 4 + 17 % 4); // 3
        System.out.println(5 / 2 * 2.0);         // 4
        System.out.println("Java" + 2 + 5);      // 5
        System.out.println(2 + 5 + "Java");      // 6
        System.out.println('a' + 'b');           // 7
        System.out.println("" + 'a' + 'b');      // 8
        System.out.println((int) 3.99 + (int) -3.99); // 9
        System.out.println((byte) 130);          // 10
        System.out.println(0.1 + 0.2 == 0.3);    // 11
    }
}
