package ru.otus.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ShopApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ShopApp.class, args);
    }
}
