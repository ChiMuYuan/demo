package com.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private TokenFilter tokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/error").permitAll()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()

                .cors().disable()
                .csrf().disable()
                // 此步会在登录后丢失认证信息，默认是session调取，我们关掉session后需要在后面 放入认证信息
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                // 一定要在AnonymousAuthenticationFilter 添加过滤器，放入Authentication认证信息
                // 或者是使用RememberMe也可以放入认证信息 .rememberMe()官方提供的token实现
                .addFilterAt(tokenFilter, AnonymousAuthenticationFilter.class)

                .build();

    }

}
