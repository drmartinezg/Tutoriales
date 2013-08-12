package es.duero4.tddinactionjee.wicket.normal;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sun.security.jgss.LoginConfigImpl;
import static org.junit.Assert.*;

/**
 *
 * @author Ramon
 */
public class MyHomePageTest {
    
    public MyHomePageTest() {
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
    public void homePageHasWellcomeText() throws Exception {
        WicketTester tester = new WicketTester();
        tester.startPage(MyHomePage.class);
        
        tester.assertRenderedPage(MyHomePage.class);
        tester.assertNoErrorMessage();
        
        // 1 - Expect to find named "welcomeMessage"...
        tester.assertLabel("welcomeMessage", "Welcome to the home page!");
        // 2 - ... and link to login page
        tester.assertPageLink("linkToLoginPage", LoginPage.class);
    }
}
