package ru.kata.spring.boot_security.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// ru.kata.spring.boot_security.demo.services.UserService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final SuccessUserHandler successUserHandler;
//    private final UserService userService;
//
//    @Autowired
//    public WebSecurityConfig(SuccessUserHandler successUserHandler, UserService userService) {
//        this.successUserHandler = successUserHandler;
//        this.userService = userService;
//    }
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                //можно без индекса, если не буду применять - // Доступ к корню сайта доступен всем пользователям
                .antMatchers("/").permitAll()
                .antMatchers("/authenticated/**").authenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/profile/**").hasAnyRole("ADMIN", "USER")
                // Доступ ко всем остальным url даётся только аутентифицированным пользователям
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //.formLogin().successHandler(successUserHandler).permitAll()
                .and()
                //ниже /КУДА ПЕРЕХОДИМ ПОСЛЕ LOGOUT (ЛОГ АУТ ПРОПИСЫВАЕМ ТАКЖЕ В /
                .logout().logoutSuccessUrl("/").permitAll();

        // Используем базовую аутентификацию
        // Имя пользователя и пароль передаются в заголовке в зашифрованном виде
        //   .and().httpBasic();
    }
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
//        authenticationProvider.setUserDetailsService(userService);
//        return authenticationProvider;
//    }
}


