public class Ex02RuntimeErrore {
    public static void main(String[] args) {
        String nome = "Mario";  // era null: su null non si può chiamare length()
        System.out.println("Lettere del nome: " + nome.length());
    }
}
