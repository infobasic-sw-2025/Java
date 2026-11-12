import model.persona.Docente;
import model.persona.Persona;
import model.persona.Studente;

public class Main {

    public static void main(String[] args){
        System.out.println("OOP 2 - Getting Started");

        // A sinistra ho il tipo "statico" mi dice quali metodi posso usare
        // A destra il tipo dinamico, mi dà il comportamento di questi metodi
        Persona p1 = new Persona("N1", "e1@email.com");
        Persona p2 = new Studente("S1", "s1@email.com", "MS01");
        Persona p3 = new Docente("D1", "d1@email.com", "PIVA_D1");

        p1.salutaPersona(); // Ciao Persona
        p2.salutaPersona(); // Ciao Studente: Studente fa l'override di salutaPersona()
        p3.salutaPersona(); // Ciao Persona: Docente non fa l'override, usa il metodo di Persona
        // p2.salutaStudente(); Non posso usare salutaStudente perché il tipo di p2 è "Persona"
        // error: cannot find symbol - symbol: method salutaStudente() - location: variable p2 of type Persona
        // p2.salutaDocente();

        String v = p1.variabileIstanzaPubblica;
        // String cf = p1.codiceFiscale; // 'codiceFiscale' has protected access in 'model.persona.Persona'
        // Main non è una sottoclasse e sta in un altro package. Da una classe del package
        // model.persona, invece, p1.codiceFiscale compila: protected vale anche per il package

        // println chiama toString(): si vede l'override di Studente e di Docente
        System.out.println(p2);
        System.out.println(p3);
    }
}