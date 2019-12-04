package ru.otus.shop.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
@ApiModel(value = "Параметры пагинации")
public class PaginationParams {

    @ApiParam(value = "Номер страницы (нумерация с 0)", example = "0")
    @PositiveOrZero
    private int page;

    @ApiParam(value = "Количество элементов на странице", example = "20")
    @Positive
    private int count;

    public PaginationParams() {
        page = 0;
        count = 20;
    }

}
