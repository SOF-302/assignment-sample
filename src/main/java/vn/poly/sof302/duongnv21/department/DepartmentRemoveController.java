package vn.poly.sof302.duongnv21.department;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Remove a department
 * 
 * @author duongnguyen
 */
@Controller
@RequestMapping("/department")
public class DepartmentRemoveController {

    /**
     * Show remove confirm screen
     * 
     * @return Remove confirm screen
     */
    @GetMapping("/remove")
    public String confirm() {

        return "department/remove";
    }

    /**
     * Remove a department
     * 
     * @return Success: List department screen
     *          Errors: Remove confirm screen
     */
    @PostMapping("/remove")
    public String submit() {

        return "redirect:/department";
    }
}
