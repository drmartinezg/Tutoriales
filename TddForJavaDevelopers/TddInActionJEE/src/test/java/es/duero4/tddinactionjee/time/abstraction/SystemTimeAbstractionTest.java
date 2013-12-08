package es.duero4.tddinactionjee.time.abstraction;

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
public class SystemTimeAbstractionTest {
    
    public SystemTimeAbstractionTest() {
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
    public void resetTimeSource() {
        // 1 - Reset default TimeSource after each test
        SystemTime.reset();
    }
    
    @Test
    public void clockReturnsFakedTimeInMilliseconds() throws Exception {
        final long fakeTime = 12345690L;
        // 2 - Swap in fixed time source
        SystemTime.setTimeSource(new TimeSource() {
            @Override
            public long millis() {
                return fakeTime;
            }
        });
        long clock = SystemTime.asMillis();
        // 3 - SystemTime should use our TimeSource
        assertEquals("Should return fake time", fakeTime, clock);
    }
    
    @Test
    public void clockReturnsValidTimeInMilliseconds() throws Exception {
        // Triangulate SystemTime's correctness with System.currentTimeMillis().
        long before = System.currentTimeMillis();
        long clock = SystemTime.asMillis();
        long after = System.currentTimeMillis();
        assertBetween(before, clock, after);
    }

    private void assertBetween(long before, long actual, long after) {
        assertTrue("Should've returned something between " + before + " and " + after + " (instead of " + actual + ")", 
                   before <= actual && actual <= after);
    }
}
