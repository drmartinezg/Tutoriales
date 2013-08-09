package es.duero4.tddinactionjee.wicket.normal;

import org.apache.wicket.protocol.http.WebApplication;
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
public class MyWicketAppTest {
    
    public MyWicketAppTest() {
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
    public void homePageHasBeenDefined() {
        WebApplication app = new MyWicketApp();
        assertEquals(MyHomePage.class, app.getHomePage());
    }
}
