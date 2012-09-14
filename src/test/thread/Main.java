/**
 * @author yale.yu
 * 2012-8-28
 */
package test.thread;

import org.junit.Test;

import test.Util;

public class Main {
    public static int LOOP_TIMES = 10;
    
    public static void main(String[] args) {
        Main test = new Main();
        test.UN_ORDERED_EXECUATE();
    }

    //@Test junit CAN'T support multiple thread test
    // it use System.exit() to end the program.
    // http://groboutils.sourceforge.net plugin for junit thread test
    public void UN_ORDERED_EXECUATE(){
        Thread1 t1 = new Thread1();
        
        Thread2 runnable = new Thread2();
        Thread t2 = new Thread(runnable, "Thread2");
        
        t1.start();
        t2.start();
        
        Util.sleep(30);
        for(int i=0; i < LOOP_TIMES; i++){
            System.out.println("Main :" + Util.getTime());
        }
    }

    public void JOIN(){
        Thread2 runnable = new Thread2();
        Thread t1 = new Thread(runnable, "First Thread");
        Thread t2 = new Thread(runnable, "Second Thread");
    }

    @Test
    public void test(){
        int[] a = new int[1],
              b = new int[1],
              c = new int[1];
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}

class Thread1 extends Thread {
    public void run() {
        for (int i = 0; i < Main.LOOP_TIMES; i++) {
            System.out.println(getName() + " : " + Util.getTime());
            Util.sleep(10);
        }
    }
}

class Thread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < Main.LOOP_TIMES; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + Util.getTime());
            Util.sleep(10);
        }
    }

}