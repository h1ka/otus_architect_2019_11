package ru.otus.shop.db.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import ru.otus.shop.enums.OrderStatus;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateCreated;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateUpdate;

    @NotNull
    private OrderStatus status;

    @OneToOne(cascade = ALL)
    private Address address;

    @Valid
    @OneToMany(cascade = ALL)
    private List<ProductQuantity> products = new ArrayList<>();

}
