package com.userLogin.security;

import com.userLogin.security.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfigure extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(customUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().disable()
                .authorizeRequests()
                .antMatchers("/api/public/authenticate").permitAll()
                .antMatchers("/api/public/test1").permitAll()
                .antMatchers("/api/public/test2").permitAll()
                .antMatchers("/api/public/user/create").permitAll()
                .antMatchers("/api/public/user/delete/{id}").permitAll()
                .antMatchers("/api/public/user/update").permitAll()
                .antMatchers("/api/public/user/All/").permitAll()
                .antMatchers("/api/public/user/all/").permitAll()
                .antMatchers("/api/public/user/getUserByFirstName/").permitAll()
                .antMatchers("/api/public/items/create").permitAll()
                .antMatchers("/api/public/items/all/").permitAll()
                .antMatchers("/api/public/items/all/{id}").permitAll()
                .antMatchers("/api/public/items/itemByTitle/{title}").permitAll()
                .antMatchers("/api/public/items/itemById/{id}").permitAll()
                .antMatchers("/api/public/items/findItemById/{id}").permitAll()
                .antMatchers("/api/public/items/search/").permitAll()
                .antMatchers("/api/public/favorites/add").permitAll()
                .antMatchers("/api/public/favorites/remove/{id}").permitAll()
                .antMatchers("/api/public/favorites/user/{userId}").permitAll()
                .antMatchers("/api/public/favorites/item/{itemId}").permitAll()
                .antMatchers("/api/public/orders/{userId}").permitAll()
                .antMatchers("/api/public/orders/user/{userId}").permitAll()
                .antMatchers("/api/public/orders/modify/{orderId}").permitAll()
                .antMatchers("/api/public/orders/history/{userId}").permitAll()
                .antMatchers("/api/public/orders/updateStatus/{id}").permitAll()
                .antMatchers("/api/public/orders/updateItem").permitAll()
                .antMatchers("/api/public/orders/delete/{userId}").permitAll()
                .antMatchers("/api/public/orders/create").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}


