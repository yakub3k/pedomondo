package pl.yakub.book.contoller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.yakub.book.data.Book;
import pl.yakub.book.service.BookService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("all")
    public List<Book> getAllBook() {
        return service.getAllBooks();
    }

    @GetMapping("{id}")
    public Book getBook(@PathVariable Long id) {
        return service.getBookById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
    }

    @PutMapping()
    public Book addBook(HttpServletRequest request) {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        return service.addBook(title, author);
    }

    @PostMapping("{id}")
    public Book addCategories(@PathVariable Long id, HttpServletRequest request) {
        String[] categories = request.getParameterValues("category");
        Optional.ofNullable(categories)
                .map(Arrays::stream)
                .ifPresent(stream
                        -> stream.forEach(category
                        -> service.addCategory(id, category)));
        return service.getBookById(id).orElse(null);
    }
}
