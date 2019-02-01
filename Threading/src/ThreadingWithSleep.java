import static java.lang.Thread.currentThread;

class Myjob3 implements Runnable {
    public void run() {
        for(int i = 0; i < 100; ++i) {
            System.out.println(i);
            if(i % 10 == 0) try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadingWithSleep {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Myjob3());
        t1.setName("Colt");
        t1.start();
    }
}
