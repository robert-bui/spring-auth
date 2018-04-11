package com.gobear.security;

import com.gobear.security.service.impl.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyBasicAuthenticationEntryPoint authenEntryEndpoint;
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomAuthenProvider authenProvider;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenProvider);
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/", "/home", "/user/*", "/token/*", "/cache/*").permitAll()
                .anyRequest().authenticated()
                /*.and().httpBasic().authenticationEntryPoint(authenEntryEndpoint);*/
                .and().formLogin().loginPage("/login").permitAll()
                .and().formLogin().successHandler(loginSuccessHandler)
                .and().logout().permitAll();
        http.addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class);

    }


}
