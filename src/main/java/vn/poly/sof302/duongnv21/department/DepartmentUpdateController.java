package vn.poly.sof302.duongnv21.department;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
     * @param model     Model map
     * @param id        Department record id
     * @param form      Form data
     *
     * @return Update screen
     */
    @GetMapping("/update/{id}")
    public String input(ModelMap model, @PathVariable Long id, DepartmentUpdateForm form) {

        // Get data
        DepartmentDto departmentDto = departmentService.detail(id);
        DataTransformUtil.transform(departmentDto, form);

        // Return update screen
        return "department/update";
    }

    /**
     * Update a department
     *
     * @param model         Model map
     * @param id            Department record id
     * @param form          Form data
     * @param bindingResult Binding result
     *
     * @return  Success: List department screen
     *          Errors: Update input screen
     */
    @PostMapping("/update/{id}")
    public String submit(ModelMap model, @PathVariable Long id,
                                         @Valid DepartmentUpdateForm form, BindingResult bindingResult) {

        // Validate department code
        // TODO

        // Return create form
        if (bindingResult.hasErrors()) {
            return "department/update";
        }

        // Cast Form to DTO
        DepartmentDto departmentDto = (DepartmentDto) DataTransformUtil.transform(form, DepartmentDto.class);
        departmentDto.setId(id);

        // Call service to update department
        departmentService.update(departmentDto);

        return "redirect:/department";
    }
}
