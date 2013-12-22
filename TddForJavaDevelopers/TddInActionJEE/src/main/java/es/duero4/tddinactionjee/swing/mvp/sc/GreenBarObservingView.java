package es.duero4.tddinactionjee.swing.mvp.sc;

import es.duero4.tddinactionjee.swing.mvp.common.GreenBarModel;
import es.duero4.tddinactionjee.swing.mvp.common.GreenBarView;

/**
 *
 * @author Ramon
 */
public interface GreenBarObservingView extends GreenBarView {

    public void update(GreenBarModel model);

}
