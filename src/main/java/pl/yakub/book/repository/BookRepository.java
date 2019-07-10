package pl.yakub.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.yakub.book.data.Book;


@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, Integer> {

    Book getBookByTitle(String title);
}
