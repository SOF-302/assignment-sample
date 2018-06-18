package vn.poly.sof302.duongnv21.common.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Employee Entity
 *
 * @author duongnguyen
 * @since 1.0.0
 */
@Entity
@Table(name = "DUONGNV21_STAFF")
public class Employee {

    /*=====================================================================================================
     *===== PRIVATE PROPERTIES                                                                        =====
     *=====================================================================================================*/

    /**
     * DUONGNV21_STAFF.ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /**
     * DUONGNV21_STAFF.DEPARTMENT_ID
     */
    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;

    /**
     * DUONGNV21_STAFF.CODE
     */
    @Column(name = "CODE")
    private String code;

    /**
     * DUONGNV21_STAFF.NAME
     */
    @Column(name = "NAME")
    private String name;

    /**
     * DUONGNV21_STAFF.GENDER
     */
    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    /**
     * DUONGNV21_STAFF.BIRTHDAY
     */
    @Column(name = "BIRTHDAY")
    private Date birthday;

    /**
     * DUONGNV21_STAFF.PHOTO
     */
    @Column(name = "PHOTO")
    private String photo;

    /**
     * DUONGNV21_STAFF.EMAIL
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * DUONGNV21_STAFF.PHONE
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * DUONGNV21_STAFF.SALARY
     */
    @Column(name = "SALARY")
    private Long salary;

    /**
     * DUONGNV21_STAFF.NOTES
     */
    @Column(name = "NOTES")
    private String notes;

    /**
     * DUONGNV21_STAFF.DEL_FLG
     */
    @Column(name = "DEL_FLG")
    @Enumerated(EnumType.STRING)
    private DelFlg delFlg;

    /**
     * DUONGNV21_STAFF.INS_DATE
     */
    @Column(name = "INS_DATE")
    private Date insDate;

    /**
     * DUONGNV21_STAFF.UPD_DATE
     */
    @Column(name = "UPD_DATE")
    private Date updDate;

    /**
     * DUONGNV21_STAFF.DUONGNV21_DEPARTMENT
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Department department;

    /*=====================================================================================================
     *===== CONSTRUCTOR METHOD                                                                        =====
     *=====================================================================================================*/

    /**
     * Default constructor
     */
    public Employee() {
    }

    /*=====================================================================================================
     *===== GETTER & SETTER                                                                           =====
     *=====================================================================================================*/

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the departmentId
     */
    public Long getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId the departmentId to set
     */
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the salary
     */
    public Long getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(Long salary) {
        this.salary = salary;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return the delFlg
     */
    public DelFlg getDelFlg() {
        return delFlg;
    }

    /**
     * @param delFlg the delFlg to set
     */
    public void setDelFlg(DelFlg delFlg) {
        this.delFlg = delFlg;
    }

    /**
     * @return the insDate
     */
    public Date getInsDate() {
        return insDate;
    }

    /**
     * @param insDate the insDate to set
     */
    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }

    /**
     * @return the updDate
     */
    public Date getUpdDate() {
        return updDate;
    }

    /**
     * @param updDate the updDate to set
     */
    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }

    /**
     * @return the department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /*=====================================================================================================
     *===== ENUM CLASSES                                                                              =====
     *=====================================================================================================*/

    /**
     * GENDER Enum
     */
    public enum Gender {

        F, M, U;
    }

    /**
     * DEL_FLG Enum
     */
    public enum DelFlg {

        UNDELETED, DELETED;
    }
}
