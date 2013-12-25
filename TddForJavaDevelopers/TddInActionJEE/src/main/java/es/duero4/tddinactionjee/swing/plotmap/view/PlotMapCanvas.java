package es.duero4.tddinactionjee.swing.plotmap.view;

import java.awt.Point;

/**
 *
 * @author Ramon
 */
public interface PlotMapCanvas {
    
    void plot(Point point);
    
    void clear();
    
    void addRemoveListener(PointEventListener listener);
}
