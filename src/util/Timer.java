/**
 * @author yale.yu
 * 2012-9-18
 */
package util;

/**
 * This is designed for Thread test, to log time count.
 * @author yale.yu
 *
 */
public interface Timer {
    /**
     * start timer and log time count
     * @return
     */
    public Timer start();
    
    /**
     * stop timer
     */
    public void stop();
}
