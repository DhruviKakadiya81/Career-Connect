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
import javax.validation.constraints.Size;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "resume")
@NamedQueries({
    @NamedQuery(name = "Resume.findAll", query = "SELECT r FROM Resume r"),
    @NamedQuery(name = "Resume.findByResumeId", query = "SELECT r FROM Resume r WHERE r.resumeId = :resumeId"),
    @NamedQuery(name = "Resume.findByPdfName", query = "SELECT r FROM Resume r WHERE r.pdfName = :pdfName")})
public class Resume implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Resume_Id")
    private Integer resumeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Pdf_Name")
    private String pdfName;
    @JoinColumn(name = "User_Id", referencedColumnName = "User_Id")
    @ManyToOne(optional = false)
    private UserMaster userId;

    public Resume() {
    }

    public Resume(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public Resume(Integer resumeId, String pdfName) {
        this.resumeId = resumeId;
        this.pdfName = pdfName;
    }

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public String getPdfName() {
        return pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
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
        hash += (resumeId != null ? resumeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resume)) {
            return false;
        }
        Resume other = (Resume) object;
        if ((this.resumeId == null && other.resumeId != null) || (this.resumeId != null && !this.resumeId.equals(other.resumeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPC.Resume[ resumeId=" + resumeId + " ]";
    }
    
}
