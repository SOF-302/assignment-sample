package vn.poly.sof302.duongnv21.department;

import java.util.List;

import vn.poly.sof302.duongnv21.common.bases.BaseServiceInterface;
import vn.poly.sof302.duongnv21.common.entities.Department;

/**
 * Department service
 * 
 * @author duongnguyen
 * @since 1.0.0
 */
public interface DepartmentService extends BaseServiceInterface {

    /**
     * Get list department
     * 
     * @param code
     * @param name
     * @param pn
     * 
     * @return List department
     */
    List<Department> list(String code, String name, Long pn);
}
