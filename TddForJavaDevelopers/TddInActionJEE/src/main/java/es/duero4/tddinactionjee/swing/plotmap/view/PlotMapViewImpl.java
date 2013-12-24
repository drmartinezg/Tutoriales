package es.duero4.tddinactionjee.swing.plotmap.view;

import es.duero4.tddinactionjee.swing.plotmap.model.PlotMapModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Ramon
 */
public class PlotMapViewImpl extends JPanel implements PlotMapView {

    public PlotMapViewImpl() {
        add(createTextField("x_coord_textfield"));
        add(createTextField("y_coord_textfield"));
        JButton addButton = new JButton();
        addButton.setName("add_button");
        add(addButton);
    }
        
    @Override
    public void registerAddtionListener(PlotAdditionListener listener) {
    }

    @Override
    public void registerRemovalListener(PlotRemovalListener listener) {
    }

    @Override
    public void drawPlotMap(PlotMapModel model) {
    }

    private JTextField createTextField(String name) {
        JTextField field = new JTextField();
        field.setName(name);
        return field;
    }
    
}
