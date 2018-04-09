package com.gobear;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityDemoApplication {

    public static void main(String[] args) {
        System.out.println("Springboot args: " + args);
        SpringApplication.run(SpringSecurityDemoApplication.class, args);
    }
}
