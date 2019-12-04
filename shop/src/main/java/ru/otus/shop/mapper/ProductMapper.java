package ru.otus.shop.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.otus.shop.db.entity.Product;
import ru.otus.shop.dto.ProductDTO;
import ru.otus.shop.web.request.products.ProductCreateRequest;
import ru.otus.shop.web.request.products.ProductUpdateRequest;

import java.util.Objects;

@Component
public class ProductMapper extends AbstractSMapper<Product, ProductDTO> {
    public ProductMapper(ModelMapper mapper) {
        super(mapper, Product.class, ProductDTO.class);
    }

    public Product toEntity(ProductCreateRequest request) {
        return Objects.isNull(request) ? null : mapper.map(request, Product.class);
    }

    public Product toEntity(ProductUpdateRequest request) {
        return Objects.isNull(request) ? null : mapper.map(request, Product.class);
    }
}
