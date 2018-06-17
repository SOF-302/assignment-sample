package vn.poly.sof302.duongnv21.department.repositories.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import vn.poly.sof302.duongnv21.common.bases.BaseRepository;
import vn.poly.sof302.duongnv21.common.entities.Department;
import vn.poly.sof302.duongnv21.department.repositories.DepartmentRepository;

/**
 * Department repository
 *
 * @author duongnguyen
 * @since 1.0.0
 */
@Repository
public class DepartmentRepositoryImpl extends BaseRepository implements DepartmentRepository {

    @Override
    public Long count(String code, String name) {

        // Build query string with default delFlg conditional
        StringBuilder queryStb = new StringBuilder("select count(1) from Department where delFlg = :delFlg");

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
    public List<Department> select(String code, String name, int offset, int limit) {

        StringBuilder queryStb = new StringBuilder("from Department where delFlg = :delFlg");

        // Add code condition
        if (StringUtils.isNotBlank(code)) {
            queryStb.append(" and code like :code ");
        }

        // Add name conditional
        if (StringUtils.isNotBlank(name)) {
            queryStb.append(" and name like :name ");
        }

        // Add order conditional
        queryStb.append(" order by code");

        // Build query
        Query query = this.getCurrentSession().createQuery(queryStb.toString());

        // Set delFlg parameter
        query.setString("delFlg", Department.DelFlg.UNDELETED.name());

        // Set code parameter
        if (StringUtils.isNotBlank(code)) {
            query.setString("code", "%" + code + "%");
        }

        // Set name parameter
        if (StringUtils.isNotBlank(name)) {
            query.setString("name", "%" + name + "%");
        }

        return query.setFirstResult(offset)
                .setMaxResults(limit)
                .list();
    }

    @Override
    public Department select(Long id) {

        Department entity =  this.getCurrentSession().get(Department.class, id);

        if (entity.getDelFlg() == Department.DelFlg.UNDELETED) {
            return entity;
        }

        return null;
    }

    @Override
    public Long insert(Department department) {

        department.setDelFlg(Department.DelFlg.UNDELETED);
        department.setInsDate(new Date());
        department.setUpdDate(new Date());

        return (Long) super.insert(department);
    }

    @Override
    public Long update(Department department) {

        department.setUpdDate(new Date());

        return (Long) super.update(department);
    }

    @Override
    public Long remove(Department department) {

        department.setDelFlg(Department.DelFlg.DELETED);
        department.setUpdDate(new Date());

        return (Long) super.update(department);
    }
}
