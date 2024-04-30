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
@Table(name = "qualification")
@NamedQueries({
    @NamedQuery(name = "Qualification.findAll", query = "SELECT q FROM Qualification q"),
    @NamedQuery(name = "Qualification.findByQualificationId", query = "SELECT q FROM Qualification q WHERE q.qualificationId = :qualificationId"),
    @NamedQuery(name = "Qualification.findByQualificationName", query = "SELECT q FROM Qualification q WHERE q.qualificationName = :qualificationName")})
public class Qualification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Qualification_Id")
    private Integer qualificationId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Qualification_Name")
    private String qualificationName;
    @JoinColumn(name = "User_Id", referencedColumnName = "User_Id")
    @ManyToOne(optional = false)
    private UserMaster userId;

    public Qualification() {
    }

    public Qualification(Integer qualificationId) {
        this.qualificationId = qualificationId;
    }

    public Qualification(Integer qualificationId, String qualificationName) {
        this.qualificationId = qualificationId;
        this.qualificationName = qualificationName;
    }

    public Integer getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(Integer qualificationId) {
        this.qualificationId = qualificationId;
    }

    public String getQualificationName() {
        return qualificationName;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
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
        hash += (qualificationId != null ? qualificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Qualification)) {
            return false;
        }
        Qualification other = (Qualification) object;
        if ((this.qualificationId == null && other.qualificationId != null) || (this.qualificationId != null && !this.qualificationId.equals(other.qualificationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPC.Qualification[ qualificationId=" + qualificationId + " ]";
    }
    
}
