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
    
    MockHttpServletRequest request;
    MockHttpServletResponse response;
    LoginController controller;
    
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
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        controller = new LoginController();
        
        FakeAuthenticationService mock = new FakeAuthenticationService();
        mock.addUser(VALID_USERNAME, CORRECT_PASSWORD);
        // Simulate dependency injection
        controller.setAuthenticationService(mock);
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void wrongPasswordShouldRedirectToErrorPage() throws Exception {
        // 1 - Populate mock objects
        request.addParameter("j_username", "nosuchusername");
        request.addParameter("j_password", "nosuchpassword");
        
        // 2 - Invoke Controller's handleRequest() method
        ModelAndView v = controller.handleRequest(request, response);
        
        // 3 - User should land on "wrong password" page
        assertEquals("wrongpassword", v.getViewName());
    }
    
    @Test
    public void validLoginFrowardsToFrontPage() throws Exception {
        request.setMethod("GET");
        request.addParameter("j_username", VALID_USERNAME);
        request.addParameter("j_password", CORRECT_PASSWORD);
        
        ModelAndView v = controller.handleRequest(request, response);
        
        assertEquals("frontpage", v.getViewName());
    }
}
