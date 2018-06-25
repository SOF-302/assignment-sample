package vn.poly.sof302.duongnv21.employee.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import vn.poly.sof302.duongnv21.common.bases.BaseServiceInterface;
import vn.poly.sof302.duongnv21.common.dto.ListDataDto;
import vn.poly.sof302.duongnv21.employee.dto.DepartmentDto;
import vn.poly.sof302.duongnv21.employee.dto.EmployeeDto;

/**
 * Employee service
 *
 * @author duongnguyen
 */
public interface EmployeeService extends BaseServiceInterface {

    List<DepartmentDto> departments(String code);

    ListDataDto<EmployeeDto> list(Long departmentId, String code, String name, Long pn);

    EmployeeDto detail(Long id);

    Long create(EmployeeDto employeeDto);

    Long update(EmployeeDto employeeDto);

    Long remove(Long id);

    String saveImage(String code, MultipartFile file);

    void sendEmail(String email);
}
