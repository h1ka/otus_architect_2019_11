package ru.otus.shop.web.request.orders;

import lombok.Data;

import java.util.List;

@Data
public class OrderUpdateRequest {

    private List<ProductQuantityRequest> products;
}
