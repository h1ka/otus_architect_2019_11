package ru.otus.shop.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.otus.shop.db.entity.Product;
import ru.otus.shop.dto.ProductDTO;
import ru.otus.shop.mapper.ProductMapper;
import ru.otus.shop.service.ProductService;
import ru.otus.shop.web.request.products.ProductCreateRequest;
import ru.otus.shop.web.request.products.ProductGetByFilterRequest;
import ru.otus.shop.web.request.products.ProductUpdateRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/products")
@Api("Выполнение опираций с продуктами")
public class ProductController {
    private ProductService productService;

    private ProductMapper productMapper;

    @GetMapping
    @ApiOperation("Получение списка всех продуктов по фильтру")
    public ResponseEntity<Page<ProductDTO>> getByFilter(@Valid @ApiParam("Фильтр длля продуктов") ProductGetByFilterRequest request) {
        Page<Product> all = productService.getByFilter(request);
        Page<ProductDTO> dtOs = productMapper.createDTOs(all);

        return ResponseEntity.ok(dtOs);
    }

    @GetMapping("/{productId}")
    @ApiOperation("Получение продукта по его идентификатору")
    public ResponseEntity<ProductDTO> getById(@NotNull @PathVariable @ApiParam("Идентификатор продукта") Long productId) {
        Product product = productService.getById(productId);
        ProductDTO productDTO = productMapper.toDto(product);
        return ResponseEntity.ok(productDTO);
    }

    @PostMapping
    @ApiOperation("Создание нового продукста")
    public ResponseEntity<ProductDTO> create(@NotNull @RequestBody ProductCreateRequest request) {
        Product newProduct = productMapper.toEntity(request);
        Product product = productService.create(newProduct);
        ProductDTO productDTO = productMapper.toDto(product);
        return ResponseEntity.ok(productDTO);
    }


    @PutMapping("/{productId}")
    @ApiOperation("Обновление существующего продукта")
    public ResponseEntity<ProductDTO> update(@NotNull @PathVariable @ApiParam("Идентификатор продукта") Long productId,
                                             @NotNull @RequestBody @ApiParam("Запрос на обновление продукта") ProductUpdateRequest request) {
        productService.getById(productId);

        Product updateProduct = productMapper.toEntity(request);
        Product product = productService.update(productId, updateProduct);

        ProductDTO productDTO = productMapper.toDto(product);
        return ResponseEntity.ok(productDTO);
    }
}
