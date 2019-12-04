package ru.otus.shop.web.request.products;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel("Запрос создания продукта")
public class ProductCreateRequest {


    @NotBlank
    private String name;

    private long count;

    private double price;

}