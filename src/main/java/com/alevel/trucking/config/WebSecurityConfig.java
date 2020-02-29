package com.alevel.trucking.config;

import com.alevel.trucking.config.jwt.JwtAuthenticationFilter;
import com.alevel.trucking.config.jwt.JwtAuthorizationFilter;
import com.alevel.trucking.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    private final UserDetailsService userDetailsService;

    private final UserService userService;

    @Autowired
    public WebSecurityConfig(PasswordEncoder passwordEncoder,
                             @Qualifier("userDetailsServiceImplementation")
                                     UserDetailsService userDetailsService, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors()
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), userService))
                .authorizeRequests()
                .antMatchers("/", "/reg").permitAll()
                .antMatchers("/customer/**").hasAuthority("customer")
                .antMatchers("/manager/**").hasAuthority("manager")
                .antMatchers("/driver/**").hasAuthority("driver")
                .antMatchers("/admin/**").hasAuthority("admin")
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

}