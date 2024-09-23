public class App {
    public static void main(String[] args) throws Exception {
        Buffer buffer = new Buffer(20);
        new Produttore(buffer, 2000).start();
        new Consumatore(buffer, 2000).start();
    }
}
