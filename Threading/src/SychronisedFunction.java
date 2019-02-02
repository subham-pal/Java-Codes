class Job4 implements Runnable{
    static char ch = 'a';
    static int[] h = new int[] {0, 0, 0};
    public synchronized void run() {
        for(int i = 0; i < 200; ++i) {
            System.out.print(ch);
            ++h[ch - 'a'];
        }
        System.out.println();
        ++ch;
    }
    public static void get() {
        System.out.println(h[0] + " " + h[1] + " " + h[2]);
    }
}
public class SychronisedFunction {
    public static void main(String[] args) {
        Job4 j1 = new Job4();
        Thread t1 = new Thread(j1);
        Thread t2 = new Thread(j1);
        Thread t3 = new Thread(j1);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Job4.get();
    }
}
