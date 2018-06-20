package vn.poly.sof302.duongnv21.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Logout controller
 *
 * @author duongnguyen
 */
@Controller
@RequestMapping("/auth/logout")
public class LogoutController {

    @GetMapping
    public String index() {

        return "redirect:/";
    }
}
