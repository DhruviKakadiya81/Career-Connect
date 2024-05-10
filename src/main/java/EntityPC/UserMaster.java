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
@Table(name = "user_master")
@NamedQueries({
    @NamedQuery(name = "UserMaster.findAll", query = "SELECT u FROM UserMaster u"),
    @NamedQuery(name = "UserMaster.findByUserId", query = "SELECT u FROM UserMaster u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserMaster.findByFName", query = "SELECT u FROM UserMaster u WHERE u.fName = :fName"),
    @NamedQuery(name = "UserMaster.findByLName", query = "SELECT u FROM UserMaster u WHERE u.lName = :lName"),
    @NamedQuery(name = "UserMaster.findByEmail", query = "SELECT u FROM UserMaster u WHERE u.email = :email"),
    @NamedQuery(name = "UserMaster.findByMobileNo", query = "SELECT u FROM UserMaster u WHERE u.mobileNo = :mobileNo"),
    @NamedQuery(name = "UserMaster.findByProfileImage", query = "SELECT u FROM UserMaster u WHERE u.profileImage = :profileImage"),
    @NamedQuery(name = "UserMaster.findByBirthDate", query = "SELECT u FROM UserMaster u WHERE u.birthDate = :birthDate"),
    @NamedQuery(name = "UserMaster.findByAddressLine", query = "SELECT u FROM UserMaster u WHERE u.addressLine = :addressLine"),
    @NamedQuery(name = "UserMaster.findByCity", query = "SELECT u FROM UserMaster u WHERE u.city = :city"),
    @NamedQuery(name = "UserMaster.findByState", query = "SELECT u FROM UserMaster u WHERE u.state = :state"),
    @NamedQuery(name = "UserMaster.findByPincode", query = "SELECT u FROM UserMaster u WHERE u.pincode = :pincode"),
    @NamedQuery(name = "UserMaster.findByPassword", query = "SELECT u FROM UserMaster u WHERE u.password = :password"),
    @NamedQuery(name = "UserMaster.findByTechnology", query = "SELECT u FROM UserMaster u WHERE u.technology = :technology"),
    @NamedQuery(name = "UserMaster.findBySpecialization", query = "SELECT u FROM UserMaster u WHERE u.specialization = :specialization"),
    @NamedQuery(name = "UserMaster.findByCertification", query = "SELECT u FROM UserMaster u WHERE u.certification = :certification"),
    @NamedQuery(name = "UserMaster.findByToken", query = "SELECT u FROM UserMaster u WHERE u.token = :token")})
public class UserMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "User_Id")
    private Integer userId;
    @Size(max = 100)
    @Column(name = "F_Name")
    private String fName;
    @Size(max = 100)
    @Column(name = "L_Name")
    private String lName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Mobile_No")
    private String mobileNo;
    @Size(max = 500)
    @Column(name = "Profile_Image")
    private String profileImage;
    @Column(name = "Birth_Date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Address_Line")
    private String addressLine;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "City")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "State")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Pincode")
    private int pincode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "Password")
    private String password;
    @Size(max = 200)
    @Column(name = "Technology")
    private String technology;
    @Size(max = 200)
    @Column(name = "Specialization")
    private String specialization;
    @Size(max = 500)
    @Column(name = "Certification")
    private String certification;
    @Size(max = 500)
    @Column(name = "Token")
    private String token;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Feedback> feedbackCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Resume> resumeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Qualification> qualificationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Collection<ApprovedJob> approvedJobCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<ApprovedJob> approvedJobCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Chat> chatCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Collection<JobRequest> jobRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<JobRequest> jobRequestCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Collection<Training> trainingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Training> trainingCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Collection<Job> jobCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Collection<Interview> interviewCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Interview> interviewCollection1;

    public UserMaster() {
    }

    public UserMaster(Integer userId) {
        this.userId = userId;
    }

    public UserMaster(Integer userId, String email, String mobileNo, String addressLine, String city, String state, int pincode, String password) {
        this.userId = userId;
        this.email = email;
        this.mobileNo = mobileNo;
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @JsonbTransient
    public Collection<Feedback> getFeedbackCollection() {
        return feedbackCollection;
    }

    @JsonbTransient
    public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
        this.feedbackCollection = feedbackCollection;
    }

    @JsonbTransient
    public Collection<Resume> getResumeCollection() {
        return resumeCollection;
    }

    @JsonbTransient
    public void setResumeCollection(Collection<Resume> resumeCollection) {
        this.resumeCollection = resumeCollection;
    }

    @JsonbTransient
    public Collection<Qualification> getQualificationCollection() {
        return qualificationCollection;
    }

    @JsonbTransient
    public void setQualificationCollection(Collection<Qualification> qualificationCollection) {
        this.qualificationCollection = qualificationCollection;
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
    public Collection<ApprovedJob> getApprovedJobCollection1() {
        return approvedJobCollection1;
    }

    @JsonbTransient
    public void setApprovedJobCollection1(Collection<ApprovedJob> approvedJobCollection1) {
        this.approvedJobCollection1 = approvedJobCollection1;
    }

    @JsonbTransient
    public Collection<Chat> getChatCollection() {
        return chatCollection;
    }

    @JsonbTransient
    public void setChatCollection(Collection<Chat> chatCollection) {
        this.chatCollection = chatCollection;
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
    public Collection<JobRequest> getJobRequestCollection1() {
        return jobRequestCollection1;
    }

    @JsonbTransient
    public void setJobRequestCollection1(Collection<JobRequest> jobRequestCollection1) {
        this.jobRequestCollection1 = jobRequestCollection1;
    }

    @JsonbTransient
    public Collection<Training> getTrainingCollection() {
        return trainingCollection;
    }

    @JsonbTransient
    public void setTrainingCollection(Collection<Training> trainingCollection) {
        this.trainingCollection = trainingCollection;
    }

    @JsonbTransient
    public Collection<Training> getTrainingCollection1() {
        return trainingCollection1;
    }

    @JsonbTransient
    public void setTrainingCollection1(Collection<Training> trainingCollection1) {
        this.trainingCollection1 = trainingCollection1;
    }

    @JsonbTransient
    public Collection<Job> getJobCollection() {
        return jobCollection;
    }

    @JsonbTransient
    public void setJobCollection(Collection<Job> jobCollection) {
        this.jobCollection = jobCollection;
    }

    @JsonbTransient
    public Collection<Interview> getInterviewCollection() {
        return interviewCollection;
    }

    @JsonbTransient
    public void setInterviewCollection(Collection<Interview> interviewCollection) {
        this.interviewCollection = interviewCollection;
    }

    @JsonbTransient
    public Collection<Interview> getInterviewCollection1() {
        return interviewCollection1;
    }

    @JsonbTransient
    public void setInterviewCollection1(Collection<Interview> interviewCollection1) {
        this.interviewCollection1 = interviewCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserMaster)) {
            return false;
        }
        UserMaster other = (UserMaster) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPC.UserMaster[ userId=" + userId + " ]";
    }
    
}
