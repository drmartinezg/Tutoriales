package es.duero4.tddinactionjee.wicket.normal;

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
        // 1 - Create WicketTester for page
        WicketTester tester = new WicketTester();
        tester.startPage(MyHomePage.class);
        
        // 2 - Check for rending errors
        tester.assertRenderedPage(MyHomePage.class);
        tester.assertNoErrorMessage();
        
        // 3 - Assert page contents
        tester.assertContains("Wellcome to the home page!");
    }
}
