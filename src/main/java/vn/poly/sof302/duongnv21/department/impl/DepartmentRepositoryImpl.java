package vn.poly.sof302.duongnv21.department.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import vn.poly.sof302.duongnv21.common.bases.BaseRepository;
import vn.poly.sof302.duongnv21.common.entities.Department;
import vn.poly.sof302.duongnv21.department.DepartmentRepository;

/**
 * Department repository
 * 
 * @author duongnguyen
 * @since 1.0.0
 */
@Repository
public class DepartmentRepositoryImpl extends BaseRepository implements DepartmentRepository {

    @Override
    @SuppressWarnings("unchecked")
    public List<Department> selectList(String code, String name, int offset, int limit) {

        return this.getCurrentSession().createQuery("from Department").list();
    }

}
