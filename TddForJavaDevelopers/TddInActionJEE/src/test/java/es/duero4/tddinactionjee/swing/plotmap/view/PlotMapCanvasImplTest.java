package es.duero4.tddinactionjee.swing.plotmap.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import junit.extensions.abbot.ComponentTestFixture;
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
public class PlotMapCanvasImplTest extends ComponentTestFixture {
    
    private Component canvas;
    
    public PlotMapCanvasImplTest(String name) {
        super(name);
    }
    

    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        canvas = new PlotMapCanvasImpl();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testDimensionsShouldBeAutomaticallySet() throws Exception {
        // Use Abbot's base class to render component
        showFrame(canvas);
        assertEquals(new Dimension(200, 100), canvas.getSize());
        assertEquals(canvas.getSize(), canvas.getBounds().getSize());
    }
    
    @Test
    public void testBackgroudColorIsWhite() throws Exception {
        assertEquals(Color.WHITE, canvas.getBackground());
    }
}
