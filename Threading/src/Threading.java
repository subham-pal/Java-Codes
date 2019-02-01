import static java.lang.Thread.currentThread;

class Myjob1 implements Runnable {
    public void run() {
        for(int i = 0; i < 100; ++i) {
            System.out.println(currentThread().getName() + " : " + i);
        }
    }
}

class Myjob2 extends Thread {
    public void run() {
        for(int i = 0; i < 100; ++i){
            System.out.println(currentThread().getName() + " : " + i);
        }
    }
}
public class Threading {
    public static void main(String[] args) {
        //Implementing runnable interface
        Thread t1 = new Thread(new Myjob1());

        //Extending Thread class
        Myjob2 t2 = new Myjob2();
        
        t1.setName("Colt");
        t2.setName("Shelly");
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
