/**
 * @author yale.yu
 * 2012-9-18
 */
package util;

public class TimerYoleImpl implements Runnable, Timer{
    private int count = 0;
    private boolean stopFlag;

    public TimerYoleImpl() {
        stopFlag = true;
    }

    @Override
    public void run() {
        while (stopFlag) {
            Util.sleep(1000);
            System.out.println("Yole timer: " + count++);
        }
    }

    @Override
    public TimerYoleImpl start(){
        Thread thread = new Thread(this);
        thread.start();
        return this;
    }

    @Override
    public void stop(){
        stopFlag = false;
    }

    public void setStopFlag(boolean flag) {
        stopFlag = flag;
    }
}
