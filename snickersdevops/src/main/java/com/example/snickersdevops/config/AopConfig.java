package com.example.snickersdevops.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy

@ComponentScan("com.example.snickersdevops.service")
public class AopConfig {

}
