package es.duero4.tddinactionjee.swing.mvp.pv;

import es.duero4.tddinactionjee.swing.mvp.common.GreenBarView;
import java.awt.Color;

/**
 *
 * @author Ramon
 */
public interface GreenBarPassiveView extends GreenBarView {
    
    @Override
    public void setBarColor(Color color);
}
