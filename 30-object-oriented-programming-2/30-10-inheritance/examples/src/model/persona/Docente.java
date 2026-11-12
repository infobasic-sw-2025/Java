package model.persona;

import java.util.Objects;

public class Docente extends Persona {

    private String pIva;

    public Docente(String nome, String email, String pIva){
        super(nome, email);
        this.pIva = pIva;
    }

    public void salutaDocente(){
        // codiceFiscale è protected, posso usarlo dalla sottoclasse
        System.out.println("Ciao Docente " + super.codiceFiscale);
        salutaPersonaProtected(); // anche i metodi protected si usano dalla sottoclasse
    }

    public String getpIva() {
        return pIva;
    }

    public void setpIva(String pIva) {
        this.pIva = pIva;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Docente docente = (Docente) o;
        return Objects.equals(pIva, docente.pIva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pIva);
    }

    @Override
    public String toString() {
        return super.toString() + " - " + "Docente{" +
                "pIva='" + pIva + '\'' +
                '}';
    }
}
