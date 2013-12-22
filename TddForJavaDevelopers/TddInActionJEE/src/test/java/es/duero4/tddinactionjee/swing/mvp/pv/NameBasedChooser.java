package es.duero4.tddinactionjee.swing.mvp.pv;

import java.awt.Component;
import org.netbeans.jemmy.ComponentChooser;

/**
 *
 * @author Ramon
 */
public class NameBasedChooser implements ComponentChooser {

    private final String name;
    
    public NameBasedChooser(String name) {
        this.name = name;
    }

    @Override
    public boolean checkComponent(Component component) {
        // Identify desired component by name
        return name.equals(component.getName());
    }

    @Override
    public String getDescription() {
        return "Component name '" + name + "'";
    }
    
}
