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
@Table(name = "job_request")
@NamedQueries({
    @NamedQuery(name = "JobRequest.findAll", query = "SELECT j FROM JobRequest j"),
    @NamedQuery(name = "JobRequest.findByJobRequestId", query = "SELECT j FROM JobRequest j WHERE j.jobRequestId = :jobRequestId"),
    @NamedQuery(name = "JobRequest.findByMessage", query = "SELECT j FROM JobRequest j WHERE j.message = :message"),
    @NamedQuery(name = "JobRequest.findByStatus", query = "SELECT j FROM JobRequest j WHERE j.status = :status"),
    @NamedQuery(name = "JobRequest.findByRequestedDate", query = "SELECT j FROM JobRequest j WHERE j.requestedDate = :requestedDate")})
public class JobRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Job_Request_Id")
    private Integer jobRequestId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Message")
    private String message;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Requested_Date")
    @Temporal(TemporalType.DATE)
    private Date requestedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobRequestId")
    private Collection<ApprovedJob> approvedJobCollection;
    @JoinColumn(name = "Company_Id", referencedColumnName = "User_Id")
    @ManyToOne(optional = false)
    private UserMaster companyId;
    @JoinColumn(name = "Job_Id", referencedColumnName = "Job_Id")
    @ManyToOne(optional = false)
    private Job jobId;
    @JoinColumn(name = "User_Id", referencedColumnName = "User_Id")
    @ManyToOne(optional = false)
    private UserMaster userId;

    public JobRequest() {
    }

    public JobRequest(Integer jobRequestId) {
        this.jobRequestId = jobRequestId;
    }

    public JobRequest(Integer jobRequestId, String message, String status, Date requestedDate) {
        this.jobRequestId = jobRequestId;
        this.message = message;
        this.status = status;
        this.requestedDate = requestedDate;
    }

    public Integer getJobRequestId() {
        return jobRequestId;
    }

    public void setJobRequestId(Integer jobRequestId) {
        this.jobRequestId = jobRequestId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    @JsonbTransient
    public Collection<ApprovedJob> getApprovedJobCollection() {
        return approvedJobCollection;
    }
    
    
    @JsonbTransient
    public void setApprovedJobCollection(Collection<ApprovedJob> approvedJobCollection) {
        this.approvedJobCollection = approvedJobCollection;
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
        hash += (jobRequestId != null ? jobRequestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobRequest)) {
            return false;
        }
        JobRequest other = (JobRequest) object;
        if ((this.jobRequestId == null && other.jobRequestId != null) || (this.jobRequestId != null && !this.jobRequestId.equals(other.jobRequestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPC.JobRequest[ jobRequestId=" + jobRequestId + " ]";
    }
    
}
