/**
 * @author yale.yu
 * 2012-9-14
 */
package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * A collection of common method for test use
 *
 */
public class Util {

    /**
     * Get a formated time string "yyyy/MM/dd HH:mm:ss SS"
     * @return
     */
    public static String getTime(){
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss SS");
        return df.format(new java.util.Date());
    }

    public static Timer getTimer(){
        //return new TimerYoleImpl();
        return new TimerStandardImpl();
    }
    
    public static void sleep(long t){
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
