// Una sola superclasse, ma tante interfacce
class Anatra implements Volante, Nuotante {
    @Override
    public void vola() {
        System.out.println("L'anatra vola");
    }

    @Override
    public void nuota() {
        System.out.println("L'anatra nuota");
    }
}
