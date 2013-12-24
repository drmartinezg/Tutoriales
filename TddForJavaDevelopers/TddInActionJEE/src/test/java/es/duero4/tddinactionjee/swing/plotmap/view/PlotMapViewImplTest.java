package es.duero4.tddinactionjee.swing.plotmap.view;

import abbot.finder.matchers.NameMatcher;
import abbot.tester.ComponentTester;
import java.awt.Component;
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
    private ComponentTester tester;
    
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
        tester = new ComponentTester();
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
    
    @Test
    public void testAdditionEventGetsTriggered() throws Exception {
        Point point = new Point(3, 5);
        typeIntoTextField("x_coord_textfield", "" + point.x);
        typeIntoTextField("y_coord_textfield", "" + point.y);
        tester.actionClick(namedComponent("add_button"));
        assertEquals(point, addedPoint);
    }

    private void typeIntoTextField(String name, String value) throws Exception {
        tester.actionKeyString(namedComponent(name), value);
    }

    private Component namedComponent(String name) throws Exception {
        return getFinder().find(new NameMatcher(name));
    }
}
