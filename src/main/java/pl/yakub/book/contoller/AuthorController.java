package pl.yakub.book.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.yakub.book.data.Author;
import pl.yakub.book.data.Book;
import pl.yakub.book.service.AuthorService;
import pl.yakub.book.service.BookService;

import java.util.List;

@RestController
@RequestMapping(path = "/author")
public class AuthorController {

    private final AuthorService service;
    private final BookService bookService;

    public AuthorController(AuthorService service, BookService bookService) {
        this.service = service;
        this.bookService = bookService;
    }

    @GetMapping("all")
    public List<Author> getAllAuthors() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Author getAuthor(@PathVariable Long id) {
        return service.getAuthorById(id)
                .orElseThrow(() -> new IllegalArgumentException("Unknown Author Id: " + id));
    }

    @GetMapping("{id}/books")
    public List<Book> getAuthorsBooks(@PathVariable Long id) {
        Author author = service.getAuthorById(id)
                .orElseThrow(() -> new IllegalArgumentException("Unknown Author Id: " + id));
        return bookService.getAllAuthorBooks(author.getId());
    }
}
