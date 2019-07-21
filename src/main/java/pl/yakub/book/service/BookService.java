package pl.yakub.book.service;

import org.springframework.stereotype.Service;
import pl.yakub.book.data.Author;
import pl.yakub.book.data.Book;
import pl.yakub.book.repository.AuthorRepository;
import pl.yakub.book.repository.BookRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Inject
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
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

    public Book addBook(String title, String author) {
        Author authorByName = authorRepository.getAuthorByName(author);
        if (authorByName == null) {
            authorByName = new Author(author);
            authorRepository.save(authorByName);
        }
        return bookRepository.save(new Book(title, authorByName));
    }

    public List<Book> getAllAuthorBooks(Long authorId) {
        return bookRepository.getBookByAuthorId(authorId);
    }
}
