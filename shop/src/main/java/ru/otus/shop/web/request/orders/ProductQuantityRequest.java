package ru.otus.shop.web.request.orders;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Количеств ед. товара")
public class ProductQuantityRequest {

    @ApiModelProperty("Идентификатор товара")
    private Long productId;

    @ApiModelProperty("Количество")
    private int quantity;
}

