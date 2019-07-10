package pl.yakub.book.repository;


import pl.yakub.book.data.User;

public interface UserRepository {
    User findByLogin(String login);

}
