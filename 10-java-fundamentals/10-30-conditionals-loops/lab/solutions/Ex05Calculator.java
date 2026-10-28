public class Ex05Calculator {
    public static void main(String[] args) {
        int a = 17;
        int b = 5;
        char operazione = '/';

        String risultato = switch (operazione) {
            case '+' -> "" + (a + b);
            case '-' -> "" + (a - b);
            case '*' -> "" + (a * b);
            case '/' -> {
                if (b == 0) {
                    yield "divisione per zero";
                }
                yield a / b + " con resto " + a % b;
            }
            default -> "operazione sconosciuta";
        };
        System.out.println(a + " " + operazione + " " + b + " = " + risultato);
    }
}
