package pl.yakub.book.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.yakub.book.data.User;

@RestController
@RequestMapping(path = "test")
public class TestController {

    @GetMapping("user/{id}")
    public User getTestUser(@PathVariable Long id) {
        return new User(id, "yakub", "pass", "email");
    }
}
