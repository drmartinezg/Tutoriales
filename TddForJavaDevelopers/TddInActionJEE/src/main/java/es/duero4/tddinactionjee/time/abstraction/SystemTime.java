package es.duero4.tddinactionjee.time.abstraction;

/**
 *
 * @author Ramon
 */
public class SystemTime {

    public static long asMillis() {
        return System.currentTimeMillis();
    }

    public static void reset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static void setTimeSource(TimeSource timeSource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
