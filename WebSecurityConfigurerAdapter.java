package com.tuempresa.nombre_del_proyecto.codigos;

import jakarta.servlet.Filter;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception {
        HttpSecurity httpSecurity;
        httpSecurity = http.csrf().disable()
                .authorizeRequests()
                .dispatcherTypeMatchers(HttpMethod.valueOf("/auth/**")).permitAll() // Permite acceso a las rutas de autenticación
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(equals(), UsernamePasswordAuthenticationFilter.class);
    }

    private Filter equals() {
        return null;
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Configura el AuthenticationManager si es necesario
    }
}
