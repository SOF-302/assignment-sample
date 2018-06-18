package vn.poly.sof302.duongnv21.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.poly.sof302.duongnv21.common.dto.ListDataDto;
import vn.poly.sof302.duongnv21.employee.dto.EmployeeDto;
import vn.poly.sof302.duongnv21.employee.form.EmployeeSearchForm;
import vn.poly.sof302.duongnv21.employee.service.EmployeeService;

/**
 * Employee list controller
 *
 * @author duongnguyen
 */
@Controller
@RequestMapping("/employee")
public class EmployeeListController {

    /*=====================================================================================================
     *===== AUTOWIRED PROPERTIES                                                                      =====
     *=====================================================================================================*/

    @Autowired
    EmployeeService employeeService;

    /*=====================================================================================================
     *===== MAPPING METHOD                                                                            =====
     *=====================================================================================================*/

    /**
     * Generate employee list screen
     *
     * @param model
     * @return Employee list screen
     */
    @GetMapping
    public String index(ModelMap model, @RequestParam(required = false) Long departmentId,
                                        @RequestParam(required = false) String code,
                                        @RequestParam(required = false) String name,
                                        @RequestParam(defaultValue = "1") Long pn) {

        // Fill data into search form
        EmployeeSearchForm employeeSearchForm = new EmployeeSearchForm();
        employeeSearchForm.setDepartmentId(departmentId);
        employeeSearchForm.setCode(code);
        employeeSearchForm.setName(name);
        model.addAttribute("employeeSearchForm", employeeSearchForm);

        // Get list data with paging
        ListDataDto<EmployeeDto> ListDataDto = employeeService.list(departmentId, code, name, pn);

        // Add list data
        model.addAttribute("listEmployees", ListDataDto.getList());
        model.addAttribute("paging", ListDataDto.getPaging());

        // Set data for pulldown departments
        model.addAttribute("departments", employeeService.departments(null));

        // Return list screen
        return "/employee/index";
    }
}
