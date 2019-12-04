package ru.otus.shop.web.request.products;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.PositiveOrZero;

@Data
@ApiModel("Фильтр продукта")
public class ProductFilter {
    private String name;

    @PositiveOrZero
    private Long count;

    private Double minPrice;

    private Double maxPrice;
}
