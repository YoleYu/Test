/**
 * @author yale.yu
 * 2012-9-18
 */
package util;

import java.util.Date;
import java.util.TimerTask;

public class TimerStandardImpl extends TimerTask implements Timer {
    private int count = 0;
    private java.util.Timer timer;

    public TimerStandardImpl() {
        timer = new java.util.Timer();
    }

    @Override
    public Timer start() {
        timer.schedule(this, new Date(), 1000);
        return this;
    }

    @Override
    public void stop() {
        timer.cancel();
    }

    @Override
    public void run() {
        System.out.println("Standard timer: " + count++);
    }

}
