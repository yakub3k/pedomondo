package pl.yakub.book;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import pl.yakub.book.repository.jdbc.JdbcUserRepository;
import pl.yakub.book.repository.jdbc.UserRepository;


import javax.sql.DataSource;


public class DataConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .addScript("classpath:data.sql")
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        System.out.println("yakub3k: jdbc");
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public UserRepository userRepository(final JdbcOperations jdbcOperations) {
        System.out.println("yakub3k: userRepository");
        return new JdbcUserRepository(jdbcOperations);
    }
}
