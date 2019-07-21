package pl.yakub.book.service;

import org.springframework.stereotype.Service;
import pl.yakub.book.data.Author;
import pl.yakub.book.data.Book;
import pl.yakub.book.data.Category;
import pl.yakub.book.repository.AuthorRepository;
import pl.yakub.book.repository.BookRepository;
import pl.yakub.book.repository.CategoryRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    @Inject
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
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

    public Book addCategory(Long bookId, String category) {
        Category categoryByName = categoryRepository.getCategoryByName(category);
        if (categoryByName == null) {
            categoryByName = new Category(category);
            categoryRepository.save(categoryByName);
        }
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            List<Category> categories = book.getCategory();
            if (!categories.contains(categoryByName)) {
                categories.add(categoryByName);
            }
            bookRepository.save(book);
            return book;
        }
        return null;
    }
}
