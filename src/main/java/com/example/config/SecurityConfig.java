package com.example.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

@AllArgsConstructor
@EnableMethodSecurity(prePostEnabled = true,jsr250Enabled = true)
public class SecurityConfig {

    BCryptPasswordEncoder encoder;




    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails indiaUser = User.withUsername("india")
                .password(encoder.encode("india")).roles("ADMIN").build();

        UserDetails nepalUser = User.withUsername("nepal")
                .password(encoder.encode("nepal")).roles("GUEST").build();

        return new InMemoryUserDetailsManager(indiaUser, nepalUser);


    }

    @Bean
    public SecurityFilterChain filterchain(HttpSecurity http) throws Throwable {

        http.authorizeHttpRequests(auth -> auth.requestMatchers("/api/v2/**").permitAll())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/api/v1/**").authenticated())
                          .csrf(AbstractHttpConfigurer::disable).httpBasic(Customizer.withDefaults());


        return http.build();
    }


}
