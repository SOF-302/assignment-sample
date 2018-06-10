package vn.poly.sof302.duongnv21.department;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Update a department
 * 
 * @author duongnguyen
 */
@Controller
@RequestMapping("/department")
public class DepartmentUpdateController {

    /**
     * Show update input form
     * 
     * @return Update input screen
     */
    @GetMapping("/update")
    public String input() {

        return "department/update";
    }

    /**
     * Update a department
     * 
     * @return Success: List department screen
     *          Errors: Update input screen
     */
    @PostMapping("/update")
    public String submit() {

        return "redirect:/department";
    }
}
