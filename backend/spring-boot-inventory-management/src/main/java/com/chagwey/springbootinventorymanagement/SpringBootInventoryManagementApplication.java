package com.chagwey.springbootinventorymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


//@EnableWebMvc
//@EnableSwagger2
@SpringBootApplication
public class SpringBootInventoryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootInventoryManagementApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
