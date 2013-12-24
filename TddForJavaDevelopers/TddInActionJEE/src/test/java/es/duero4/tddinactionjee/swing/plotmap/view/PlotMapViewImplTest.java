package es.duero4.tddinactionjee.swing.plotmap.view;

import java.awt.Point;
import junit.extensions.abbot.ComponentTestFixture;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Ramon
 * 
 * Test class acts as a listener
 */
public class PlotMapViewImplTest extends ComponentTestFixture implements PlotAdditionListener {

    private Point addedPoint;
    
    public PlotMapViewImplTest(String name) {
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
        addedPoint = null;
        PlotMapViewImpl view = new PlotMapViewImpl();
        view.registerAddtionListener(this);
        showFrame(view);
    }
    
    @After
    public void tearDown() {
    }

    @Override
    public void plotWasAdded(Point plot) {
        // Keep added point for test to assert
        addedPoint = plot;
    }
}
