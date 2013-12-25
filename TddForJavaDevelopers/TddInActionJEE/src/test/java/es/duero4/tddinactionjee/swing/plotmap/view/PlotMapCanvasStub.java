package es.duero4.tddinactionjee.swing.plotmap.view;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramon
 */
public class PlotMapCanvasStub implements PlotMapCanvas {
    
    public List<Point> plottedPoints = new ArrayList<Point>();

    public PlotMapCanvasStub() {
    }

    @Override
    public void plot(Point point) {
        plottedPoints.add(point);
    }

    @Override
    public void clear() {
        plottedPoints.clear();
    }

    @Override
    public void addRemoveListener(PointEventListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
