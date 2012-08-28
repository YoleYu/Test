/**
 * @author yale.yu
 * 2012-8-28
 */
package test.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class Main {
    public static int LOOP_TIMES = 10;
    
    public static void main(String[] args) {
        new Main().UN_ORDERED_EXECUATE();
    }

    @Test
    public void UN_ORDERED_EXECUATE(){
        Thread1 t1 = new Thread1();
        
        Thread2 runnable = new Thread2();
        Thread t2 = new Thread(runnable);
        
        t1.start();
        t2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //  Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class Thread1 extends Thread {
    public void run() {
        for (int i = 0; i < Main.LOOP_TIMES; i++) {
            DateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm:ss SS");
            System.out.println("Thread1 :" + df.format(new java.util.Date()));

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < Main.LOOP_TIMES; i++) {
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss SS");
            System.out.println("Thread2 :" + df.format(new java.util.Date()));

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}