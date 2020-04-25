package edu.tcu.cs.hogwartsartifactsonline.config;

import edu.tcu.cs.hogwartsartifactsonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // let Spring Security know how to retrieve user info from your system
        auth.userDetailsService(this.userService);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/h2-console").permitAll()
                .antMatchers("/artifacts/**").permitAll()
                .antMatchers("/wizards/**").permitAll()
                .antMatchers("/users/login").permitAll()
                .antMatchers("/users").authenticated()
                .antMatchers(HttpMethod.DELETE, "/users/**").hasAuthority("admin")
                .and().formLogin().loginProcessingUrl("/users/login");
        http.csrf().disable();
        // for h2 console
        http.headers().frameOptions().disable();
    }
}
