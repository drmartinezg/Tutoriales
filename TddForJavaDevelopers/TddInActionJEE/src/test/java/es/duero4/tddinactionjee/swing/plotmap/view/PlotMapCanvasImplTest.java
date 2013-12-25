package es.duero4.tddinactionjee.swing.plotmap.view;

import java.awt.Component;
import java.awt.Dimension;
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
public class PlotMapCanvasImplTest {
    
    public PlotMapCanvasImplTest() {
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
    public void testDimensionsShouldBeAutomaticallySet() throws Exception {
        Component canvas = new PlotMapCanvasImpl();
        assertEquals(new Dimension(200, 100), canvas.getSize());
    }
}
