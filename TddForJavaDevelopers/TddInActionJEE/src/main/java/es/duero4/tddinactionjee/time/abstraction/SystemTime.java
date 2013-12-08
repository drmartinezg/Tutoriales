package es.duero4.tddinactionjee.time.abstraction;

import java.util.Date;

/**
 *
 * @author Ramon
 */
public class SystemTime {
    
    // 1 - Default TimeSource delegates to system clock
    private static final TimeSource defaultSrc = new TimeSource() {
        @Override
        public long millis() {
            return System.currentTimeMillis();
        }
    };
    
    private static TimeSource source = null;

    public static long asMillis() {
        // 2 - SystemTime asks for active TimeSource implementation
        return getTimeSource().millis();
    }

    public static Date asDate() {
        return new Date(asMillis());
    }
    
    public static void reset() {
        setTimeSource(null);
    }

    public static void setTimeSource(TimeSource source) {
        SystemTime.source = source;
    }

    private static TimeSource getTimeSource() {
        // 3 - Use configured TimeSource, if present
        return (source != null ? source : defaultSrc);
    }
}
