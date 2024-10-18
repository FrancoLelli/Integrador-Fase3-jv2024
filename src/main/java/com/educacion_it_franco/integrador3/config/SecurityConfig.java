package com.educacion_it_franco.integrador3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/catalogo", "/css/**", "/js/**", "/images/**").permitAll()  // Define qué rutas son accesibles sin autenticación
                                .anyRequest().authenticated()  // Todas las demás rutas requieren autenticación
                )
                .formLogin(form -> form
                        .loginPage("/login")  // Página de login personalizada si la necesitas
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }
}
