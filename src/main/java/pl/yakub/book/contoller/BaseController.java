package pl.yakub.book.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping("/")
    public String getHome() {
        return "redirect:/book/all";
    }
}
