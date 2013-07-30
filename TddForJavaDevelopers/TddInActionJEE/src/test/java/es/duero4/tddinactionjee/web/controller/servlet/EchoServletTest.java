package es.duero4.tddinactionjee.web.controller.servlet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 *
 * @author Ramon
 */
public class EchoServletTest {
    
    public EchoServletTest() {
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
    public void testEchoingParametersWithMultipleValues() throws Exception {
        // 1 - Create and populate mock objects
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.addParameter("param1", "param1value1");
        request.addParameter("param2", "param2value1");
        request.addParameter("param2", "param2value2");
        
        // 2 - Execute production code with mocks
        new EchoServlet().doGet(request, response);
        
        // 3 - Make assertions against response
        String[] lines = response.getContentAsString().split("\n");
        assertEquals("param1=param1value1", lines[0]);
        assertEquals("param2=param2value1", lines[1]);
        assertEquals("param2=param2value2", lines[2]);
    }
}
