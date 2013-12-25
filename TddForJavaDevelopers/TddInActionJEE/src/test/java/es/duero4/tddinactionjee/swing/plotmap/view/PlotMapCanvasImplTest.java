package es.duero4.tddinactionjee.swing.plotmap.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.Raster;
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
    
    private PlotMapCanvasImpl canvas;
    
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
    
    @Test
    public void testPlotIsDrawnOnScreen() throws Exception {
        canvas.plot(new Point(2, 2));
        // 1 - Capture raster
        Raster raster = Bitmap.of(canvas);
        // 2 - Assert color of individual pixels from raster
        Pixel.in(raster).at(2, 2).shouldBe(Color.BLACK);
        Pixel.in(raster).around(2, 2).shouldBe(Color.WHITE);
    }
}
