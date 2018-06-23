package vn.poly.sof302.duongnv21.department.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Department create form
 *
 * @author duongnguyen
 * @since 1.0.0
 */
public class DepartmentCreateForm {

    @NotEmpty(message="{errors.notEmpty}")
    @Size(min= 5, max = 5)
    private String code;

    @NotEmpty(message="{errors.notEmpty}")
    @Size(max = 255)
    private String name;

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
}
