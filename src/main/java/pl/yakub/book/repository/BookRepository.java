package pl.yakub.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.yakub.book.data.Book;

import java.util.List;


@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, Long> {

    Book getBookByTitle(String title);

    List<Book> getBookByAuthorId(Long authorId);
}
