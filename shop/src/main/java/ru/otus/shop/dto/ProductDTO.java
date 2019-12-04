package ru.otus.shop.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel("Продукт")
public class ProductDTO implements SDto {

    @Id
    private Long id;

    @NotBlank
    private String name;

    private long count;

    private double price;

}
