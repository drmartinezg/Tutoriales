package es.duero4.tddinactionjee.swing.plotmap.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Ramon
 */
public class PlotMapCanvasImpl extends Canvas implements PlotMapCanvas {

    public PlotMapCanvasImpl() {
        setSize(200, 100);
        setBackground(Color.WHITE);
    }

    @Override
    public void plot(Point point) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addRemoveListener(PointEventListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
