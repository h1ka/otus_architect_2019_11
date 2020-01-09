package ru.otus.shop.web.request.orders;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("Запрос обновление заказа")
public class OrderUpdateRequest {

    @ApiModelProperty("Список товаров")
    private List<ProductQuantityRequest> products;
}
