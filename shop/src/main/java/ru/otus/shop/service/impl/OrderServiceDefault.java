package ru.otus.shop.service.impl;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.otus.shop.db.entity.Order;
import ru.otus.shop.db.repository.OrderRepository;
import ru.otus.shop.exception.DocumentNotFoundException;
import ru.otus.shop.service.OrderService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderServiceDefault implements OrderService {

    private OrderRepository orderRepository;

    @Override
    public List<Order> getByFilter() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Order getById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        return orderOptional.orElseThrow(() -> new DocumentNotFoundException(Order.class.getName(), orderId));
    }

    @Override
    public List<Order> getAllOrders() {
        return Lists.newArrayList(orderRepository.findAll());
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateById(Long orderId, Order order) {
        Order orderEntity = getById(orderId);
        BeanUtils.copyProperties(order, orderEntity, "id");
        return orderRepository.save(orderEntity);
    }
}
