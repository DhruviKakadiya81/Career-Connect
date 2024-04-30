/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntityPC;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "approved_job")
@NamedQueries({
    @NamedQuery(name = "ApprovedJob.findAll", query = "SELECT a FROM ApprovedJob a"),
    @NamedQuery(name = "ApprovedJob.findByApprovedJobId", query = "SELECT a FROM ApprovedJob a WHERE a.approvedJobId = :approvedJobId"),
    @NamedQuery(name = "ApprovedJob.findByApprovedDate", query = "SELECT a FROM ApprovedJob a WHERE a.approvedDate = :approvedDate"),
    @NamedQuery(name = "ApprovedJob.findByApprovalNote", query = "SELECT a FROM ApprovedJob a WHERE a.approvalNote = :approvalNote"),
    @NamedQuery(name = "ApprovedJob.findByStatus", query = "SELECT a FROM ApprovedJob a WHERE a.status = :status"),
    @NamedQuery(name = "ApprovedJob.findBySalary", query = "SELECT a FROM ApprovedJob a WHERE a.salary = :salary")})
public class ApprovedJob implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Approved_Job_Id")
    private Integer approvedJobId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Approved_Date")
    @Temporal(TemporalType.DATE)
    private Date approvedDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Approval_Note")
    private String approvalNote;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Salary")
    private int salary;
    @JoinColumn(name = "Company_Id", referencedColumnName = "User_Id")
    @ManyToOne(optional = false)
    private UserMaster companyId;
    @JoinColumn(name = "Job_Id", referencedColumnName = "Job_Id")
    @ManyToOne(optional = false)
    private Job jobId;
    @JoinColumn(name = "Job_Request_Id", referencedColumnName = "Job_Request_Id")
    @ManyToOne(optional = false)
    private JobRequest jobRequestId;
    @JoinColumn(name = "User_Id", referencedColumnName = "User_Id")
    @ManyToOne(optional = false)
    private UserMaster userId;

    public ApprovedJob() {
    }

    public ApprovedJob(Integer approvedJobId) {
        this.approvedJobId = approvedJobId;
    }

    public ApprovedJob(Integer approvedJobId, Date approvedDate, String approvalNote, String status, int salary) {
        this.approvedJobId = approvedJobId;
        this.approvedDate = approvedDate;
        this.approvalNote = approvalNote;
        this.status = status;
        this.salary = salary;
    }

    public Integer getApprovedJobId() {
        return approvedJobId;
    }

    public void setApprovedJobId(Integer approvedJobId) {
        this.approvedJobId = approvedJobId;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getApprovalNote() {
        return approvalNote;
    }

    public void setApprovalNote(String approvalNote) {
        this.approvalNote = approvalNote;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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

    public JobRequest getJobRequestId() {
        return jobRequestId;
    }

    public void setJobRequestId(JobRequest jobRequestId) {
        this.jobRequestId = jobRequestId;
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
        hash += (approvedJobId != null ? approvedJobId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApprovedJob)) {
            return false;
        }
        ApprovedJob other = (ApprovedJob) object;
        if ((this.approvedJobId == null && other.approvedJobId != null) || (this.approvedJobId != null && !this.approvedJobId.equals(other.approvedJobId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPC.ApprovedJob[ approvedJobId=" + approvedJobId + " ]";
    }
    
}
