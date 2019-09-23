package pl.yakub.book.service;

import org.springframework.stereotype.Service;
import pl.yakub.book.components.HistoryComponent;
import pl.yakub.book.data.User;
import pl.yakub.book.repository.UserRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;
    private final HistoryComponent history;

    @Inject
    public UserService(UserRepository repository, HistoryComponent history) {
        this.repository = repository;
        this.history = history;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User addUser(User user) {
        User addedUser = repository.save(user);
        history.appendEventAdd("user: " + addedUser.getLogin());
        return addedUser;
    }

    public User getUser(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    public boolean delete(Long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            User deletedUser = user.get();
            repository.delete(deletedUser);
            String login = deletedUser.getLogin();
            history.appendEventDelete("user: " + login);
            return true;
        }
        return false;
    }
}
