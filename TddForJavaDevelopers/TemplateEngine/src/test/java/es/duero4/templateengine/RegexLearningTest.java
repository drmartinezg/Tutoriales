package es.duero4.templateengine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
public class RegexLearningTest {
    
    public RegexLearningTest() {
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
    public void TestHowGroupCountWorks() {
        String haystack = "The needle shop sells needles";
        String regex = "(needle)";
        Matcher matcher = Pattern.compile(regex).matcher(haystack);
        assertEquals(1, matcher.groupCount());
    }
    
    @Test
    public void testFindStartAndEnd() {
        String haystack = "The needle shop sells needles";
        String regex = "(needle)";
        Matcher matcher = Pattern.compile(regex).matcher(haystack);
        
        assertTrue(matcher.find());
        assertEquals("Wrong start index of 1st match", 4, matcher.start());
        assertEquals("Wrong end index of 1st match", 10, matcher.end());
        
        assertTrue(matcher.find());
        assertEquals("Wrong start index of 2nd match", 22, matcher.start());
        assertEquals("Wrong end index of 2nd match", 28, matcher.end());
        
        assertFalse("Should not have any more matches", matcher.find());
    }
}
