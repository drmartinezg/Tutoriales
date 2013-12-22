package es.duero4.tddinactionjee.swing.mvp.pv;

import es.duero4.tddinactionjee.swing.mvp.common.RunButtonListener;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JComponentOperator;
import org.netbeans.jemmy.operators.JFrameOperator;

/**
 *
 * @author Ramon
 */
public class GreenBarViewWithJemmyTest {

    private int buttonClicks;
    private GreenBarViewImpl view;
    private JFrameOperator frameOp;
    
    public GreenBarViewWithJemmyTest() {
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
        buttonClicks =  0;
        view.addRunButtonListener(new RunButtonListener() {
            @Override
            public void onRunButtonClick() {
                buttonClicks++;
            }
        });
        // 1 - Display component in JFrame
        showFrame(view);
    }
    
    @After
    public void tearDown() {
        // 2 - Dispose of frame afterward
        frameOp.dispose();
    }

    private void showFrame(Component component) {
        // 1 - Display component in JFrame
        JFrame frame = new JFrame();
        frame.getContentPane().add(component);
        frame.pack();
        frame.setVisible(true);
        frameOp = new JFrameOperator(frame);
    }
    
    @Test
    public void viewShouldDisplayTheBarInTheGivenColor() throws Exception {
        Color desiredColor = Color.GREEN;
        view.setBarColor(desiredColor);
        // 3 - Locate components using operators and choosers
        JComponentOperator barOp = new JComponentOperator(frameOp, new NameBasedChooser("bar"));
        assertEquals(desiredColor, barOp.getBackground());
        assertEquals(desiredColor, barOp.getForeground());
    }
    
    @Test
    public void viewShouldDelegateGesturesToListener() throws Exception {
        // 3 - Locate components using operators and choosers
        JButtonOperator buttonOp = new JButtonOperator(frameOp, new NameBasedChooser("run_button"));
        assertEquals(0, this.buttonClicks);
        // Simulate user gestures with operators
        buttonOp.doClick();
        assertEquals(1, this.buttonClicks);
    }
}
