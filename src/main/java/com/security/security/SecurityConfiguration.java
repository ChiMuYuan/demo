package com.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfiguration {

    @Autowired
    private MyUsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                .accessDeniedHandler((request, response, ex) -> {
                    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    PrintWriter out = response.getWriter();
                    out.write("securityFilterChain - accessDenied");
                    out.flush();
                    out.close();
                })
                .authenticationEntryPoint((request, response, ex) -> {
                    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    PrintWriter out = response.getWriter();
                    out.write("securityFilterChain - authenticationEntry :\n" + ex.toString());
                    out.flush();
                    out.close();
                })
                .and()

                .authorizeRequests()
                .anyRequest().authenticated()
                .and()

                .addFilterAt(myUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .cors().disable()
                .csrf().disable()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }

}
