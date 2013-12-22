package es.duero4.tddinactionjee.swing.mvp.common;

/**
 *
 * @author Ramon
 */
public interface GreenBarView {

    public void addRunButtonListener(RunButtonListener listener);

    public void update(GreenBarModel model);
    
}
