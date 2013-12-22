package es.duero4.tddinactionjee.swing.mvp.pv;

import es.duero4.tddinactionjee.swing.mvp.common.GreenBarModel;
import es.duero4.tddinactionjee.swing.mvp.common.GreenBarView;
import es.duero4.tddinactionjee.swing.mvp.common.RunButtonListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Ramon
 */
public class GreenBarViewImpl extends JPanel implements GreenBarPassiveView {

    private RunButtonListener listener;
    private JPanel bar;
    
    public GreenBarViewImpl() {
        add(createRunButton());
        add(createBar());
    }

    @Override
    public void addRunButtonListener(RunButtonListener listener) {
        this.listener = listener;
    }

    @Override
    public void setBarColor(Color color) {
        bar.setBackground(color);
        bar.setForeground(color);
    }

    private Component createRunButton() {
        JButton button = new JButton("Run");
        button.setName("run_button");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onRunButtonClick();
            }
        });
        return button;
    }

    private Component createBar() {
        bar = new JPanel();
        bar.setName("bar");
        bar.add(Box.createRigidArea(new Dimension(200, 20)));
        return bar;
    }
    
}
