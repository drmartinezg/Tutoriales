package es.duero4.tddinactionjee.web.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import static org.junit.Assert.*;

/**
 *
 * @author Ramon
 */
public class LoginServletTest {
    
    public LoginServletTest() {
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
    public void wrongPasswordShouldRedirectToErrorPage() throws Exception {
        HttpServlet servlet = new LoginServlet();
        // Create fake request object ...
        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/login");
        request.addParameter("j_username", "nosuchuser");
        request.addParameter("j_password", "wrongpassword");
        // ... and fake response object
        MockHttpServletResponse response = new MockHttpServletResponse();
        servlet.service(request, response);
        assertEquals("/invalidlogin", response.getRedirectedUrl());
    }
    
    @Test
    public void validLoginForwardsToFrontPageAndStoresUsername() throws Exception {
        LoginServlet servlet = new LoginServlet();
        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/login");
        request.addParameter("j_username", "validuser");
        request.addParameter("j_password", "correctpassword");
        MockHttpServletResponse response = new MockHttpServletResponse();
        servlet.service(request, response);
        assertEquals("/frontpage", response.getRedirectedUrl());
        assertEquals("validuser", request.getSession().getAttribute("username"));
    }
}
