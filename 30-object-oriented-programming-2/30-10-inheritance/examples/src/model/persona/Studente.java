package model.persona;

import java.util.Objects;

/*
* Se non esplicito il costruttore di Studente e Persona non ha il costruttore no-args ottengo
* un errore a tempo di compilazione.
*   IntelliJ: There is no no-arg constructor available in 'model.persona.Persona'
*   javac:    constructor Persona in class Persona cannot be applied to given types;
*             required: String,String
*
* Soluzione: Prevedere costruttore no args dentro Persona OPPURE esplicitare costruttore dentro
* Studente passando due parametri a Persona(String, String);
* */
public class Studente extends Persona {
    private String matricola;

    public Studente(String nome, String email, String matricola){
        super(nome, email); // Occhio all'ordine con cui passo i parametri dentro super()
        this.matricola = matricola;
    }

    @Override
    public void salutaPersona(){
        System.out.println("Ciao Studente"); // stesso metodo di Persona, comportamento diverso
    }

    public void salutaStudente(){
        System.out.println("Ciao Studente");
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + "Studente{" +
                "matricola='" + matricola + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Studente studente = (Studente) o;
        return Objects.equals(matricola, studente.matricola);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), matricola);
    }
}
