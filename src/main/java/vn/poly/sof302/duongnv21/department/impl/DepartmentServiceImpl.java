package vn.poly.sof302.duongnv21.department.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.poly.sof302.duongnv21.common.bases.BaseService;
import vn.poly.sof302.duongnv21.common.entities.Department;
import vn.poly.sof302.duongnv21.department.DepartmentRepository;
import vn.poly.sof302.duongnv21.department.DepartmentService;

/**
 * Deparment service implement
 * 
 * @author duongnguyen
 * @since 1.0.0
 */
@Service
public class DepartmentServiceImpl extends BaseService implements DepartmentService {

    /*=====================================================================================================
     *===== AUTOWIRED PROPERTIES                                                                      =====
     *=====================================================================================================*/

    @Autowired
    DepartmentRepository departmentRepository;

    /*=====================================================================================================
     *===== MAPPING METHOD                                                                            =====
     *=====================================================================================================*/

    @Override
    public List<Department> list(String code, String name, Long pn) {

        // TODO Auto-generated method stub

        return departmentRepository.selectList(code, name, 1, 10);
    }

}
