package vn.poly.sof302.duongnv21.department.dto;

/**
 * Department DTO
 * 
 * @author duongnguyen
 * @since 1.0.0
 */
public class DepartmentDto {

    /*=====================================================================================================
     *===== PRIVATE PROPERTIES                                                                        =====
     *=====================================================================================================*/

    /**
     * DUONGNV21_DEPARTMENT.ID
     */
    private Long id;

    /**
     * DUONGNV21_DEPARTMENT.CODE
     */
    private String code;

    /**
     * DUONGNV21_DEPARTMENT.NAME
     */
    private String name;

    /*=====================================================================================================
     *===== CONSTRUCTOR METHOD                                                                        =====
     *=====================================================================================================*/

    /**
     * Default constructor
     */
    public DepartmentDto() {
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
