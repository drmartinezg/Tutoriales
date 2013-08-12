package es.duero4.tddinactionjee.wicket.normal;

import org.junit.Ignore;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ramon
 */
public class MyHomePageTest {
    
    private WicketTester tester;
    
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
        tester = new WicketTester();
    }
    
    @After
    public void tearDown() {
    }
    
    @Ignore
    @Test
    public void homePageHasWellcomeText() throws Exception {
        tester.startPage(MyHomePage.class);
        
        tester.assertRenderedPage(MyHomePage.class);
        tester.assertNoErrorMessage();
        
        tester.assertLabel("welcomeMessage", "Welcome to the home page!");
        tester.assertPageLink("linkToLoginPage", LoginPage.class);
    }
    
    @Ignore
    @Test
    public void interactingWithComponents() throws Exception {
        tester.startPage(MyHomePage.class);
        tester.assertRenderedPage(MyHomePage.class);
        tester.clickLink("linkToLoginPage");
        tester.assertRenderedPage(LoginPage.class);
    }
}
