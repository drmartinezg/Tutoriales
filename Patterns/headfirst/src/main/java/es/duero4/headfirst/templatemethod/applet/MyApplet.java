package es.duero4.headfirst.templatemethod.applet;

import java.applet.Applet;
import java.awt.Graphics;

/**
 *
 * @author ramon
 */
public class MyApplet extends Applet {
    String messsage;
    
    @Override
    public void init() {
        messsage = "Hello World, I'm alive!";
        repaint();
    }
    
    @Override
    public void start() {
        messsage = "Now I'm starting up...";
        repaint();
    }
    
    @Override
    public void stop() {
        messsage = "Oh, now I'm being stopped...";
        repaint();
                
    }
    
    @Override
    public void destroy() {
        messsage = "Goodbye, cruel world";
        repaint();
    }
    
    @Override
    public void paint(Graphics graphics) {
        graphics.drawString(messsage, 5, 15);
    }
}
