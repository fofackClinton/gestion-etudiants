package com.example.universiter.securite;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
public class configurationSecurite {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return
                httpSecurity
                            .csrf(AbstractHttpConfigurer::disable)
                            .authorizeHttpRequests(
                                authorize -> 
                                            authorize
                                                    .requestMatchers("/utilisateur").permitAll()
                                                    .requestMatchers("utilisateur/{id}").permitAll()
                                                    .requestMatchers("utilisateur/rolee/{id}").permitAll()
                                                    .requestMatchers("classe/{id}").permitAll()
                                                    .requestMatchers("classe").permitAll()
                                                    .requestMatchers("departement/{id}").permitAll()
                                                    .requestMatchers("departement").permitAll()
                                                    .requestMatchers("etudiant/{id}").permitAll()
                                                    .requestMatchers("enseignant/{id}").permitAll()
                                                    .requestMatchers("enseignant").permitAll()
                                                    .requestMatchers("filiere/{id}").permitAll()
                                                    .requestMatchers("filiere").permitAll()
                                                    .requestMatchers("responsable").permitAll()
                                                    .requestMatchers(POST,"/connexion").permitAll()
                                                    .anyRequest().authenticated()
                            )
                            .build();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
    {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService)
    {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());
        return daoAuthenticationProvider;
    }

}
