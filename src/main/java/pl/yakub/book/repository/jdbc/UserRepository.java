package pl.yakub.book.repository.jdbc;


import pl.yakub.book.data.User;

@Deprecated
public interface UserRepository {
    User findByLogin(String login);

}
