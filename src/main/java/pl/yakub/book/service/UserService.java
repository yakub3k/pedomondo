package pl.yakub.book.service;

import org.springframework.stereotype.Service;
import pl.yakub.book.data.User;
import pl.yakub.book.repository.UserRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    @Inject
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public User addUser(User user) {
        return repository.save(user);
    }

    public User getUser(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    public boolean delete(Long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()){
            repository.delete(user.get());
            return true;
        }
        return false;
    }
}
