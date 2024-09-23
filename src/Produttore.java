public class Produttore extends Thread {
    Buffer buffer;
    int ritardo;
    Integer i = 0;

    public Produttore(Buffer buffer, int ritardo) {
        this.buffer = buffer;
        this.ritardo = ritardo;
    }

    @Override
    public void run() {
        while(true) {
            try {
                String info = "ciao".concat(i.toString());
                buffer.aggiungiInfo(info);
                System.out.println(info);
                Thread.sleep(ritardo);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
