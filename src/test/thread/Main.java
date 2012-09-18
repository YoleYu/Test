/**
 * @author yale.yu
 * 2012-8-28
 */
package test.thread;

import org.junit.Test;

import util.Timer;
import util.Util;

public class Main {
    public static int LOOP_TIMES = 5;

    public static void main(String[] args) {
        Main test = new Main();
        //test.UN_ORDERED_EXECUATE();
        test.JOIN();
    }

    // @Test junit CAN'T support multiple thread test
    // it use System.exit() to end the program.
    // http://groboutils.sourceforge.net plugin for junit thread test
    public void UN_ORDERED_EXECUATE() {
        Thread1 t1 = new Thread1();

        Thread2 runnable = new Thread2();
        Thread t2 = new Thread(runnable, "Thread2");

        t1.start();
        t2.start();

        Util.sleep(30);
        for (int i = 0; i < LOOP_TIMES; i++) {
            System.out.println("Main :" + Util.getTime());
        }
    }

    /**
     * Current thread wait until invoker died<br/>
     * <pre>
     * main------------------      ----.
     *     |-------jion------.      
     * </pre>
     * 
     */
    public void JOIN() {
        Timer timer = Util.getTimer().start();

        Thread2 runnable = new Thread2();
        Thread t1 = new Thread(runnable, "First Thread");
        Thread t2 = new Thread(runnable, "Second Thread");
        t2.start();
        t1.start();

        try {
          //makes t1 running and suspend current thread
           t1.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < Main.LOOP_TIMES; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + Util.getTime());
            Util.sleep(1000);
        }

        timer.stop();
    }

    @Test
    public void test() {
        int[] a = new int[1], b = new int[1], c = new int[1];
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}

class Thread1 extends Thread {
    public void run() {
        for (int i = 0; i < Main.LOOP_TIMES; i++) {
            System.out.println(getName() + " : " + Util.getTime());
            Util.sleep(1000);
        }
    }
}

class Thread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < Main.LOOP_TIMES; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + Util.getTime());
            Util.sleep(1000);
        }
    }

}