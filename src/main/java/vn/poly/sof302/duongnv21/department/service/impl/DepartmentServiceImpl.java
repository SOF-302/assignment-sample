package vn.poly.sof302.duongnv21.department.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.poly.sof302.duongnv21.common.bases.BaseService;
import vn.poly.sof302.duongnv21.common.entities.Department;
import vn.poly.sof302.duongnv21.common.utils.DataTransformUtil;
import vn.poly.sof302.duongnv21.department.dto.DepartmentDto;
import vn.poly.sof302.duongnv21.department.repositories.DepartmentRepository;
import vn.poly.sof302.duongnv21.department.service.DepartmentService;

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
    public List<DepartmentDto> list(String code, String name, Long pn) {
        
        // Calculating paging
        // TODO

        // Get list department
        List<Department> departmentList = departmentRepository.selectList(code, name, 1, 10);
        
        // Check deparment list
        if (CollectionUtils.isEmpty(departmentList)) {
            return null;
        }

        // Cast to department dto
        List<DepartmentDto> departmentDtoList = new ArrayList<>();
        for (Department department : departmentList) {
            departmentDtoList.add(
                    (DepartmentDto) DataTransformUtil.transform(department, DepartmentDto.class));
        }

        return departmentDtoList;
    }

    @Override
    public Long create(DepartmentDto departmentDto) {

        // Create new entity
        Department entity = (Department) DataTransformUtil.transform(departmentDto, Department.class);
        entity.setDelFlg(Department.DelFlg.UNDELETED);
        entity.setInsDate(new Date());
        entity.setUpdDate(new Date());

        return departmentRepository.insert(entity);
    }

    @Override
    public DepartmentDto detail(Long id) {

        Department department = departmentRepository.selectOne(id);

        return (DepartmentDto) DataTransformUtil.transform(department, DepartmentDto.class);
    }

    @Override
    public Long update(DepartmentDto departmentDto) {

        // Create updating entity
        Department entity = departmentRepository.selectOne(departmentDto.getId());
        entity.setCode(departmentDto.getCode());
        entity.setName(departmentDto.getName());
        entity.setUpdDate(new Date());

        return departmentRepository.update(entity);
    }

}