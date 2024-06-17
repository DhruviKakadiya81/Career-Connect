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
@Table(name = "interview")
@NamedQueries({
    @NamedQuery(name = "Interview.findAll", query = "SELECT i FROM Interview i"),
    @NamedQuery(name = "Interview.findByInterviewId", query = "SELECT i FROM Interview i WHERE i.interviewId = :interviewId"),
    @NamedQuery(name = "Interview.findByMode", query = "SELECT i FROM Interview i WHERE i.mode = :mode"),
    @NamedQuery(name = "Interview.findByInterviewDate", query = "SELECT i FROM Interview i WHERE i.interviewDate = :interviewDate"),
    @NamedQuery(name = "Interview.findByInterviewTime", query = "SELECT i FROM Interview i WHERE i.interviewTime = :interviewTime"),
    @NamedQuery(name = "Interview.findByInterviewDescription", query = "SELECT i FROM Interview i WHERE i.interviewDescription = :interviewDescription")})
public class Interview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Interview_Id")
    private Integer interviewId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Mode")
    private String mode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Interview_Date")
    @Temporal(TemporalType.DATE)
    private Date interviewDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Interview_Time")
    @Temporal(TemporalType.TIME)
    private Date interviewTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 800)
    @Column(name = "Interview_Description")
    private String interviewDescription;
    @JoinColumn(name = "Company_Id", referencedColumnName = "User_Id")
    @ManyToOne(optional = false)
    private UserMaster companyId;
    @JoinColumn(name = "Job_Id", referencedColumnName = "Job_Id")
    @ManyToOne(optional = false)
    private Job jobId;
    @JoinColumn(name = "User_Id", referencedColumnName = "User_Id")
    @ManyToOne(optional = false)
    private UserMaster userId;

    public Interview() {
    }

    public Interview(Integer interviewId) {
        this.interviewId = interviewId;
    }

    public Interview(Integer interviewId, String mode, Date interviewDate, Date interviewTime, String interviewDescription) {
        this.interviewId = interviewId;
        this.mode = mode;
        this.interviewDate = interviewDate;
        this.interviewTime = interviewTime;
        this.interviewDescription = interviewDescription;
    }

    public Integer getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(Integer interviewId) {
        this.interviewId = interviewId;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public Date getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(Date interviewTime) {
        this.interviewTime = interviewTime;
    }

    public String getInterviewDescription() {
        return interviewDescription;
    }

    public void setInterviewDescription(String interviewDescription) {
        this.interviewDescription = interviewDescription;
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
        hash += (interviewId != null ? interviewId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interview)) {
            return false;
        }
        Interview other = (Interview) object;
        if ((this.interviewId == null && other.interviewId != null) || (this.interviewId != null && !this.interviewId.equals(other.interviewId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPC.Interview[ interviewId=" + interviewId + " ]";
    }
    
}
