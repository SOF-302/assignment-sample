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

    @NotEmpty
    @Size(max = 5)
    private String code;

    @NotEmpty
    @Size(max = 255)
    private String name;

    public String getCode() {
        return code;
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
