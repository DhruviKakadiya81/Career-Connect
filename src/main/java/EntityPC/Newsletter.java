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
@Table(name = "newsletter")
@NamedQueries({
    @NamedQuery(name = "Newsletter.findAll", query = "SELECT n FROM Newsletter n"),
    @NamedQuery(name = "Newsletter.findByNewsLetterId", query = "SELECT n FROM Newsletter n WHERE n.newsLetterId = :newsLetterId"),
    @NamedQuery(name = "Newsletter.findByNewsEmail", query = "SELECT n FROM Newsletter n WHERE n.newsEmail = :newsEmail")})
public class Newsletter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "news_letter_id")
    private Integer newsLetterId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "news_email")
    private String newsEmail;

    public Newsletter() {
    }

    public Newsletter(Integer newsLetterId) {
        this.newsLetterId = newsLetterId;
    }

    public Newsletter(Integer newsLetterId, String newsEmail) {
        this.newsLetterId = newsLetterId;
        this.newsEmail = newsEmail;
    }

    public Integer getNewsLetterId() {
        return newsLetterId;
    }

    public void setNewsLetterId(Integer newsLetterId) {
        this.newsLetterId = newsLetterId;
    }

    public String getNewsEmail() {
        return newsEmail;
    }

    public void setNewsEmail(String newsEmail) {
        this.newsEmail = newsEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsLetterId != null ? newsLetterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Newsletter)) {
            return false;
        }
        Newsletter other = (Newsletter) object;
        if ((this.newsLetterId == null && other.newsLetterId != null) || (this.newsLetterId != null && !this.newsLetterId.equals(other.newsLetterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPC.Newsletter[ newsLetterId=" + newsLetterId + " ]";
    }
    
}
