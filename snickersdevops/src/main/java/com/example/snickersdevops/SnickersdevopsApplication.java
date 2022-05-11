package com.example.snickersdevops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example.snickersdevops")
public class SnickersdevopsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnickersdevopsApplication.class, args);
    }

}
