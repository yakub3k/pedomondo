package pl.yakub.book.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.yakub.book.data.Author;

@RepositoryRestResource
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Author getAuthorByName(String name);
}