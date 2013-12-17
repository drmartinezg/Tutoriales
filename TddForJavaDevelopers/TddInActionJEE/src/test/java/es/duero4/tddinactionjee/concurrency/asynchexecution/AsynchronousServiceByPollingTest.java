package es.duero4.tddinactionjee.concurrency.asynchexecution;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ramon
 */
public class AsynchronousServiceByPollingTest {
    
    public AsynchronousServiceByPollingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAfterLongWait() throws Exception {
        LongLastingCalculation calc = new LongLastingCalculation();
        calc.start();
        Thread.sleep(2000);
        Assert.assertEquals(42, (int) calc.getResult());
    }
}
