/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CdiPC;

//import javax.inject.Named;
import ClientPC.Career_Connect_Client;
import javax.enterprise.context.RequestScoped;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author HP
 */
@Named
@RequestScoped
public class PieChart implements Serializable {

    @Inject
    private Career_Connect_Client client;

     public PieChart() {
      
    }
    
    private PieChartModel pieModel;

    @PostConstruct
    public void init() {
        createPieModels();
    }

    /**
     *
     * @return
     */
    public PieChartModel getPieModel() {
        return pieModel;
    }

    private void createPieModels() {
        createPieModel();
    }

    private void createPieModel() {
        pieModel = new PieChartModel();
        
         int totalUsers = client.getUserCount(Integer.class);
        int totalCompanies = client.getCompanyCount(Integer.class);
       pieModel.set("Total Users", totalUsers);
        pieModel.set("Total Companies", totalCompanies);
//        pieModel.setTitle("User and Company Counts");
        pieModel.setLegendPosition("c");
         pieModel.setSeriesColors("FF9900, 007bff"); // Orange and Blue
         
    }

}