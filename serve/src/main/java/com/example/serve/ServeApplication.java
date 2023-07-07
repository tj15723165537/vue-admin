package com.example.serve;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.serve.mapper")
public class ServeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServeApplication.class, args);
    }
}
