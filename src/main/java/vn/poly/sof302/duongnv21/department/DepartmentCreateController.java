package vn.poly.sof302.duongnv21.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.poly.sof302.duongnv21.common.utils.DataTransformUtil;
import vn.poly.sof302.duongnv21.department.dto.DepartmentDto;
import vn.poly.sof302.duongnv21.department.form.DepartmentCreateForm;
import vn.poly.sof302.duongnv21.department.service.DepartmentService;

/**
 * Create new department
 * 
 * @author duongnguyen
 */
@Controller
@RequestMapping("/department")
public class DepartmentCreateController {

    /*=====================================================================================================
     *===== AUTOWIRED PROPERTIES                                                                      =====
     *=====================================================================================================*/

    @Autowired
    DepartmentService departmentService;

    /*=====================================================================================================
     *===== MAPPING METHOD                                                                            =====
     *=====================================================================================================*/

    /**
     * Show input form
     * 
     * @return Create input screen
     */
    @GetMapping("/create")
    public String input(ModelMap model) {
        
        // Initial dempty form
        model.addAttribute("departmentCreateForm", new DepartmentCreateForm());

        return "department/create";
    }

    /**
     * Create new department
     * 
     * @return Success: List department screen
     *          Errors: Create input screen
     */
    @PostMapping("/create")
    public String submit(ModelMap model, DepartmentCreateForm form) {

        // Validate input parameters
        // TODO

        // Cast form dto
        DepartmentDto departmentDto = (DepartmentDto) DataTransformUtil.transform(form, DepartmentDto.class);

        // Call service to insert new department
        departmentService.create(departmentDto);

        return "redirect:/department";
    }
}
