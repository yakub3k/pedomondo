package pl.yakub.book.repository.jdbc;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.yakub.book.data.User;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class JdbcUserRepository implements UserRepository {
    private static final String SELECT_USER_BY_LOGIN = "SELECT * FROM users WHERE login=:login";

    private JdbcOperations jdbcOperations;

    @Inject
    public JdbcUserRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public User findByLogin(String login) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("login", login);

//        return jdbcOperations.queryForObject(SELECT_USER_BY_LOGIN, params, new UserMapper());
        return new User(1L, "yakub", "pass", "email");
    }

    public static final class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setLogin(rs.getString("login"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    }
}
