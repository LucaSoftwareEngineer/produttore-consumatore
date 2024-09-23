import java.util.LinkedList;

public class Buffer {
    LinkedList<String> coda; //FIFO
    int max;
    String null_value = "";

    public Buffer(int max) {
        this.coda = new LinkedList<String>();
        this.max = max;
    }

    public boolean vuoto() {
        return this.coda.isEmpty();
    }

    public boolean pieno() {
        return this.coda.size()>this.max;
    }

    public synchronized void aggiungiInfo(String info) throws InterruptedException {
        while(pieno()){
            wait();
            coda.addFirst(info);
            notifyAll();
        }
    }

    public synchronized String prelevaInfo() throws InterruptedException {
        while(vuoto()){
            wait();
            String info = coda.removeFirst();
            notifyAll();
            return info;
        }
        return null_value;
    }
}
