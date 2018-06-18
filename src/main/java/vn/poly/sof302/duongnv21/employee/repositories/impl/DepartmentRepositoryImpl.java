package vn.poly.sof302.duongnv21.employee.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import vn.poly.sof302.duongnv21.common.bases.BaseRepository;
import vn.poly.sof302.duongnv21.common.entities.Department;
import vn.poly.sof302.duongnv21.employee.repositories.DepartmentRepository;

/**
 * Department repository implement
 *
 * @author duongnguyen
 */
@Repository("empDepartmentRepositoryImpl")
public class DepartmentRepositoryImpl extends BaseRepository implements DepartmentRepository {

    @Override
    @SuppressWarnings("unchecked")
    public List<Department> search(String code) {

        StringBuilder queryStb = new StringBuilder("from Department where delFlg = :delFlg");

        // TODO

        // Add order conditional
        queryStb.append(" order by code");

        // Build query
        Query query = this.getCurrentSession().createQuery(queryStb.toString());

        // Set delFlg parameter
        query.setString("delFlg", Department.DelFlg.UNDELETED.name());

        // TODO

        return query.list();
    }

}
