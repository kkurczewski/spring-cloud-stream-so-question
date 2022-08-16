package com.example;

import java.util.function.Consumer;
import java.util.function.Function;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Function<String, String> handle() {
        return s -> {
            System.out.println("s = " + s);
            throw new RuntimeException("Intentional");
        };
    }

    @Bean
    public Consumer<Object> errorHandler() {
        return o -> System.out.println("o = " + o);
    }
}
