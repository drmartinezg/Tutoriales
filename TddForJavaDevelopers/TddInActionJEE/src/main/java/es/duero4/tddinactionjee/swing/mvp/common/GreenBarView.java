package es.duero4.tddinactionjee.swing.mvp.common;

import java.awt.Color;

/**
 *
 * @author Ramon
 */
public interface GreenBarView {

    public void addRunButtonListener(RunButtonListener listener);

    public void update(GreenBarModel model);

    public void setBarColor(Color newColor);
    
}
