package es.duero4.templateengine;

import java.util.List;
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
public class TestTemplateParse {
    
    public TestTemplateParse() {
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
    public void emptyTemplateRendersAsEmptyString() {
        List<String> segments = parse("");
        assertEquals("Number of segments", 1, segments.size());
        assertEquals("", segments.get(0));
    }

    @Test
    public void templateWithOnlyPlainText() {
        List<String> segments = parse("plain text only");
        assertEquals("Number of segments", 1, segments.size());
        assertEquals("plain text only", segments.get(0));
    }

    private List<String> parse(String template) {
        return new TemplateParse().parse(template);
    }
}
