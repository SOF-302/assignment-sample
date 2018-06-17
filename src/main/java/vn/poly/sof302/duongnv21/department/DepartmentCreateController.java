package vn.poly.sof302.duongnv21.department;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
     * Show create screen
     *
     * @param model     Model map
     * @param form      Form data
     * @return Create screen
     */
    @GetMapping("/create")
    public String input(ModelMap model, DepartmentCreateForm form) {

        // Return Create screen
        return "department/create";
    }

    /**
     * Create new department
     *
     * @param model         Model map
     * @param form          Form data
     * @param bindingResult Binding result
     *
     * @return  Success: List department screen
     *          Errors: Create input screen
     */
    @PostMapping("/create")
    public String submit(ModelMap model, @Valid DepartmentCreateForm form, BindingResult bindingResult) {

        // Validate department code
        // TODO

        // Return create form
        if (bindingResult.hasErrors()) {
            return "department/create";
        }

        // Cast Form to DTO
        DepartmentDto departmentDto = (DepartmentDto) DataTransformUtil.transform(form, DepartmentDto.class);

        // Call service to insert new department
        departmentService.create(departmentDto);

        // Return to list screen with success message
        return "redirect:/department";
    }
}
