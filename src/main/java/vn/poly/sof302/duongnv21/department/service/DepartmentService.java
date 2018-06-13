package vn.poly.sof302.duongnv21.department.service;

import java.util.List;

import vn.poly.sof302.duongnv21.common.bases.BaseServiceInterface;
import vn.poly.sof302.duongnv21.department.dto.DepartmentDto;

/**
 * Department service
 * 
 * @author duongnguyen
 * @since 1.0.0
 */
public interface DepartmentService extends BaseServiceInterface {

    /**
     * Get list department
     * 
     * @param code
     * @param name
     * @param pn
     * 
     * @return List department
     */
    List<DepartmentDto> list(String code, String name, Long pn);

    /**
     * Create new department
     * 
     * @param departmentDto
     * 
     * @return Created id
     */
    Long create(DepartmentDto departmentDto);
    
    /**
     * Get detail info of department
     * 
     * @param id
     * 
     * @return
     */
    DepartmentDto detail(Long id);
    
    /**
     * Update existed department
     * 
     * @param departmentDto
     * 
     * @return
     */
    Long update(DepartmentDto departmentDto);
}
