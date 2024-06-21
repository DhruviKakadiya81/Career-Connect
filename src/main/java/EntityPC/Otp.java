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
@Table(name = "otp")
@NamedQueries({
    @NamedQuery(name = "Otp.findAll", query = "SELECT o FROM Otp o"),
    @NamedQuery(name = "Otp.findById", query = "SELECT o FROM Otp o WHERE o.id = :id"),
    @NamedQuery(name = "Otp.findByEmail", query = "SELECT o FROM Otp o WHERE o.email = :email"),
    @NamedQuery(name = "Otp.findByOtp", query = "SELECT o FROM Otp o WHERE o.otp = :otp"),
    @NamedQuery(name = "Otp.findByExpiryDate", query = "SELECT o FROM Otp o WHERE o.expiryDate = :expiryDate")})
public class Otp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "otp")
    private String otp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expiryDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;

    public Otp() {
    }

    public Otp(Integer id) {
        this.id = id;
    }

    public Otp(Integer id, String email, String otp, Date expiryDate) {
        this.id = id;
        this.email = email;
        this.otp = otp;
        this.expiryDate = expiryDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Otp)) {
            return false;
        }
        Otp other = (Otp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPC.Otp[ id=" + id + " ]";
    }
    
}
