package pl.yakub.book.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.yakub.book.data.Author;
import pl.yakub.book.data.Book;
import pl.yakub.book.service.AuthorService;
import pl.yakub.book.service.BookService;

import javax.inject.Inject;
import java.util.Optional;


@RestController
@RequestMapping(path = "/fake")
public class FakeController {

    @Inject
    private BookService bookService;

    @Inject
    private AuthorService authorService;

    @GetMapping("addbook/{title}")
    public Book addOneBook(@PathVariable String title) {
        return bookService.addBook(title, "Randowm_" + Math.random());
    }

    @GetMapping("insert/book/{title}/{author}")
    public Book addBook(@PathVariable String title, @PathVariable String author) {
        return bookService.addBook(title, author);
    }

    @GetMapping("insert/author/{author}")
    public Author addAuthor(@PathVariable String author) {
        return authorService.addAuthor(new Author(author));
    }

    @GetMapping("insert/book/{bookId}/category/{category}")
    public Book addCategory(@PathVariable Long bookId, @PathVariable String category) {
        Optional<Book> bookById = bookService.getBookById(bookId);
        if (bookById.isPresent()) {
            bookService.addCategory(bookId, category);
        }
        return bookById.orElse(null);
    }
}
