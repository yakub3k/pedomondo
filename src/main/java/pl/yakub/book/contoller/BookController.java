package pl.yakub.book.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.yakub.book.data.Author;
import pl.yakub.book.data.Book;
import pl.yakub.book.service.BookService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/book/{id}/")
    public Book getBook(@PathVariable String id) {
        return service.getBookById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping("/books")
    public List<Book> getAllBook() {
        return service.getAllBooks();
    }

    @GetMapping("/onebook/{id}/")
    public Book getOneBook(@PathVariable String id) {
        return new Book(Integer.parseInt(id), "Tytul", new Author("Randowm"), new ArrayList<>());
    }
}
