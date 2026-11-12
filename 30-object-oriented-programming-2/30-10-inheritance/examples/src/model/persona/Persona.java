package model.persona;

import java.util.Objects;

public class Persona {
    private String nome;
    private String email;
    protected String codiceFiscale;
    public String variabileIstanzaPubblica;

    public Persona(String nome, String email) {
        this.nome = nome;
        this.email = email;
        variabileIstanzaPubblica = "Variabile visibile ovunque nel progetto"; // NON FARE
        codiceFiscale = "CF_TEST";
    }

    public void salutaPersona(){
        System.out.println("Ciao Persona");
    }

    protected void salutaPersonaProtected(){
        System.out.println("Ciao Persona Estesa");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(email, persona.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
