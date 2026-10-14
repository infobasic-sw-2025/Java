// public --> Modificatore di visibilità
// class --> E' una classe
// Main --> Nome del file

// Come si esegue una classe?
// Metodo 1) javac della classe e poi java nome del file da terminale
// Metodo 2) Run dall'IDE (IntelliJ o VS Code)
public class Main {

    // static --> Non mi serve una istanza della classe per eseguirlo
    // void --> Non ha nessun ritorno dal metodo (no return)
    // main --> nome del metodo
    // String --> Tipo stringa
    // [] --> Array
    // args --> arguments
    public static void main(String[] args){
        System.out.println("Hello world!");

        // if else
        int age = 18; // la taglia della var int è molto superiore a quello che ci serve

        if(age>=18) {
            System.out.println("Sono maggiorenne");
            // si può riscrivere? Esercizio :)
        } else if (age == 17 || age == 16) {
            System.out.println("Sono quasi maggiorenne");
        } else {
            System.out.println("Non sono maggiorenne");
        }

        boolean loopCondition = true;
        while(loopCondition && 1==1){
            System.out.println("Sono un loop infinito");
            loopCondition = false;
        }

        for(int i=0; i<10; i++){
            for(int j=0; j<10;j++){
                System.out.println("Indice[i][j]: " + (i + j));
            }
        }

        System.out.println("Sono uscito dal loop infinito");
    }
}
