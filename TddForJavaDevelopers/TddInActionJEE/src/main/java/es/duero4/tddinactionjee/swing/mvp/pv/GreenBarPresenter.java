package es.duero4.tddinactionjee.swing.mvp.pv;

import es.duero4.tddinactionjee.swing.mvp.common.Colors;
import es.duero4.tddinactionjee.swing.mvp.common.GreenBarModel;
import es.duero4.tddinactionjee.swing.mvp.common.GreenBarView;
import es.duero4.tddinactionjee.swing.mvp.common.RunButtonListener;
import java.awt.Color;

/**
 *
 * @author Ramon
 */
public class GreenBarPresenter {

    private final GreenBarModel model;
    private final GreenBarView view;

    public GreenBarPresenter(final GreenBarModel model, final GreenBarView view) {
        this.model = model;
        this.view = view;
        // 1- Register for gestures
        view.addRunButtonListener(new RunButtonListener() {
            @Override
            public void onRunButtonClick() {
                // 2 - Operate model
                model.runTests();
                // 3 - Update view
                updateView();
            }
        });
        updateView();
    }
    
    private void updateView() {
        // 4 - View logic is in presenter
        Color newColor = ( model.numberOfFailures() == 0 
                         ? Colors.testsPassed() 
                         : Colors.testsFailed());
        view.setBarColor(newColor);
    }
    
}
