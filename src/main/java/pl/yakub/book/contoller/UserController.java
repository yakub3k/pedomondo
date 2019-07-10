package pl.yakub.book.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.yakub.book.data.Book;
import pl.yakub.book.data.User;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/user/{id}/")
    public User getUser(@PathVariable String id) {
        return new User(Integer.parseInt(id), "yakub", "pass", "email");
    }

    @GetMapping("/users")
    public List<User> getAllBook() {
        return new ArrayList<>();
    }
}
