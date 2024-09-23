public class Consumatore extends Thread {
    Buffer buffer;
    int ritardo;

    public Consumatore(Buffer buffer, int ritardo) {
        this.buffer = buffer;
        this.ritardo = ritardo;
    }

    @Override
    public void run() {
        while(true) {
            try {
                String info = buffer.prelevaInfo();
                System.out.println(info);
                Thread.sleep(ritardo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
