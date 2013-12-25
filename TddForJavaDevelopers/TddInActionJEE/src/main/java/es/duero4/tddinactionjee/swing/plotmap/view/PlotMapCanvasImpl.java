package es.duero4.tddinactionjee.swing.plotmap.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramon
 */
public class PlotMapCanvasImpl extends Canvas implements PlotMapCanvas {

    private List<Point> plots = new ArrayList<Point>();

    public PlotMapCanvasImpl() {
        setSize(200, 100);
        setBackground(Color.WHITE);
    }

    @Override
    public void plot(Point point) {
        plots.add(point);
    }

    @Override
    public void paint(Graphics g) {
        // 1 - Use black color for drawing
        g.setColor(Color.BLACK);
        for (Point p : plots) {
            // 2 - Paint pixel at each point
            g.drawLine(p.x, p.y, p.x, p.y);
        }
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
