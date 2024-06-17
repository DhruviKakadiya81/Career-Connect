/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CdiPC;

import ClientPC.Career_Connect_Client;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author HP
 */
@ManagedBean
public class LineChart implements Serializable {

    @Inject
    private Career_Connect_Client client;
    private LineChartModel drawArea;

    @PostConstruct
    public void init() {
        createDrawArea();
    }

    public LineChartModel getDrawArea() {
        return drawArea;
    }

    private void createDrawArea() {
        
        long may = client.countJobRequestsInMay(Integer.class);
        long jan = client.countJobRequestsInJanuary(Integer.class);
        long feb = client.countJobRequestsInFebruary(Integer.class);
        long march = client.countJobRequestsInMarch(Integer.class);
        long april = client.countJobRequestsInApril(Integer.class);
        long dec = client.countJobRequestsInDecember(Integer.class);
        long june = client.countJobRequestsInJune(Integer.class);
        long july = client.countJobRequestsInJuly(Integer.class);
        long aug = client.countJobRequestsInAugust(Integer.class);
        long sep = client.countJobRequestsInSeptember(Integer.class);
        long oct = client.countJobRequestsInOctober(Integer.class);
        long nov = client.countJobRequestsInNovember(Integer.class);

        

        drawArea = new LineChartModel();
        // Adjust the width as needed

        LineChartSeries Job_Resuest = new LineChartSeries();
        Job_Resuest.setFill(true);
        Job_Resuest.setLabel("Job Resuest");
        Job_Resuest.set("Jan", jan);
        Job_Resuest.set("Feb", feb);
        Job_Resuest.set("Mar", march);
        Job_Resuest.set("Apr", april);
        Job_Resuest.set("May", may);
        Job_Resuest.set("June", june);
        Job_Resuest.set("July", july);
        Job_Resuest.set("Aug", aug);
        Job_Resuest.set("Sept", sep);
        Job_Resuest.set("Oct", oct);
        Job_Resuest.set("Nov", nov);
        Job_Resuest.set("Dec", dec);

        drawArea.addSeries(Job_Resuest);
//drawArea.addSeries(girls);  
        
        drawArea.setLegendPosition("ne");
        drawArea.setStacked(true);
        drawArea.setShowPointLabels(true);
        Axis xAxis = new CategoryAxis("Months");
        drawArea.getAxes().put(AxisType.X, xAxis);
        Axis yAxis = drawArea.getAxis(AxisType.Y);
        yAxis.setLabel("No Of JobRequest");
        yAxis.setMin(0);
        yAxis.setMax(30);
    }

    public LineChart() {
    }

}