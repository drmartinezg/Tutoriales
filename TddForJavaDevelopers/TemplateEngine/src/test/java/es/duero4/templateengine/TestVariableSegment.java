package es.duero4.templateengine;

import java.util.Map;
import java.util.HashMap;
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
public class TestVariableSegment {
    
    public TestVariableSegment() {
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
    public void variableEvaluatesToItsValue() {
        Map<String, String> variables = new HashMap<String, String>();
        String name = "myvar";
        String value = "myvalue";
        variables.put(name, value);
        assertEquals(value, new Variable(name).evaluate(variables));
    }
}
