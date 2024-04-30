/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntityPC;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "training")
@NamedQueries({
    @NamedQuery(name = "Training.findAll", query = "SELECT t FROM Training t"),
    @NamedQuery(name = "Training.findByTrainingId", query = "SELECT t FROM Training t WHERE t.trainingId = :trainingId"),
    @NamedQuery(name = "Training.findByStartDate", query = "SELECT t FROM Training t WHERE t.startDate = :startDate"),
    @NamedQuery(name = "Training.findByEndDate", query = "SELECT t FROM Training t WHERE t.endDate = :endDate"),
    @NamedQuery(name = "Training.findByDescription", query = "SELECT t FROM Training t WHERE t.description = :description"),
    @NamedQuery(name = "Training.findByMaterial", query = "SELECT t FROM Training t WHERE t.material = :material")})
public class Training implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Training_Id")
    private Integer trainingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Start_Date")
    private int startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "End_Date")
    private int endDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Description")
    private int description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Material")
    private int material;
    @JoinColumn(name = "Company_Id", referencedColumnName = "User_Id")
    @ManyToOne(optional = false)
    private UserMaster companyId;
    @JoinColumn(name = "Job_Id", referencedColumnName = "Job_Id")
    @ManyToOne(optional = false)
    private Job jobId;
    @JoinColumn(name = "User_Id", referencedColumnName = "User_Id")
    @ManyToOne(optional = false)
    private UserMaster userId;

    public Training() {
    }

    public Training(Integer trainingId) {
        this.trainingId = trainingId;
    }

    public Training(Integer trainingId, int startDate, int endDate, int description, int material) {
        this.trainingId = trainingId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.material = material;
    }

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public int getMaterial() {
        return material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }

    public UserMaster getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UserMaster companyId) {
        this.companyId = companyId;
    }

    public Job getJobId() {
        return jobId;
    }

    public void setJobId(Job jobId) {
        this.jobId = jobId;
    }

    public UserMaster getUserId() {
        return userId;
    }

    public void setUserId(UserMaster userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trainingId != null ? trainingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Training)) {
            return false;
        }
        Training other = (Training) object;
        if ((this.trainingId == null && other.trainingId != null) || (this.trainingId != null && !this.trainingId.equals(other.trainingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPC.Training[ trainingId=" + trainingId + " ]";
    }
    
}
