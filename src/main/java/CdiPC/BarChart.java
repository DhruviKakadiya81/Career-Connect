/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CdiPC;

import ClientPC.Career_Connect_Client;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 * Bar chart data
 */
@Named
@RequestScoped
public class BarChart implements Serializable {

    @Inject
    private Career_Connect_Client client;

    private BarChartModel barModel;

    @PostConstruct
    public void init() {
        createBarModels();
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

  private void createBarModels() {
    barModel = new BarChartModel();

    ChartSeries jobRequests = new ChartSeries();
    jobRequests.setLabel("Job Requests");

    jobRequests.set("Jan", client.countJobRequestsInJanuary(Integer.class));
    jobRequests.set("Feb", client.countJobRequestsInFebruary(Integer.class));
    jobRequests.set("Mar", client.countJobRequestsInMarch(Integer.class));
    jobRequests.set("Apr", client.countJobRequestsInApril(Integer.class));
    jobRequests.set("May", client.countJobRequestsInMay(Integer.class));
    jobRequests.set("June", client.countJobRequestsInJune(Integer.class));
    jobRequests.set("July", client.countJobRequestsInJuly(Integer.class));
    jobRequests.set("Aug", client.countJobRequestsInAugust(Integer.class));
    jobRequests.set("Sept", client.countJobRequestsInSeptember(Integer.class));
    jobRequests.set("Oct", client.countJobRequestsInOctober(Integer.class));
    jobRequests.set("Nov", client.countJobRequestsInNovember(Integer.class));
    jobRequests.set("Dec", client.countJobRequestsInDecember(Integer.class));

    ChartSeries approvedJobs = new ChartSeries();
    approvedJobs.setLabel("Approved Jobs");

    approvedJobs.set("Jan", client.countApprovedJobsInJanuary(Integer.class));
    approvedJobs.set("Feb", client.countApprovedJobsInFebruary(Integer.class));
    approvedJobs.set("Mar", client.countApprovedJobsInMarch(Integer.class));
    approvedJobs.set("Apr", client.countApprovedJobsInApril(Integer.class));
    approvedJobs.set("May", client.countApprovedJobsInMay(Integer.class));
    approvedJobs.set("June", client.countApprovedJobsInJune(Integer.class));
    approvedJobs.set("July", client.countApprovedJobsInJuly(Integer.class));
    approvedJobs.set("Aug", client.countApprovedJobsInAugust(Integer.class));
    approvedJobs.set("Sept", client.countApprovedJobsInSeptember(Integer.class));
    approvedJobs.set("Oct", client.countApprovedJobsInOctober(Integer.class));
    approvedJobs.set("Nov", client.countApprovedJobsInNovember(Integer.class));
    approvedJobs.set("Dec", client.countApprovedJobsInDecember(Integer.class));

    barModel.addSeries(jobRequests);
    barModel.addSeries(approvedJobs);

    barModel.setLegendPosition("ne");
    barModel.setSeriesColors("007bff, ff9800"); // Blue and Orange
}
}