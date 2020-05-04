package ru.itis.deadathome.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier(value = "customUserDetailsService")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/users/**").hasAuthority("ADMIN")
                .antMatchers("/profile").authenticated()
                .antMatchers("/edit").authenticated()
                .antMatchers("/create_house").authenticated()
                .antMatchers("/create_post").authenticated()
                .antMatchers("/flud").authenticated()
                .antMatchers("/chat").permitAll()
                .antMatchers("/searchHouses").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/posts").permitAll()
                .antMatchers("/post**").permitAll()
                .antMatchers("/houses").permitAll()
                .antMatchers("/house**").permitAll()
                .antMatchers("/signUp").permitAll()
                .antMatchers("/files").permitAll()
                .antMatchers("/confirm/**").permitAll()
                .and()
                .rememberMe().rememberMeParameter("remember-me").tokenRepository(persistentTokenRepository());

        http.formLogin()
                .loginPage("/signIn")
                .defaultSuccessUrl("/")
                .failureUrl("/signIn?error")
                .usernameParameter("email")
                .permitAll();

        http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .deleteCookies("SESSION", "remember-me")
                .invalidateHttpSession(true);

    }

    @Autowired
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Autowired
    private DataSource dataSource;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

}
