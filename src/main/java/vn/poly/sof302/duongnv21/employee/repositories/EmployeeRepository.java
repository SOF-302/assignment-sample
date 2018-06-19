package vn.poly.sof302.duongnv21.employee.repositories;

import java.util.List;

import vn.poly.sof302.duongnv21.common.bases.BaseRepositoryInterface;
import vn.poly.sof302.duongnv21.common.entities.Employee;

/**
 * Employee repository
 *
 * @author duongnguyen
 */
public interface EmployeeRepository extends BaseRepositoryInterface {

    Long count(Long deparmentId, String code, String name);

    List<Employee> select(Long departmentId, String code, String name, int offset, int limit);

    Employee select(Long id);

    Long insert(Employee employee);

    Long update(Employee employee);

    Long remove(Employee employee);
}
