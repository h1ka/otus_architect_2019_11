package ru.otus.shop.web.request.products;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.shop.web.request.PaginationParams;
import ru.otus.shop.web.request.SortParams;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("Запрос на получение списка продуктов по фильтру")
public class ProductGetByFilterRequest {

    @NotNull
    @Valid
    @ApiModelProperty(value = "Параметры фильтрации", required = true)
    ProductFilter filter;

    @Valid
    @ApiModelProperty(value = "Параметры пагинации", position = 1)
    PaginationParams pagination;

    @Valid
    @ApiModelProperty(value = "Параметры сортировки", position = 2)
    SortParams sort;

    public ProductGetByFilterRequest() {
        filter = new ProductFilter();
        pagination = new PaginationParams();
    }

}
