package vn.poly.sof302.duongnv21.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Show list departments with search and pagaing
 * 
 * @author duongnguyen
 */
@Controller
@RequestMapping("/department")
public class DepartmentListController {

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
        
        model.addAttribute("listDepartments", departmentService.list(code, name, pn));

        return "/department/index";
    }
}
