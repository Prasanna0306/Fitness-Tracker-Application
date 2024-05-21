package com.project.fitness.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;



@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encode){
        UserDetails Gymowner = User.withUsername("Gymowner")
                                    .password(encode.encode("admin123"))
                                    .roles("ADMIN")
                                    .build();
        UserDetails trainer = User.withUsername("trainer")
                                    .password(encode.encode("user123"))
                                    .roles("TRAINER")
                                    .build();
        UserDetails nutritionist = User.withUsername("nutritionist")
                                    .password(encode.encode("user123"))
                                    .roles("NUTRITIONIST")
                                    .build();
        UserDetails user = User.withUsername("user")
                                    .password(encode.encode("user123"))
                                    .roles("USER")
                                    .build();                            
        return new InMemoryUserDetailsManager(Gymowner,trainer,nutritionist,user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry. anyRequest().authenticated())
                .httpBasic(withDefaults())
                .build();
    }
  
}
