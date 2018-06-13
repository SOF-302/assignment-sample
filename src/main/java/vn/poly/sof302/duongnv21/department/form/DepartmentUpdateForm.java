package vn.poly.sof302.duongnv21.department.form;

/**
 * Department create form 
 * 
 * @author duongnguyen
 * @since 1.0.0
 */
public class DepartmentUpdateForm {

    private Long id;

    private String code;
    
    private String name;

    public String getCode() {
        return code;
    }

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

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
