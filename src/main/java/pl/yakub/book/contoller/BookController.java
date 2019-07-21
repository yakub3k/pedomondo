package pl.yakub.book.contoller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.yakub.book.data.Book;
import pl.yakub.book.service.BookService;

import java.util.ArrayList;
import java.util.List;

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
    public Book getBook(@PathVariable Integer id) {
        return service.getBookById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Integer id){
        service.deleteBook(id);
    }

    @PutMapping()
    public Book addBook(@PathVariable Book book){
        return service.addBook(book);
    }
}
