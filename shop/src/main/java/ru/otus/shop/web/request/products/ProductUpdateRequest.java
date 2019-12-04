package ru.otus.shop.web.request.products;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel("Запрос создания продукта")
public class ProductUpdateRequest {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    private long count;

    private double price;

}