package com.realdolmen.spring.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//TODO Exercise 2: Create the Spring Security Java configuration class
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //TODO Exercise 2: Override the configure(AuthenticationManagerBuilder) method and configure a user and administrator with an in-memory user store
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER", "ADMIN");
    }

//    TODO Exercise 3: Override the configure(HttpSecurity) method
//    TODO Exercise 3: Protect the /authors, /blogs and /blog pages to logged in users
//    TODO Exercise 3: Redirect to your login page
//    TODO Exercise 3: Add remember-me functionality
//    TODO Exercise 3: Configure logout and add a logout link to your pages
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
        .loginPage("/login").and()
                .logout()
        .logoutSuccessUrl("/index")
                .logoutRequestMatcher(new AntPathRequestMatcher("/index")).and()
                .rememberMe()
        .tokenValiditySeconds(30)
        .key("SpringSecuredKey").and()
                .authorizeRequests()
        .antMatchers("/authors/**").authenticated()
        .antMatchers("/blog").authenticated()
        .antMatchers("/blogs/**").authenticated();
    }
}
