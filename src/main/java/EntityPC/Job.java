/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntityPC;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "job")
@NamedQueries({
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j"),
    @NamedQuery(name = "Job.findByJobId", query = "SELECT j FROM Job j WHERE j.jobId = :jobId"),
    @NamedQuery(name = "Job.findByJobTitle", query = "SELECT j FROM Job j WHERE j.jobTitle = :jobTitle"),
    @NamedQuery(name = "Job.findByDescription", query = "SELECT j FROM Job j WHERE j.description = :description"),
    @NamedQuery(name = "Job.findByTechnology", query = "SELECT j FROM Job j WHERE j.technology = :technology"),
    @NamedQuery(name = "Job.findByQualification", query = "SELECT j FROM Job j WHERE j.qualification = :qualification"),
    @NamedQuery(name = "Job.findByExperience", query = "SELECT j FROM Job j WHERE j.experience = :experience"),
    @NamedQuery(name = "Job.findBySalary", query = "SELECT j FROM Job j WHERE j.salary = :salary"),
    @NamedQuery(name = "Job.findByStatus", query = "SELECT j FROM Job j WHERE j.status = :status"),
    @NamedQuery(name = "Job.findByJobType", query = "SELECT j FROM Job j WHERE j.jobType = :jobType"),
    @NamedQuery(name = "Job.findByPostedDate", query = "SELECT j FROM Job j WHERE j.postedDate = :postedDate"),
    @NamedQuery(name = "Job.findByExpirationDate", query = "SELECT j FROM Job j WHERE j.expirationDate = :expirationDate")})
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Job_Id")
    private Integer jobId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Job_Title")
    private String jobTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Technology")
    private String technology;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Qualification")
    private String qualification;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Experience")
    private String experience;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Salary")
    private int salary;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Job_Type")
    private String jobType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Posted_Date")
    @Temporal(TemporalType.DATE)
    private Date postedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Expiration_Date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobId")
    private Collection<ApprovedJob> approvedJobCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobId")
    private Collection<JobRequest> jobRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobId")
    private Collection<Training> trainingCollection;
    @JoinColumn(name = "Company_Id", referencedColumnName = "User_Id")
    @ManyToOne(optional = false)
    private UserMaster companyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobId")
    private Collection<Interview> interviewCollection;

    public Job() {
    }

    public Job(Integer jobId) {
        this.jobId = jobId;
    }

    public Job(Integer jobId, String jobTitle, String description, String technology, String qualification, String experience, int salary, String status, String jobType, Date postedDate, Date expirationDate) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.description = description;
        this.technology = technology;
        this.qualification = qualification;
        this.experience = experience;
        this.salary = salary;
        this.status = status;
        this.jobType = jobType;
        this.postedDate = postedDate;
        this.expirationDate = expirationDate;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @JsonbTransient
    public Collection<ApprovedJob> getApprovedJobCollection() {
        return approvedJobCollection;
    }

    @JsonbTransient
    public void setApprovedJobCollection(Collection<ApprovedJob> approvedJobCollection) {
        this.approvedJobCollection = approvedJobCollection;
    }

    @JsonbTransient
    public Collection<JobRequest> getJobRequestCollection() {
        return jobRequestCollection;
    }

    @JsonbTransient
    public void setJobRequestCollection(Collection<JobRequest> jobRequestCollection) {
        this.jobRequestCollection = jobRequestCollection;
    }

    @JsonbTransient
    public Collection<Training> getTrainingCollection() {
        return trainingCollection;
    }

    @JsonbTransient
    public void setTrainingCollection(Collection<Training> trainingCollection) {
        this.trainingCollection = trainingCollection;
    }

    public UserMaster getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UserMaster companyId) {
        this.companyId = companyId;
    }

    @JsonbTransient
    public Collection<Interview> getInterviewCollection() {
        return interviewCollection;
    }

    @JsonbTransient
    public void setInterviewCollection(Collection<Interview> interviewCollection) {
        this.interviewCollection = interviewCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobId != null ? jobId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.jobId == null && other.jobId != null) || (this.jobId != null && !this.jobId.equals(other.jobId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPC.Job[ jobId=" + jobId + " ]";
    }
    
}
