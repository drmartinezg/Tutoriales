package es.duero4.tddinactionjee.web.controller.servlet;

import es.duero4.tddinactionjee.web.controller.authenticator.AuthenticationService;
import es.duero4.tddinactionjee.web.controller.authenticator.FakeAuthenticationService;
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
    private static final String CORRECT_PASSWORD = "correctpassword";
    private static final String VALID_USERNAME = "validuser";
    
    // By moving common objects into fields
    private LoginServlet servlet;
    private FakeAuthenticationService authenticator;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    
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
        authenticator = new FakeAuthenticationService();
        authenticator.addUser(VALID_USERNAME, CORRECT_PASSWORD);

        servlet = new LoginServlet() {
            // Use fake instead of real thing
            @Override
            protected AuthenticationService getAuthenticationService() {
                return authenticator;
            }
        };
        
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void wrongPasswordShouldRedirectToErrorPage() throws Exception {
        request.addParameter("j_username", VALID_USERNAME);
        request.addParameter("j_password", "wrongpassword");
        servlet.service(request, response);
        assertEquals("/invalidlogin", response.getRedirectedUrl());
    }
    
    @Test
    public void validLoginForwardsToFrontPageAndStoresUsername() throws Exception {
        request.addParameter("j_username", VALID_USERNAME);
        request.addParameter("j_password", CORRECT_PASSWORD);
        
        servlet.service(request, response);
        assertEquals("/frontpage", response.getRedirectedUrl());
        assertEquals(VALID_USERNAME, request.getSession().getAttribute("username"));
    }
}
