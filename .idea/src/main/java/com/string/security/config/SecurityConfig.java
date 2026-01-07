package com.string.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public").permitAll() // public
                        .anyRequest().authenticated()           // secure
                )
                .formLogin(Customizer.withDefaults()); // default login page
        // .formLogin(form -> form.defaultSuccessUrl("/hello", true));

        return http.build();
    }
    // 👇 In-memory user
    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user = User
                .withUsername("ziyad")
                .password("{noop}password123")
                .roles("USER")
                .build();
        //multiple user name example
        UserDetails admin = User.withUsername("admin")
                .password("{noop}admin123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user,admin);
    }
}


