package ru.otus.shop.db.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Сущность заказ
 */
@Data
@Builder
@Entity(name = "orders")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Order implements SEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateCreated;

    private String status;

    @Valid
    private List<ProductQuantity> products = new ArrayList<>();

}
