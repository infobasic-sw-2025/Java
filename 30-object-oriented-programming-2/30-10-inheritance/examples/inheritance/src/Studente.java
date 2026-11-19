public class Studente extends Persona {

    private String matricola;

    public Studente(String nome, String email, String matricola) {
        super(nome, email);
        this.matricola = matricola;
    }

    public String getMatricola() {
        return matricola;
    }

    @Override
    public String toString() {
        return super.toString() + " - Matricola: " + matricola;
    }
}
