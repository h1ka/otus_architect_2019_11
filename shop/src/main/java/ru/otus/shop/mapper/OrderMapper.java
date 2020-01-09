package ru.otus.shop.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.otus.shop.db.entity.Order;
import ru.otus.shop.dto.OrderDTO;
import ru.otus.shop.web.request.orders.OrderCreateRequest;

import java.util.Objects;

@Component
public class OrderMapper extends AbstractSMapper<Order, OrderDTO> {
    protected OrderMapper(ModelMapper mapper) {
        super(mapper, Order.class, OrderDTO.class);
    }

}
