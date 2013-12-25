package es.duero4.tddinactionjee.swing.plotmap.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

/**
 *
 * @author Ramon
 */
public class Bitmap {

    public static Raster of(Component c) throws Exception {
        BufferedImage image = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, c.getWidth(), c.getHeight());
        // 1 - Tell component to paint itself on buffer
        c.paint(graphics);
        graphics.dispose();
        // 2 - Extract raster from buffer
        return image.getRaster();
    }
}
