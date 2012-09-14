/**
 * @author yale.yu
 * 2012-9-14
 */
package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * A collection of common method for test use
 *
 */
public class Util {

    public static void sleep(long t){
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get a formated time string "yyyy/MM/dd HH:mm:ss SS"
     * @return
     */
    public static String getTime(){
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss SS");
        return df.format(new java.util.Date());
    }
}
