package pl.yakub.book.service;

import org.springframework.stereotype.Service;
import pl.yakub.book.data.User;
import pl.yakub.book.repository.UserRepository;

import javax.inject.Inject;
import java.util.List;

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

    public void addUser(String login, String password, boolean admin) {
        repository.save(new User());
    }
}
