package vn.poly.sof302.duongnv21.employee.repositories.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import vn.poly.sof302.duongnv21.common.bases.BaseRepository;
import vn.poly.sof302.duongnv21.common.entities.Department;
import vn.poly.sof302.duongnv21.common.entities.Employee;
import vn.poly.sof302.duongnv21.employee.repositories.EmployeeRepository;

/**
 * Employee repository implement
 *
 * @author duongnguyen
 */
@Repository
public class EmployeeRepositoryImpl extends BaseRepository implements EmployeeRepository {

    @Override
    public Long count(Long departmentId, String code, String name) {

        // Build query string with default delFlg conditional
        StringBuilder queryStb = new StringBuilder("select count(1) from Employee where delFlg = :delFlg");

        // Add department condition
        if (departmentId != null) {
            queryStb.append(" and departmentId = :departmentId ");
        }

        // Add code condition
        if (StringUtils.isNotBlank(code)) {
            queryStb.append(" and code like :code ");
        }

        // Add name conditional
        if (StringUtils.isNotBlank(name)) {
            queryStb.append(" and name like :name ");
        }

        // Build query
        Query query = this.getCurrentSession().createQuery(queryStb.toString());

        // Set delFlg parameter
        query.setString("delFlg", Department.DelFlg.UNDELETED.name());

        // Set department parameter
        if (departmentId != null) {
            query.setLong("departmentId", departmentId);
        }

        // Set code parameter
        if (StringUtils.isNotBlank(code)) {
            query.setString("code", "%" + code + "%");
        }

        // Set name parameter
        if (StringUtils.isNotBlank(name)) {
            query.setString("name", "%" + name + "%");
        }

        return (Long) query.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> select(Long departmentId, String code, String name, int offset, int limit) {

        // Build query string with default delFlg conditional
        StringBuilder queryStb = new StringBuilder("from Employee where delFlg = :delFlg");

        // Add department condition
        if (departmentId != null) {
            queryStb.append(" and departmentId = :departmentId ");
        }

        // Add code condition
        if (StringUtils.isNotBlank(code)) {
            queryStb.append(" and code like :code ");
        }

        // Add name conditional
        if (StringUtils.isNotBlank(name)) {
            queryStb.append(" and name like :name ");
        }

        // Build query
        Query query = this.getCurrentSession().createQuery(queryStb.toString());

        // Set delFlg parameter
        query.setString("delFlg", Department.DelFlg.UNDELETED.name());

        // Set department parameter
        if (departmentId != null) {
            query.setLong("departmentId", departmentId);
        }

        // Set code parameter
        if (StringUtils.isNotBlank(code)) {
            query.setString("code", "%" + code + "%");
        }

        // Set name parameter
        if (StringUtils.isNotBlank(name)) {
            query.setString("name", "%" + name + "%");
        }

        return query.setFirstResult(offset).setMaxResults(limit).list();
    }

}
