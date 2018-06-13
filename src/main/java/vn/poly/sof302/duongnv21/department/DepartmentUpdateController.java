package vn.poly.sof302.duongnv21.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.poly.sof302.duongnv21.common.utils.DataTransformUtil;
import vn.poly.sof302.duongnv21.department.dto.DepartmentDto;
import vn.poly.sof302.duongnv21.department.form.DepartmentUpdateForm;
import vn.poly.sof302.duongnv21.department.service.DepartmentService;

/**
 * Update a department
 * 
 * @author duongnguyen
 */
@Controller
@RequestMapping("/department")
public class DepartmentUpdateController {

    /*=====================================================================================================
     *===== AUTOWIRED PROPERTIES                                                                      =====
     *=====================================================================================================*/

    @Autowired
    DepartmentService departmentService;

    /*=====================================================================================================
     *===== MAPPING METHOD                                                                            =====
     *=====================================================================================================*/

    /**
     * Show update input form
     * 
     * @return Update input screen
     */
    @GetMapping("/update/{id}")
    public String input(ModelMap model,@PathVariable Long id) {
        
        // Get data
        DepartmentDto departmentDto = departmentService.detail(id);
        DepartmentUpdateForm form = (DepartmentUpdateForm)
                DataTransformUtil.transform(departmentDto, DepartmentUpdateForm.class);

        model.addAttribute("departmentUpdateForm", form);

        return "department/update";
    }

    /**
     * Update a department
     * 
     * @return Success: List department screen
     *          Errors: Update input screen
     */
    @PostMapping("/update")
    public String submit(ModelMap model, DepartmentUpdateForm form) {

        // Validate input parameters
        // TODO

        // Cast form dto
        DepartmentDto departmentDto = (DepartmentDto) DataTransformUtil.transform(form, DepartmentDto.class);

        // Call service to update department
        departmentService.update(departmentDto);

        return "redirect:/department";
    }
}
