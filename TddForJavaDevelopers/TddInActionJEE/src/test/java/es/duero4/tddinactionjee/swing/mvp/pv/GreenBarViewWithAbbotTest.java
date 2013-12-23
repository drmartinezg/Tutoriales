package es.duero4.tddinactionjee.swing.mvp.pv;

import abbot.finder.matchers.NameMatcher;
import abbot.tester.ComponentTester;
import es.duero4.tddinactionjee.swing.mvp.common.RunButtonListener;
import java.awt.Color;
import java.awt.Component;
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
public class GreenBarViewWithAbbotTest extends ComponentTestFixture {
    
    private GreenBarViewImpl view;
    private int buttonClicks;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    public GreenBarViewWithAbbotTest(String name) {
        super(name);
    }
    
    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        view = new GreenBarViewImpl();
        buttonClicks = 0;
        view.addRunButtonListener(new RunButtonListener() {
            @Override
            public void onRunButtonClick() {
                buttonClicks++;
            }
        });
        // 1 - Ask Abbot to place component in frame
        showFrame(view);
    }
    
    @After
    public void tearDown() {
    }

    public void testViewShouldDisplayTheBarInTheGivenColor() throws Exception {
        Color desiredColor = Color.GREEN;
        view.setBarColor(desiredColor);
        // 2 - Locate components by names
        Component bar = componentNamed("bar");
        assertEquals(desiredColor, bar.getBackground());
        assertEquals(desiredColor, bar.getForeground());
        
    }

    public void testViewShouldDelegateGesturesToListener() throws Exception {
        // 2 - Locate components by names
        Component button = componentNamed("run_button");
        assertEquals(0, buttonClicks);
        // Simulate user gestures with ComponentTester
        new ComponentTester().actionClick(button);
        assertEquals(1, buttonClicks);
    }
    
    private Component componentNamed(String name) throws Exception {
        return getFinder().find(view, new NameMatcher(name));
    }
    
}
