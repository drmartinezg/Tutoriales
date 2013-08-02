package es.duero4.tddinactionjee.web.controller.spring;

import es.duero4.tddinactionjee.web.controller.authenticator.FakeAuthenticationService;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;
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
public class LoginControllerTest {
    private static final String CORRECT_PASSWORD = "correctpassword";
    private static final String VALID_USERNAME = "validuser";
    
    public LoginControllerTest() {
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
        // 1 - Populate mock objects
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter("j_username", "nosuchusername");
        request.addParameter("j_password", "nosuchpassword");
        MockHttpServletResponse response = new MockHttpServletResponse();
        
        // 2 - Invoke Controller's handleRequest() method
        Controller c = new LoginController();
        ModelAndView v = c.handleRequest(request, response);
        
        // 3 - User should land on "wrong password" page
        assertEquals("wrongpassword", v.getViewName());
    }
    
    @Test
    public void validLoginFrowardsToFrontPage() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setMethod("GET");
        request.addParameter("j_username", VALID_USERNAME);
        request.addParameter("j_password", CORRECT_PASSWORD);
        MockHttpServletResponse response = new MockHttpServletResponse();
        
        FakeAuthenticationService mock = new FakeAuthenticationService();
        mock.addUser(VALID_USERNAME, CORRECT_PASSWORD);
        
        LoginController c = new LoginController();
        // Simulate dependency injection
        c.setAuthenticationService(mock);
        ModelAndView v = c.handleRequest(request, response);
        
        assertEquals("frontpage", v.getViewName());
    }
}
