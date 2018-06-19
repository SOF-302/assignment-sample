package vn.poly.sof302.duongnv21.employee.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vn.poly.sof302.duongnv21.common.bases.BaseService;
import vn.poly.sof302.duongnv21.common.dto.ListDataDto;
import vn.poly.sof302.duongnv21.common.dto.ListPagingDto;
import vn.poly.sof302.duongnv21.common.entities.Department;
import vn.poly.sof302.duongnv21.common.entities.Employee;
import vn.poly.sof302.duongnv21.common.utils.DataTransformUtil;
import vn.poly.sof302.duongnv21.employee.dto.DepartmentDto;
import vn.poly.sof302.duongnv21.employee.dto.EmployeeDto;
import vn.poly.sof302.duongnv21.employee.repositories.DepartmentRepository;
import vn.poly.sof302.duongnv21.employee.repositories.EmployeeRepository;
import vn.poly.sof302.duongnv21.employee.service.EmployeeService;

/**
 * Employee service implement
 *
 * @author duongnguyen
 */
@Service
public class EmployeeServiceImpl extends BaseService implements EmployeeService {

    /*=====================================================================================================
     *===== AUTOWIRED PROPERTIES                                                                      =====
     *=====================================================================================================*/

    @Autowired
    @Qualifier("empDepartmentRepositoryImpl")
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ServletContext context;

    /*=====================================================================================================
     *===== MAPPING METHOD                                                                            =====
     *=====================================================================================================*/

    @Override
    public List<DepartmentDto> departments(String code) {

        List<Department> departmentList = departmentRepository.search(code);

        List<DepartmentDto> departmentDtoList = new ArrayList<>();
        for (Department department : departmentList) {
            departmentDtoList.add(
                    (DepartmentDto) DataTransformUtil.transform(department, DepartmentDto.class));
        }

        return departmentDtoList;
    }

    @Override
    public ListDataDto<EmployeeDto> list(Long departmentId, String code, String name, Long pn) {

        // Declare result data
        ListDataDto<EmployeeDto> listDataDto = new ListDataDto<EmployeeDto>();

        // Calculating paging
        ListPagingDto pagingDto = listDataDto.getPaging();
        pagingDto.setCurrentPage(pn);

        // Count record
        Long totalRecords = employeeRepository.count(departmentId, code, name);
        pagingDto.setTotalRecords(totalRecords);

        // Check no result data
        if (totalRecords.intValue() == 0) {
            return listDataDto;
        }

        // Get list employee
        List<Employee> employeeList = employeeRepository
                                        .select(departmentId, code, name, pagingDto.getOffset(), pagingDto.getLimit());

        // Cast to employee dto
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for (Employee employee : employeeList) {

            EmployeeDto employeeDto = (EmployeeDto) DataTransformUtil.transform(employee, EmployeeDto.class);

            Department department = employee.getDepartment();
            employeeDto.setDepartmentId(department.getId());
            employeeDto.setDepartmentCode(department.getCode());
            employeeDto.setDepartmentName(department.getName());

            employeeDtoList.add(employeeDto);
        }

        // Set list into data dto
        listDataDto.setList(employeeDtoList);

        // Return data list
        return listDataDto;
    }

    @Override
    public EmployeeDto detail(Long id) {

        // Get data
        Employee employee = employeeRepository.select(id);

        // Check existing
        if (employee == null) {
            throw new RuntimeException("Cannot find entity with id or It was deleted");
        }

        // Return detail DTO
        return (EmployeeDto) DataTransformUtil.transform(employee, EmployeeDto.class);
    }

    @Override
    public Long create(EmployeeDto employeeDto) {

        // Create new entity
        Employee employee = (Employee) DataTransformUtil.transform(employeeDto, Employee.class);

        // Return create result
        return employeeRepository.insert(employee);
    }

    @Override
    public Long update(EmployeeDto employeeDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long remove(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String saveImage(String code, MultipartFile file) {

        String uploadFileSavePath = context.getRealPath("/WEB-INF/upload/");
        String originalFileName = file.getOriginalFilename();

        StringBuilder stbFilePath = new StringBuilder(uploadFileSavePath);
        stbFilePath.append(code);
        stbFilePath.append(originalFileName.substring(originalFileName.lastIndexOf('.')));

        File saveFile = new File(stbFilePath.toString());
        try {
            logger.info("Save image into: " + stbFilePath.toString());
            file.transferTo(saveFile);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return stbFilePath.toString().replace(uploadFileSavePath, StringUtils.EMPTY);
    }
}
