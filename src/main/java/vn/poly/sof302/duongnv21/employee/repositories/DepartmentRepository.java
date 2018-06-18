package vn.poly.sof302.duongnv21.employee.repositories;

import java.util.List;

import vn.poly.sof302.duongnv21.common.bases.BaseRepositoryInterface;
import vn.poly.sof302.duongnv21.common.entities.Department;

/**
 * Department repository
 *
 * @author duongnguyen
 */
public interface DepartmentRepository extends BaseRepositoryInterface {

    List<Department> search(String code);
}
