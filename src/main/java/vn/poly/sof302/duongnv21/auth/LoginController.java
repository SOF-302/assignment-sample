package vn.poly.sof302.duongnv21.auth;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import vn.poly.sof302.duongnv21.auth.form.LoginForm;
import vn.poly.sof302.duongnv21.common.bases.BaseController;
import vn.poly.sof302.duongnv21.common.dto.LoginUserDto;

/**
 * @author duongnguyen
 *
 */
@Controller
@RequestMapping("/auth/login")
public class LoginController extends BaseController {

    @GetMapping
    public String input(ModelMap model, LoginForm loginForm,
                        @SessionAttribute("LOGGED_IN_USER_DTO") LoginUserDto loginUserDto) {

        // Check logged in
        if (StringUtils.isNotEmpty(loginUserDto.getUsername())) {
         // Return home page
            return "redirect:/";
        }

        return "/auth/login";
    }

    @PostMapping
    public String submit(ModelMap model, @Valid LoginForm loginForm, BindingResult bindingResult,
                                        @SessionAttribute("LOGGED_IN_USER_DTO") LoginUserDto loginUserDto) {

        // Check errors
        if (bindingResult.hasErrors()) {
            return "/auth/login";
        }

        loginUserDto.setUsername(loginForm.getUsername());

        // Return home page
        return "redirect:/";
    }
}
