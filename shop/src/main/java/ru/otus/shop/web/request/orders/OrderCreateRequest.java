package ru.otus.shop.web.request.orders;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
@ApiModel("Запрос на создание заказа")
public class OrderCreateRequest {

    @Valid
    private List<ProductQuantityRequest> products;
}
