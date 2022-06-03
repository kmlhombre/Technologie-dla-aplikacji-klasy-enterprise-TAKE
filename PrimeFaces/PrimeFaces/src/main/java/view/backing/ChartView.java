/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author student
 */
@Named(value="chartView")
@RequestScoped
public class ChartView {
    private LineChartModel lineModel;
    
    ChartView() {
        lineModel = new LineChartModel();
        LineChartSeries s = new LineChartSeries();
        s.setLabel("Sinus");
        
        for(double x = 0; x < 360.0; x++) {
            double radians = Math.toRadians(x);
            s.set(radians, Math.sin(radians));
        }
        
        lineModel.addSeries(s);
        lineModel.setLegendPosition("e");
        Axis y = lineModel.getAxis(AxisType.Y);
        y.setMin(-1.25);
        y.setMax(1.25);
        y.setLabel("Sinus");
        
        Axis x = lineModel.getAxis(AxisType.X);
        x.setMin(0);
        x.setMax(6.3);
        x.setLabel("Kąt");
    }
    
    public LineChartModel getLineModel() {
        return lineModel;
    }
}