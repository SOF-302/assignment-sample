package vn.poly.sof302.duongnv21.department.form;

/**
 * Department create form 
 * 
 * @author duongnguyen
 * @since 1.0.0
 */
public class DepartmentSearchForm {

    private String code;
    
    private String name;

    private Long pn;

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
