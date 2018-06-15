package vn.poly.sof302.duongnv21.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.poly.sof302.duongnv21.common.bases.BaseController;
import vn.poly.sof302.duongnv21.common.dto.ListDataDto;
import vn.poly.sof302.duongnv21.department.dto.DepartmentDto;
import vn.poly.sof302.duongnv21.department.form.DepartmentSearchForm;
import vn.poly.sof302.duongnv21.department.service.DepartmentService;

/**
 * Show list departments with search and pagaing
 * 
 * @author duongnguyen
 */
@Controller
@RequestMapping("/department")
public class DepartmentListController extends BaseController {

    /*=====================================================================================================
     *===== AUTOWIRED PROPERTIES                                                                      =====
     *=====================================================================================================*/

    @Autowired
    DepartmentService departmentService;

    /*=====================================================================================================
     *===== MAPPING METHOD                                                                            =====
     *=====================================================================================================*/

    /**
     * Generate list department screen with search and paging conditional
     * 
     * @return List department screen
     */
    @GetMapping
    public String index(@RequestParam(required = false) String code,
                        @RequestParam(required = false) String name,
                        @RequestParam(defaultValue = "1") Long pn,
                        ModelMap model) {

        // Add search form data
        DepartmentSearchForm form = new DepartmentSearchForm();
        form.setCode(code);
        form.setName(name);
        model.addAttribute("departmentSearchForm", form);

        // Get list data with paging
        ListDataDto<DepartmentDto> ListDataDto = departmentService.list(code, name, pn);

        // Add list data
        model.addAttribute("listDepartments", ListDataDto.getList());
        model.addAttribute("paging", ListDataDto.getPaging());

        return "/department/index";
    }
}
