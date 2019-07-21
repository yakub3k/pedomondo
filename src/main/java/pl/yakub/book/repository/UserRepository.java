package pl.yakub.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.yakub.book.data.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
