package com.example.block7crudvalidation.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    AuthenticationConfiguration authenticationConfiguration;

    // Con este método al llamar a la clase CustomAuthentication podremos establecerla como configuración
    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // Con esto podemos dar permisos a diferentes endpoint según el tipo de usuario
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean(authenticationConfiguration));
        customAuthenticationFilter.setFilterProcessesUrl("/login");
        http.csrf().disable()
                .authorizeRequests().antMatchers(POST,"/login/security").permitAll()
                .antMatchers(GET,"/person/**").hasAnyAuthority("ADMIN")
//                .antMatchers(GET,"/person/**").permitAll()
//                .antMatchers(POST,"/person/**").permitAll()
                .antMatchers(GET,"/person/id/**").hasAnyAuthority("USER")
                .antMatchers(GET,"/person/name/**").hasAnyAuthority("USER")
                .anyRequest().authenticated()
                .and()
                .addFilter(customAuthenticationFilter)
                .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers( "/h2-console/**", "/login");
    }
}
