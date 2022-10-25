package com.chagwey.springbootinventorymanagement.config.auth;

import com.chagwey.springbootinventorymanagement.filter.ApplicationRequestFilter;
import com.chagwey.springbootinventorymanagement.filter.JWTAccessDeniedHandler;
import com.chagwey.springbootinventorymanagement.filter.JWTAuthenticationEntryPoint;
import com.chagwey.springbootinventorymanagement.service.auth.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.chagwey.springbootinventorymanagement.utils.constants.SecurityConstant.PUBLIC_URLS;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    private UserDetailsServiceImpl userDetailsServiceImpl;
    private ApplicationRequestFilter applicationRequestFilter;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private JWTAccessDeniedHandler jwtAccessDeniedHandler;

    private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    public SecurityConfiguration(UserDetailsServiceImpl userDetailsServiceImpl,
                                 ApplicationRequestFilter applicationRequestFilter,
                                 BCryptPasswordEncoder bCryptPasswordEncoder,
                                 JWTAccessDeniedHandler jwtAccessDeniedHandler,
                                 JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.applicationRequestFilter = applicationRequestFilter;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests().antMatchers(PUBLIC_URLS)
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().accessDeniedHandler(jwtAccessDeniedHandler)
                .authenticationEntryPoint(jwtAuthenticationEntryPoint);


        http.addFilterBefore(applicationRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}
