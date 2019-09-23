package pl.yakub.book.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.yakub.book.data.Author;
import pl.yakub.book.data.Book;
import pl.yakub.book.data.User;
import pl.yakub.book.service.BookService;
import pl.yakub.book.service.UserService;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(("/init"))
public class InitController {

    @Inject
    private UserService userService;

    @Inject
    private BookService bookService;

    @GetMapping("users")
    public List<User> initUsers() {
        userService.addUser(new User("adam", "pass", "adam@example.com"));
        userService.addUser(new User("jon", "pass", "jon@example.com"));
        userService.addUser(new User("alice", "pass", "alice@example.com"));
        return userService.getAllUsers();
    }

    @GetMapping("books")
    public List<Book> initBooks() {
        bookService.addBook("Słownik wyrazów obcych i zwrotów", "Kopaliński");
        bookService.addBook("SJP PWN", "Autor Zbiorowy");
        return bookService.getAllBooks();
    }
}
