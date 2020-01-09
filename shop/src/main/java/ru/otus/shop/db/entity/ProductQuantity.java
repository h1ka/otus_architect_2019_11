package ru.otus.shop.db.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Entity(name = "product_quantity")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductQuantity {
    @NotBlank
    private Long productId;

    @NotNull
    private int quantity;
}
