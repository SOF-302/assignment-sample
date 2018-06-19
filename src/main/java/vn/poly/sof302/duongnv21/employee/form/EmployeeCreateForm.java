package vn.poly.sof302.duongnv21.employee.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import vn.poly.sof302.duongnv21.common.entities.Employee.Gender;

/**
 * Employee search form
 *
 * @author duongnguyen
 */
public class EmployeeCreateForm {

    /**
     * DUONGNV21_STAFF.DEPARTMENT_ID
     */
    @NotNull
    private Long departmentId;

    /**
     * DUONGNV21_STAFF.CODE
     */
    @NotEmpty
    @Size(min= 6, max = 6)
    private String code;

    /**
     * DUONGNV21_STAFF.NAME
     */
    @NotEmpty
    @Size(max = 255)
    private String name;

    /**
     * DUONGNV21_STAFF.GENDER
     */
    private Gender gender;

    /**
     * DUONGNV21_STAFF.BIRTHDAY
     */
    private String birthday;

    /**
     * DUONGNV21_STAFF.PHOTO
     */
    private String photo;

    /**
     * DUONGNV21_STAFF.EMAIL
     */
    private String email;

    /**
     * DUONGNV21_STAFF.PHONE
     */
    private String phone;

    /**
     * DUONGNV21_STAFF.SALARY
     */
    private String salary;

    /**
     * DUONGNV21_STAFF.NOTES
     */
    private String notes;

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
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
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
    public String getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(String salary) {
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
}
