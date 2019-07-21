package pl.yakub.book.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.yakub.book.data.User;
import pl.yakub.book.service.UserService;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Inject
    private UserService userService;

    @GetMapping("all")
    public List<User> getAllBook() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable Long id) {
        return new User(id, "yakub", "pass", "email");
    }

    @PostMapping()
    public void addUser() {
        userService.addUser("yakub", "password", true);
    }
}
