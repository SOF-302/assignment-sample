package vn.poly.sof302.duongnv21.employee.form;

/**
 * Employee search form
 *
 * @author duongnguyen
 */
public class EmployeeSearchForm {

    private Long departmentId;

    private String code;

    private String name;

    private Long pn;

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
     * @return the pn
     */
    public Long getPn() {
        return pn;
    }

    /**
     * @param pn the pn to set
     */
    public void setPn(Long pn) {
        this.pn = pn;
    }
}
