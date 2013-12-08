package es.duero4.tddinactionjee.time.logging;

import es.duero4.tddinactionjee.time.abstraction.SystemTime;
import es.duero4.tddinactionjee.time.abstraction.TimeSource;
import java.text.DateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

/**
 *
 * @author Ramon
 */
public class HttpRequestLogFormatterTest {
    
    public HttpRequestLogFormatterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        // 1 - Dont't leave residue
        SystemTime.reset();
    }
    
    @Test
    public void testCommonLogFormat() throws Exception {
        // 2 - Configure fixed time
        final long time = SystemTime.asMillis();
        SystemTime.setTimeSource(new TimeSource() {
            @Override
            public long millis() {
                return time;
            }
        });
        
        // 3 - Build expected output based on fixed time
        DateFormat dateFormat = HttpRequestLogFormatter.dateFormat;
        String timestamp = dateFormat.format(SystemTime.asDate());
        String expected = "1.2.3.4 - rmg [" + timestamp + 
                          "] \"GET /ctx/resource HTTP/1.1\" 200 2326";
        
        HttpServletRequest request = createMock(HttpServletRequest.class);
        expect(request.getRemoteAddr()).andReturn("1.2.3.4");
        expect(request.getRemoteUser()).andReturn("rmg");
        expect(request.getMethod()).andReturn("GET");
        expect(request.getRequestURI()).andReturn("/ctx/resource");
        expect(request.getProtocol()).andReturn("HTTP/1.1");
        replay(request);
        
        HttpRequestLogFormatter formatter = new HttpRequestLogFormatter();
        assertEquals(expected, formatter.format(request, 200, 2326));
    }
    
    @Test
    public void testTimestampFormat() throws Exception {
        String date = "\\d{2}/\\w{3}/\\d{4}";
        String time = "\\d{2}:\\d{2}:\\d{2}";
        String timezone = "(-|\\+)\\d{4}";
        String regex = date + ":" + time + " " + timezone;
        
        DateFormat dateFormat = HttpRequestLogFormatter.dateFormat;
        String timestamp = dateFormat.format(new Date());
        assertTrue("DateFormat should be \"dd/mon/yyyy:HH:mm:ss Z\"", timestamp.matches(regex));
    }
}
