package vn.poly.sof302.duongnv21.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Welcome -> Index controller
 * @author duongnguyen
 * @since 1.0.0
 */
@Controller
@RequestMapping("/")
public class IndexController {

    /**
     * Generate index page
     * 
     * @return Index screen
     */
    @GetMapping
    public String index() {

        return "/homepage/index";
    }
}