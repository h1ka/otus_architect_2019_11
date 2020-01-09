package ru.otus.shop.web.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.shop.db.entity.Order;
import ru.otus.shop.db.entity.Product;
import ru.otus.shop.db.entity.ProductQuantity;
import ru.otus.shop.dto.OrderDTO;
import ru.otus.shop.mapper.OrderMapper;
import ru.otus.shop.service.OrderService;
import ru.otus.shop.service.ProductService;
import ru.otus.shop.web.request.orders.OrderCreateRequest;

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

    @GetMapping("/all")
    @ApiOperation("Возвращает список всех заказов")
    public ResponseEntity<List<OrderDTO>> getAll() {
        List<Order> allOrders = orderService.getAllOrders();
        return ResponseEntity.ok(mapper.createDTOs(allOrders));
    }

    @PostMapping
    @ApiOperation("Создание заказа")
    public ResponseEntity<OrderDTO> create(@Valid @NotNull @ApiParam("Запрос создания заказа") OrderCreateRequest request) {
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

}
