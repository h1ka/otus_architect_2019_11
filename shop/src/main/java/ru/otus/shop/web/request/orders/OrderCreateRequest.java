package ru.otus.shop.web.request.orders;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel("Запрос на создание заказа")
public class OrderCreateRequest {

    @Valid
    private List<ProductQuantityRequest> products = new ArrayList<>();
}
