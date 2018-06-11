package vn.poly.sof302.duongnv21.department.repositories;

import java.util.List;

import vn.poly.sof302.duongnv21.common.entities.Department;

/**
 * Department Repository
 * 
 * @author duongnguyen
 * @since 1.0.0
 */
public interface DepartmentRepository {

    /**
     * Get list department
     * 
     * @param code
     * @param name
     * @param offset
     * @param limit
     * 
     * @return
     */
    List<Department> selectList(String code, String name, int offset, int limit);
}
