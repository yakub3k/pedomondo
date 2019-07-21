package pl.yakub.book.service;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import pl.yakub.book.data.Author;
import pl.yakub.book.repository.AuthorRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;


@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Inject
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author addAuthor(Author author) {
        boolean exists = authorRepository.exists(Example.of(author));
        if (exists)
            return authorRepository.getAuthorByName(author.getName());
        return authorRepository.save(author);
//
//        Author existedAuthor = authorRepository.getAuthorByName(author.getName());
//        return (existedAuthor == null)
//                ? authorRepository.save(author)
//                : existedAuthor;
    }

    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.getAuthorById(id);
    }
}
