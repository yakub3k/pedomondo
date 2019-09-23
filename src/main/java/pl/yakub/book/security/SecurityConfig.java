package pl.yakub.book.security;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.inject.Inject;
import javax.sql.DataSource;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig{// extends WebSecurityConfigurerAdapter {
//
//    private static final RequestMatcher GET_MATCHER = r -> r.getMethod().equals(HttpMethod.GET.name());
//    private static final RequestMatcher POST_MATCHER = r -> r.getMethod().equals(HttpMethod.POST.name());
//    private static final RequestMatcher SYSTEM_MATCHER = r -> r.getRequestURI().startsWith("/system/");
//
//    @Inject
//    DataSource dataSource;
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        staticAuth(auth);
////    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.debug(true);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .anyRequest().permitAll()
//
//                .and()
//                .authorizeRequests()
//                .requestMatchers(POST_MATCHER).permitAll()
//
//                .and()
//                .formLogin().loginPage("/login")
//
//                .and()
//                .logout().logoutUrl("/logout")
//        ;
////                .requestMatchers(GET_MATCHER).permitAll()
////                .requestMatchers(POST_MATCHER).permitAll()
////                .requestMatchers(SYSTEM_MATCHER).authenticated()
////                .and()
////                .formLogin()
////                .and()
////                .httpBasic();
//    }
//
//    private void staticAuth(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("yakub")
//                .password("{noop}password")
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("{noop}admin")
//                .roles("USER", "ADMIN");
//
//    }
//
//    private void dbAuth(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("SELECT username, password FROM user WHERE username=?");
//    }
}
