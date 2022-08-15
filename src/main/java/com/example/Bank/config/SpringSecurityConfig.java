package com.example.Bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
  @Bean
  PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder(12);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .inMemoryAuthentication()
        .withUser("user2")
        .password("$2a$12$2WmnMo70aakHkctkJ6y9AucZNbC7BFXuhfncUUwq6GPX9mEE62C5K")//user2
        .roles("USER")
        .and()
        .withUser("admin2")
        .password("$2a$12$CSytYG7cnJ9HGWVMd8eXAec36QvaCQlPifJacbGQsTW4Fz5.Ql1oa")//admin2
        .roles("ADMIN");

  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable()
        .authorizeRequests()
        .antMatchers("/delete**", "/update**")
        .hasAnyRole("ADMIN")
        .antMatchers("/bankAccounts","/personalDatas" )
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin();
  }
}
