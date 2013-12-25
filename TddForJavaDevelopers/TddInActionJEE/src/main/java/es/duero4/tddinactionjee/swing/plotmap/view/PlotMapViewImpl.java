package es.duero4.tddinactionjee.swing.plotmap.view;

import es.duero4.tddinactionjee.swing.plotmap.model.PlotMapModel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Ramon
 */
public class PlotMapViewImpl extends JPanel implements PlotMapView {

    // View has listener for addition events
    private PlotAdditionListener additionListener;
    private JTextField xCoordField, yCoordField;
    private JButton addButton;
    private PlotMapCanvas canvas;

    public PlotMapViewImpl() {
        createWidgets();
        add(xCoordField);
        add(yCoordField);
        add(addButton);
    }

    private void createWidgets() {
        xCoordField = createTextField("x_coord_textfield");
        yCoordField = createTextField("y_coord_textfield");
        addButton = new JButton();
        addButton.setName("add_button");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = valueAsInt(xCoordField);
                int y = valueAsInt(yCoordField);
                // Button triggers events to registered listener
                additionListener.plotWasAdded(new Point(x, y));
            }

        });
        canvas = createCanvas();
    }

    @Override
    public void registerAdditionListener(PlotAdditionListener listener) {
        // Register listener for addition events
        this.additionListener = listener;
    }

    @Override
    public void registerRemovalListener(PlotRemovalListener listener) {
    }

    @Override
    public void drawPlotMap(PlotMapModel model) {
        canvas.clear();
        for (Point point : model.points()) {
            canvas.plot(point);
        }
    }

    // Needed to make code compile
    protected PlotMapCanvas createCanvas() {
        return null;
    }
    
    private JTextField createTextField(String name) {
        JTextField field = new JTextField();
        field.setName(name);
        return field;
    }

    private int valueAsInt(JTextField field) {
        return Integer.parseInt(field.getText());
    }
    
}
