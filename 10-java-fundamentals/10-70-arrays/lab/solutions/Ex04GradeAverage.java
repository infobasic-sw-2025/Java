public class Ex04GradeAverage {
    public static void main(String[] args) {
        int[] voti = {7, 5, 8, 4, 9, 6, 3};

        int somma = 0;
        int sufficienti = 0;
        for (int v : voti) {
            somma += v;
            if (v >= 6) {
                sufficienti++;
            }
        }

        // Il cast a double evita la divisione intera
        double media = (double) somma / voti.length;

        System.out.println("Media: " + media);                                  // → 6.0
        System.out.println("Sufficienti: " + sufficienti + " su " + voti.length); // → 4 su 7
    }
}
