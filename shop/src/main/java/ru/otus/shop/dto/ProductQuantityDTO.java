package ru.otus.shop.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Количеств ед. товара")
public class ProductQuantityDTO implements SDto {

    @ApiModelProperty("Идентификатор товара")
    private String productId;

    @ApiModelProperty("Количество")
    private int quantity;
}
