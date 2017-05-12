package com.alucard.config;

import com.alucard.service.UserSecurityService;

import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Alucard on 12-May-17.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private static final String[] PUBLIC_MATCHES = {
          "/css/**",
          "/js/**",
          "/image/**",
          "/book/**",
          "/user/**"
  };

  @Autowired
  private Environment env;

  @Autowired
  private UserSecurityService userSecurityService; // todo

  private BCryptPasswordEncoder passwordEncoder() {
    return SecurityUtility.passwordEncoder(); // todo
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().cors().disable().httpBasic()
            .and().authorizeRequests().antMatchers(PUBLIC_MATCHES).permitAll() // allow these mappings
            .anyRequest().authenticated(); // secure the rest
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
  }
}