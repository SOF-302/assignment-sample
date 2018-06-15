package vn.poly.sof302.duongnv21.department.repositories.impl;

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
    public Long selectCount(String code, String name) {

        StringBuilder queryStb = new StringBuilder("select count(1) from Department");

        if (StringUtils.isNoneBlank(code, name)) {
            queryStb.append(" where code = :code OR name = :name ");
        } else if (StringUtils.isNotBlank(code)) {
            queryStb.append(" where code = :code ");
        } else if (StringUtils.isNotBlank(name)) {
            queryStb.append(" where name = :name ");
        }

        Query query = this.getCurrentSession().createQuery(queryStb.toString());
        if (StringUtils.isNotBlank(code)) {
            query.setString("code", code);
        }
        if (StringUtils.isNotBlank(name)) {
            query.setString("name", name);
        }

        return (Long) query.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Department> selectList(String code, String name, int offset, int limit) {

        StringBuilder queryStb = new StringBuilder("from Department");

        if (StringUtils.isNoneBlank(code, name)) {
            queryStb.append(" where code = :code OR name = :name ");
        } else if (StringUtils.isNotBlank(code)) {
            queryStb.append(" where code = :code ");
        } else if (StringUtils.isNotBlank(name)) {
            queryStb.append(" where name = :name ");
        }

        Query query = this.getCurrentSession().createQuery(queryStb.toString());
        if (StringUtils.isNotBlank(code)) {
            query.setString("code", code);
        }
        if (StringUtils.isNotBlank(name)) {
            query.setString("name", name);
        }

        return query.setFirstResult(offset)
                .setMaxResults(limit)
                .list();
    }

    @Override
    public Department selectOne(Long id) {
        return this.getCurrentSession().get(Department.class, id);
    }

    @Override
    public Long insert(Department department) {
        return (Long) super.insert(department);
    }

    @Override
    public Long update(Department department) {
        return (Long) super.update(department);
    }
}
