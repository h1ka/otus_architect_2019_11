package ru.otus.shop.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(value = "Параметры сортировки")
public class SortParams {

    @ApiParam(value = "Поле для сортировки", example = "name", required = true)
    @NotBlank
    private String field;

    @ApiParam(value = "Направление сортировки", example = "ASC")
    private Sort.Direction direction;

    public SortParams() {
        direction = Sort.Direction.ASC;
    }

    public SortParams(String field) {
        this.field = field;
        direction = Sort.Direction.ASC;
    }

}
