package pl.yakub.book.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.yakub.book.bean.StatusBean;
import pl.yakub.book.data.User;
import pl.yakub.book.service.UserService;

import javax.inject.Inject;
import java.net.URI;
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
        return userService.getUser(id);
    }


    @PostMapping()
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        User savedUser = userService.addUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("{id}")
    public StatusBean deleteUser(@PathVariable Long id) {
        boolean deleted = userService.delete(id);
        return new StatusBean(deleted ? "success" : "failed");
    }
}
