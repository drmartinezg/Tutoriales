package es.duero4.tddinactionjee.swing.mvp.sc;

import es.duero4.tddinactionjee.swing.mvp.common.GreenBarModel;
import es.duero4.tddinactionjee.swing.mvp.common.RunButtonListener;
import es.duero4.tddinactionjee.swing.mvp.common.GreenBarView;

/**
 *
 * @author Ramon
 */
public class GreenBarSupervisingController {

    private final GreenBarModel model;
    private final GreenBarView view;

    public GreenBarSupervisingController(final GreenBarView view, final GreenBarModel model) {
        this.view = view;
        this.model = model;
        // 1 - Register for user gestures.
        view.addRunButtonListener(new RunButtonListener() {
            @Override
            public void onRunButtonClick() {
                // 2 - Operate on model objects.
                model.runTests();
                // 3 - Tell view to update itself.
                updateView();
            }

            private void updateView() {
                view.update(model);
            }
        });
    }
}
