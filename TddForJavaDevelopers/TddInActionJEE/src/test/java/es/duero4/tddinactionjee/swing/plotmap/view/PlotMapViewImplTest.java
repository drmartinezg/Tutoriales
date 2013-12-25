package es.duero4.tddinactionjee.swing.plotmap.view;

import abbot.finder.matchers.NameMatcher;
import abbot.tester.ComponentTester;
import es.duero4.tddinactionjee.swing.plotmap.model.PlotMapModel;
import java.awt.Component;
import java.awt.Point;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JTextField;
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
    private PlotMapViewImpl view;
    private PlotMapCanvasStub canvas;
    
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
        // 1 - Use test double for canvas
        canvas = new PlotMapCanvasStub();
        // 2 - View create its canvas with this method
        view = new PlotMapViewImpl() {
            @Override
            protected PlotMapCanvas createCanvas() {
                return canvas;
            }
        };
        view.registerAdditionListener(this);
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

    @Test
    public void testViewPassesModelToSeparateCanvasObjectForDrawing() throws Exception {
        Point p1 = new Point(1, 3);
        Point p2 = new Point(2, 1);
        Point p3 = new Point(5, 4);
        PlotMapModel model = new PlotMapModel();
        model.add(p1);
        model.add(p2);
        model.add(p3);
        view.drawPlotMap(model);
        assertEquals(Arrays.asList(p1, p2, p3), canvas.plottedPoints);
    }
    
    private void typeIntoTextField(String name, String value) throws Exception {
        tester.actionKeyString(namedComponent(name), value);
    }

    private Component namedComponent(String name) throws Exception {
        return getFinder().find(new NameMatcher(name));
    }
}
