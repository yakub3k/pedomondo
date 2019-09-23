package pl.yakub.book.contoller;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.yakub.book.components.UserSession;

import javax.inject.Inject;

@RepositoryRestController
@RequestMapping("/system/login")
public class LoginController {

    @Inject
    private UserSession userSession;

    @PostMapping
    public @ResponseBody ResponseEntity<?> login(){
        return ResponseEntity.ok("Success");
    }

    @GetMapping
    public String loginPage(){
        return "login";
    }
}
