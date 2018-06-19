package vn.poly.sof302.duongnv21.employee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.poly.sof302.duongnv21.common.entities.Employee.Gender;
import vn.poly.sof302.duongnv21.employee.dto.EmployeeDto;
import vn.poly.sof302.duongnv21.employee.form.EmployeeCreateForm;
import vn.poly.sof302.duongnv21.employee.service.EmployeeService;

/**
 * Employee create controller
 *
 * @author duongnguyen
 */
@Controller
@RequestMapping("/employee")
public class EmployeeCreateController {

    /*=====================================================================================================
     *===== AUTOWIRED PROPERTIES                                                                      =====
     *=====================================================================================================*/

    @Autowired
    EmployeeService employeeService;

    /*=====================================================================================================
     *===== MAPPING METHOD                                                                            =====
     *=====================================================================================================*/

    /**
     * Generate create screen
     *
     * @param model
     * @param form
     *
     * @return Ereate screen
     */
    @GetMapping("/create")
    public String input(ModelMap model, EmployeeCreateForm employeeCreateForm) {

        // Set data for pulldown departments
        employeeCreateForm.setGender(Gender.U);
        model.addAttribute("departments", employeeService.departments(null));

        // Generate create screen
        return "/employee/create";
    }

    /**
     * Create new employee
     *
     * @param model
     * @param form
     * @param bindingResult
     *
     * @return  Success: List employee screen
     *          Errors: Create input screen
     */
    @PostMapping("/create")
    public String submit(ModelMap model, @Valid EmployeeCreateForm employeeCreateForm,
                        BindingResult bindingResult, @RequestParam(required = false) MultipartFile file) {

        // Validate data
        validateFormData(employeeCreateForm, bindingResult);

        // Check errors
        if (bindingResult.hasErrors()) {

            // Set data for pulldown departments
            model.addAttribute("departments", employeeService.departments(null));

            // Generate create screen
            return "/employee/create";
        }

        // Cast Form to DTO
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setDepartmentId(employeeCreateForm.getDepartmentId());
        employeeDto.setCode(employeeCreateForm.getCode());
        employeeDto.setName(employeeCreateForm.getName());
        employeeDto.setGender(employeeCreateForm.getGender());
        employeeDto.setEmail(employeeCreateForm.getEmail());
        employeeDto.setPhone(employeeCreateForm.getPhone());
        employeeDto.setNotes(employeeCreateForm.getNotes());
        // TODO


        // Save image
        if (file != null && !file.isEmpty()) {
            employeeDto.setPhoto(employeeService.saveImage(employeeCreateForm.getCode(), file));
        }

        // Call service to insert new department
        employeeService.create(employeeDto);

        return "redirect:/employee";
    }

    /**
     * Validate complex data
     *
     * @param form
     * @param bindingResult
     */
    private void validateFormData(EmployeeCreateForm form, BindingResult bindingResult) {

        // Birthday
        if (StringUtils.isNotEmpty(form.getBirthday())) {
            // TODO
        }

        // Email
        if (StringUtils.isNotEmpty(form.getEmail())) {

            Pattern emailPattern =
                    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

            Matcher matcher = emailPattern .matcher(form.getEmail());

            if (!matcher.find()) {
                bindingResult.rejectValue("email", "email", "Must be an email address");
            }
        }

        // Salary
        if (StringUtils.isNotEmpty(form.getSalary())) {
            // TODO
        }
    }
}
