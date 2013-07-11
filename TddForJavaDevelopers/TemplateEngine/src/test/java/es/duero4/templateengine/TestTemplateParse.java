package es.duero4.templateengine;

import java.util.Arrays;
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
        assertSegments(segments, "");
    }

    @Test
    public void templateWithOnlyPlainText() {
        List<String> segments = parse("plain text only");
        assertSegments(segments, "plain text only");
    }
    
    @Test
    public void parsingMultiplesVariables() {
        List<String> segments = parse("${a}:${b}:${c}");
        assertSegments(segments, "${a}", ":", "${b}", ":", "${c}");
    }

    @Test
    public void parsingTemplateIntoSegmentObjects() {
        TemplateParse templateParse = new TemplateParse();
        List<Segment> segments = templateParse.parseSegments("a ${b} c ${d}");
        assertSegments(segments,
                new PlainText("a "), new Variable("b"),
                new PlainText(" c "), new Variable("d"));
    }
    
    private List<String> parse(String template) {
        return new TemplateParse().parse(template);
    }
    
    private void assertSegments(List<? extends Object> actual,
                                Object... expected) {
        assertEquals("Number of segments doesn't match.",
                     expected.length, actual.size());
        assertEquals(Arrays.asList(expected), actual);
    }
}
