package com.sai.UsersMS.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurity {


    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
       return  http
               .csrf(c -> c.disable())
               .authorizeHttpRequests(ahr -> ahr.requestMatchers(HttpMethod.POST,"/users").permitAll())
               .authorizeHttpRequests(ahr -> ahr.requestMatchers(HttpMethod.GET,"/users/status/check").permitAll())
               .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
               .build();

    }


    @Bean// I did this for h2 console
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
    }


}
