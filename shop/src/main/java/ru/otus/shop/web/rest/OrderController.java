package ru.otus.shop.web.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.otus.shop.db.entity.Order;
import ru.otus.shop.db.entity.Product;
import ru.otus.shop.db.entity.ProductQuantity;
import ru.otus.shop.dto.OrderDTO;
import ru.otus.shop.mapper.OrderMapper;
import ru.otus.shop.service.OrderService;
import ru.otus.shop.service.ProductService;
import ru.otus.shop.web.request.orders.OrderCreateRequest;
import ru.otus.shop.web.request.orders.OrderUpdateRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    private ProductService productService;

    private OrderMapper mapper;

    @GetMapping
    @ApiOperation("Возвращает список заказов")
    public ResponseEntity<List<OrderDTO>> getByFilter() {
        List<Order> allOrders = orderService.getAllOrders();
        return ResponseEntity.ok(mapper.createDTOs(allOrders));
    }

    @PostMapping
    @ApiOperation("Создание заказа")
    public ResponseEntity<OrderDTO> create(@Valid @NotNull @ApiParam("Запрос создания заказа") @RequestBody OrderCreateRequest request) {
        Order order = Order.builder()
                .products(request.getProducts().stream().map(v -> {
                    Product product = productService.getById(v.getProductId());
                    return ProductQuantity.builder()
                            .productId(product.getId())
                            .quantity(v.getQuantity()).build();
                }).collect(Collectors.toList()))
                .dateCreated(LocalDateTime.now())
                .status("Заказ создан")
                .build();

        OrderDTO orderDTO = mapper.toDto(orderService.create(order));
        return ResponseEntity.ok(orderDTO);
    }

    @PutMapping("/{orderId}")
    @ApiOperation("Обновление заказа")
    public ResponseEntity<OrderDTO> update(@NotNull @PathVariable Long orderId,
                                           @Valid @NotNull @RequestBody @ApiParam("Запрос обновления заказа") OrderUpdateRequest request) {
        Order order = orderService.getById(orderId);
        order.setProducts(request.getProducts().stream().map(v -> {
            Product product = productService.getById(v.getProductId());
            return ProductQuantity.builder().productId(product.getId())
                    .quantity(v.getQuantity()).build();
        }).collect(Collectors.toList()));
        order.setDateUpdate(LocalDateTime.now());
        OrderDTO orderDTO = mapper.toDto(orderService.updateById(orderId, order));
        return ResponseEntity.ok(orderDTO);
    }
}
