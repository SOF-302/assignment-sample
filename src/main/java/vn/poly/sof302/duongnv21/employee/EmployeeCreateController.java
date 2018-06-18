package vn.poly.sof302.duongnv21.employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Employee create controller
 *
 * @author duongnguyen
 */
@Controller
@RequestMapping("/employee")
public class EmployeeCreateController {

    @GetMapping("/create")
    public String input() {

        return "/employee/create";
    }

    @PostMapping("/create")
    public String submit() {


        return "redirect:/employee";
    }
}
