package es.duero4.tddinactionjee.swing.plotmap.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        g.setColor(Color.BLACK);
        Point previous = null;
        for (Point current : plots) {
            // 1 - First point doesn't have previous
            if (previous == null) {
                previous = current;
            }
            // 2 - Draw line from previous to current
            g.drawLine(previous.x, previous.y, current.x, current.y);
            // 3 - Prepare for next loop iteration
            previous = current;
        }
    }
    
    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addRemoveListener(final PointEventListener listener) {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listener.onPointEvent(e.getPoint());
            }
        });
    }

    void setRemoveListener(final PointEventListener listener) {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point point = e.getPoint();
                // Interested only in plotted points
                if (plots.contains(point)) {
                    listener.onPointEvent(point);
                }
            }
        });
    }
    
}
