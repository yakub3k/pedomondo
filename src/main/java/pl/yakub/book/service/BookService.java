package pl.yakub.book.service;

import org.springframework.stereotype.Service;
import pl.yakub.book.data.Book;
import pl.yakub.book.repository.BookRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    private final BookRepository bookRepository;

    @Inject
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
}
