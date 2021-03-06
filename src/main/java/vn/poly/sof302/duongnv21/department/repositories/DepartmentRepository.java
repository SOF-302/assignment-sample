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
     * Count list department
     *
     * @param code
     * @param name
     *
     * @return
     */
    Long count(String code, String name);

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
    List<Department> select(String code, String name, int offset, int limit);

    /**
     * Get detail department
     *
     * @param id
     *
     * @return
     */
    Department select(Long id);

    /**
     * Create new object
     *
     * @param department
     *
     * @return Inserted entity id
     */
    Long insert(Department department);

    /**
     * Update existed object
     *
     * @param department
     *
     * @return Updated entity id
     */
    Long update(Department department);

    /**
     * Remove existed object
     *
     * @param department
     *
     * @return Remove entity id
     */
    Long remove(Department department);
}
