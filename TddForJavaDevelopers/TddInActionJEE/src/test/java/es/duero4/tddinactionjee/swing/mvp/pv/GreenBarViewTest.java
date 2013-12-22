package es.duero4.tddinactionjee.swing.mvp.pv;

import es.duero4.tddinactionjee.swing.mvp.common.GreenBarView;
import es.duero4.tddinactionjee.swing.mvp.common.RunButtonListener;
import java.awt.Color;
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
public class GreenBarViewTest {
    
    private GreenBarView view;
    // 1 - Check for received events
    private boolean listenerReceivedClick;
    
    public GreenBarViewTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        view = new GreenBarViewImpl();
        view.addRunButtonListener(new RunButtonListener() {
            @Override
            public void onRunButtonClick() {
                // 1 - Check for received events
                listenerReceivedClick = true;
            }
        });
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void viewShouldDisplayTheBarInTheGivenColor() throws Exception {
        // 2 - Simulate the presenter
        view.setBarColor(Color.GREEN);
        // How to verify that the bar really is green?
    }
    
    @Test
    public void viewShouldDelegateGesturesToListener() throws Exception {
        // How to simulate a click on the "Run" button?
        // How to know whether the button is there at all?
        
        // 1 - Check for received events
       // assertTrue(listenerReceivedClick);
    }
}
