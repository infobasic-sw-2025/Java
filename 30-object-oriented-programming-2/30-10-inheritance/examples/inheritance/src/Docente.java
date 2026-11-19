public class Docente extends Persona {

    private String materia;

    public Docente(String nome, String email, String materia) {
        super(nome, email);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    @Override
    public String toString() {
        return super.toString() + " - Materia: " + materia;
    }
}
