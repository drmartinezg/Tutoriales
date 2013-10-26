package es.duero4.tddinactionjee.time.logging;

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
    }
    
    @Test
    public void testCommonLogFormat() throws Exception {
        String expected = "1.2.3.4 - rmg [16/Oct/2013 20:21:22 +0100] " +
                          "\"GET /ctx/resource HTTP/1.1\" 200 2326";
        HttpServletRequest request = createMock(HttpServletRequest.class);
        expect(request.getRemoteAddr()).andReturn("1.2.3.4");
        expect(request.getRemoteUser()).andReturn("rmg");
        expect(request.getMethod()).andReturn("GET");
        expect(request.getRequestURI()).andReturn("/ctx/resource");
        expect(request.getProtocol()).andReturn("HTTP/1.1");
        replay(request);
        
//        HttpRequestLogFormatter formatter = new HttpRequestLogFormatter();
//        assertEquals(expected, formatter.format(request, 200, 2326));
    }
}
