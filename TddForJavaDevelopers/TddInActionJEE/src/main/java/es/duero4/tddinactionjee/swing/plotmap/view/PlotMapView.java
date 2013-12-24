package es.duero4.tddinactionjee.swing.plotmap.view;

import es.duero4.tddinactionjee.swing.plotmap.model.PlotMapModel;

/**
 *
 * @author Ramon
 */
public interface PlotMapView {

    void registerAddtionListener(PlotAdditionListener listener);
    
    void registerRemovalListener(PlotRemovalListener listener);
    
    void drawPlotMap(PlotMapModel model);
    
}
