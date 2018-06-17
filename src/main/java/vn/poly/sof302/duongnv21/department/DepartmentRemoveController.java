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
import vn.poly.sof302.duongnv21.department.form.DepartmentRemoveForm;
import vn.poly.sof302.duongnv21.department.service.DepartmentService;

/**
 * Remove a department
 *
 * @author duongnguyen
 */
@Controller
@RequestMapping("/department")
public class DepartmentRemoveController {

    /*=====================================================================================================
     *===== AUTOWIRED PROPERTIES                                                                      =====
     *=====================================================================================================*/

    @Autowired
    DepartmentService departmentService;

    /*=====================================================================================================
     *===== MAPPING METHOD                                                                            =====
     *=====================================================================================================*/

    /**
     * Show remove confirm screen
     *
     * @param model     Model map
     * @param id        Department record id
     * @param form      Form data
     *
     * @return Remove confirm screen
     */
    @GetMapping("/remove/{id}")
    public String confirm(ModelMap model, @PathVariable Long id, DepartmentRemoveForm form) {


        // Get data
        DepartmentDto departmentDto = departmentService.detail(id);
        DataTransformUtil.transform(departmentDto, form);

        // Return confirm screen
        return "department/remove";
    }

    /**
     * Remove a department
     *
     * @param model         Model map
     * @param id            Department record id
     * @param form          Form data
     * @param bindingResult Binding result
     *
     * @return Success: List department screen
     *          Errors: Remove confirm screen
     */
    @PostMapping("/remove/{id}")
    public String submit(ModelMap model, @PathVariable Long id,
                                         @Valid DepartmentRemoveForm form, BindingResult bindingResult) {


        // Call service to remove department
        departmentService.remove(id);

        // Return list screen
        return "redirect:/department";
    }
}
