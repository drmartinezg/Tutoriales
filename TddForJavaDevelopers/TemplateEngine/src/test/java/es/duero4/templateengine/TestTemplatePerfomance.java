package es.duero4.templateengine;

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
public class TestTemplatePerfomance {
    
    private Template template;
    
    public TestTemplatePerfomance() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        template = new Template("${one}, ${two}, ${three}, ${four}, ${five}, ${six}, ${seven}, ${eight}, ${nine}, ${ten}, ${eleven}, ${twelve}, ${thirteen}, ${fourteen}, ${fiveteen}, ${sixteen}, ${seventeen}, ${eighteen}, ${nineteen}, ${twenty}" );
        template.set("one",   "11111111111111111111");
        template.set("two",   "22222222222222222222");
        template.set("three", "33333333333333333333");
        template.set("four",  "44444444444444444444");
        template.set("five",  "55555555555555555555");
        template.set("six",   "66666666666666666666");
        template.set("seven", "77777777777777777777");
        template.set("eight", "88888888888888888888");
        template.set("nine",  "99999999999999999999");
        template.set("ten",   "10101010101010101010");
        template.set("eleven", "11111111111111111111");
        template.set("twelve", "12121212121212121212");
        template.set("thirteen", "131313131313131313");
        template.set("fourteen", "141414141414141414");
        template.set("fiveteen", "15151515151515151515");
        template.set("sixteen", "1616161616161616161616");
        template.set("seventeen", "171717171717171717171717");
        template.set("eighteen", "18181818181818181818181818");
        template.set("nineteen", "1919191919191919191919191919");
        template.set("twenty", "20202020202020202020202020202020");
        template.set("twenty-one", "123456789012345678901");
        template.set("twenty-two", "1234567890123456789012");
        template.set("twenty-three", "12345678901234567890123");
        template.set("twenty-four", "123456789012345678901234");
        template.set("twenty-five", "1234567890123456789012345");
        template.set("twenty-six", "12345678901234567890123456");
        template.set("twenty-seven", "123456789012345678901234567");
        template.set("twenty-eight", "1234567890123456789012345678");
        template.set("twenty-nine", "12345678901234567890123456789");
        template.set("thirty", "123456789012345678901234567890");
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void templateWith30WordsAnd20Variables() {
        long expected = 10L;
        long time1 = System.currentTimeMillis();
        String result = template.evaluate();
        long time = System.currentTimeMillis() - time1;
        // System.out.println("time<" + time + "> template<" + result + ">");
        assertTrue("Rendering the template took " + time
                + "ms while the target was " + expected + "ms", 
                time <= expected);
    }
}
