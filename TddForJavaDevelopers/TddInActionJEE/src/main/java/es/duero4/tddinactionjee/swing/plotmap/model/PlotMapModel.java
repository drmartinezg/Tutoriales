package es.duero4.tddinactionjee.swing.plotmap.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramon
 */
public class PlotMapModel {
    
    private List<Point> plots = new ArrayList<Point>();
    
    public void add(Point plot) {
        plots.add(plot);
    }
    
    public void remove(Point plot) {
        plots.remove(plot);
    }
    
    public List<Point> points() {
        return plots;
    }
}
