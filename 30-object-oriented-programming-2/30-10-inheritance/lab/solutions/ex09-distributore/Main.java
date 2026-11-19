public class Main {
    public static void main(String[] args) {
        Caffe caffe = new Caffe("caffe", 0.5);
        Cappuccino cappuccino = new Cappuccino("cappuccino", 1.0);
        DistributoreDiBevande dist = new DistributoreDiBevande(10);
        dist.caricaProdotto(caffe);
        dist.caricaProdotto(cappuccino);
        dist.inserisciImporto(2.0);
        System.out.println(dist.scegliProdotto("caffe"));
        System.out.println(dist.scegliProdotto("cappuccino"));
        System.out.println(dist.getResto());
        System.out.println(dist.scegliProdotto("caffe"));
    }
}
