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


@RestController
@RequestMapping(path = "/fake")
public class FakeController {

    @Inject
    private BookService bookService;

    @Inject
    private AuthorService authorService;

    @GetMapping("addbook/{id}")
    public Book addOneBook(@PathVariable Long id) {
        return new Book("Tytul", new Author("Randowm"));
    }

    @GetMapping("book/insert/{title}/{author}")
    public Book addBook(@PathVariable String title, @PathVariable String author) {
        return bookService.addBook(title, author);
    }

    @GetMapping("author/insert/{author}")
    public Author addAuthor(@PathVariable String author) {
        return authorService.addAuthor(new Author(author));
    }
}
