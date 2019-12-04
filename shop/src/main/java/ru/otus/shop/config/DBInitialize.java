package ru.otus.shop.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.shop.db.entity.Product;
import ru.otus.shop.db.repository.ProductRepository;

@Configuration
@AllArgsConstructor
public class DBInitialize {

    ProductRepository productRepository;
    @Bean
    public void init1() {
        Product product1 = Product.builder().name("Чай Пуэр")
                .count(10)
                .price(500)
                .build();

        Product product2 = Product.builder().name("Да Хун Пао")
                .count(50)
                .price(800)
                .build();

        productRepository.save(product1);
        productRepository.save(product2);
    }
}
